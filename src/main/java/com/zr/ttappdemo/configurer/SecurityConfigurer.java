package com.zr.ttappdemo.configurer;

import com.zr.ttappdemo.core.AppAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * @author yuyi
 * @className SecurityConfigurer
 * @description 安全认证配置
 * @date 2018/10/18 22:50
 */
@Configuration
public class SecurityConfigurer{

    /**
     * @author yuyi
     * @description 授权认证配置类
     * @date 23:03 2018/10/18
     */
    @Configuration
    @EnableWebSecurity
    public class AuthenticationConfigurer extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.httpBasic()
                    .and()
                    .authorizeRequests()
                    .anyRequest()
                    .authenticated()
                    //.antMatchers("/oauth/**","/css/**", "/index").permitAll()
                    //.antMatchers("/user/**").hasRole("USER")
                    .and()
                    .csrf().disable()
            ;
        }

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            String password = new BCryptPasswordEncoder().encode("password");
            password = "{bcrypt}" +password;
            auth
                    .inMemoryAuthentication()
                    .withUser("user")
                    .password(password)
                    .roles("USER");


        }
        @Bean
        public PasswordEncoder passwordEncoder() {
            //spring security 5.0 的密码加密生成策略
            return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }

        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }
    }

    /**
     * @author yuyi
     * @description 授权认证服务器配置类
     * @date 23:03 2018/10/18
     */
    @Configuration
    @EnableAuthorizationServer
    public class Oauth2AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

        private final AuthenticationManager authenticationManager;

        private final PasswordEncoder passwordEncoder;

        public Oauth2AuthorizationServerConfigurer(AuthenticationManager authenticationManager,
                                                   PasswordEncoder passwordEncoder) {
            this.authenticationManager = authenticationManager;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.inMemory()
                    .withClient("ttApp")
                    .secret(passwordEncoder.encode("ttApp"))
                    .accessTokenValiditySeconds(7200)
                    .refreshTokenValiditySeconds(72000)
                    .authorizedGrantTypes("refresh_token","password","authorization_code")
                    .scopes("all");
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.authenticationManager(authenticationManager);
        }
    }

    /**
     * @author yuyi
     * @description 资源服务器配置类
     * @date 21:49 2018/10/24
     */
    @Configuration
    @EnableResourceServer
    public class Oauth2ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

        @Autowired
        private AppAuthenticationSuccessHandler appAuthenticationSuccessHandler;

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.formLogin()
                    .successHandler(appAuthenticationSuccessHandler)
                    .and()
                    .authorizeRequests()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .csrf().disable();
        }
    }
}
