/**
 *
 */
package com.zr.ttappdemo.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

/**
 * @author yuyi
 * @description 自定义登录成功处理
 * @date 22:37 2018/10/26
 */
@Component("appAuthenticationSuccessHandler")
@Slf4j
public class AppAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Autowired
	private ClientDetailsService clientDetailsService;

	@Resource
	private AuthorizationServerTokenServices authorizationServerTokenServices;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
		String header = request.getHeader("Authorization");

		if (header == null || !header.toLowerCase().startsWith("basic ")) {
			throw new UnapprovedClientAuthenticationException("请求头中午client信息");
		}

		//解码请求头basic串
		String[] tokens = extractAndDecodeHeader(header, request);
		assert tokens.length == 2;

		String clientId = tokens[0];
		String clientSecret = tokens[1];

		ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);

		if(clientDetails == null) {
			throw new UnapprovedClientAuthenticationException("clientId对应的配置信息不存在：" + clientId);
		}

		if(!passwordEncoder.matches(clientSecret,clientDetails.getClientSecret())) {
			throw new UnapprovedClientAuthenticationException("clientSecret不匹配 ： " + clientSecret);
		}
		//自定义登录模式 custom
		TokenRequest tokenRequest = new TokenRequest(null,clientId,clientDetails.getScope(),"custom");

		OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);

		OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request,authentication);

		OAuth2AccessToken token = authorizationServerTokenServices.createAccessToken(oAuth2Authentication);

		response.setContentType("application/json;charset=UTF-8");

		response.getWriter().write(objectMapper.writeValueAsString(token));
	}


	private String[] extractAndDecodeHeader(String header, HttpServletRequest request)
		throws IOException {

		byte[] base64Token = header.substring(6).getBytes("UTF-8");
		byte[] decoded;
		try {
			decoded = Base64.getDecoder().decode(base64Token);
		}
		catch (IllegalArgumentException e) {
			throw new BadCredentialsException(
					"Failed to decode basic authentication token");
		}

		String token = new String(decoded, "UTF-8");

		int deLim = token.indexOf(":");

		if (deLim == -1) {
			throw new BadCredentialsException("Invalid basic authentication token");
		}
		return new String[] { token.substring(0, deLim), token.substring(deLim + 1) };
	}
}
