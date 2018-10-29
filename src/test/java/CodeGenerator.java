import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

    public static void main(String[] args) {
        //需要生成的表名所在位置

        String [] strArr = new String[]{"area","counter","friendship","funds","funds_details",
        "hobby","member","opinion","orders","permission","product","product_details",
        "role_permission_relation","sku","state","terms","user","user_role","user_role_relation","wall"};
        String url = "jdbc:mysql://localhost:3306/test";
        String driverName = "com.mysql.jdbc.Driver";
        String  username = "root";
        String password = "123456";

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        String projectPath = System.getProperty("user.dir");
        mpg.setGlobalConfig(globalConfig(projectPath));

        //数据源配置
        mpg.setDataSource(dataSourceConfig(DbType.MYSQL,url,driverName,username,password));

        //包配置
        PackageConfig pc = packageConfig();
        mpg.setPackageInfo(pc);

        // 自定义配置
        /*InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);*/

        //模板配置
        //mpg.setTemplate(new TemplateConfig().setXml(null));

        //策略配置
        mpg.setStrategy(strategyConfig(pc,strArr));
        //模板引擎 freemarker,默认 velocity
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        mpg.execute();
    }

    public static StrategyConfig strategyConfig(PackageConfig pc,String[] strArr) {
        // 策略配置 数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表
        StrategyConfig strategy = new StrategyConfig();
        //表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //字段名生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //表前缀
        //strategy.setTablePrefix(pc.getModuleName() + "_");

        // 需要生成的表
        strategy.setInclude(strArr);
        // 排除生成的表
        // strategy.setExclude(new String[]{"test"});

        //所有生成实体的父类
        //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        //实体是否使用lombok注解
        strategy.setEntityLombokModel(true);
        //restful风格
        strategy.setRestControllerStyle(true);
        //所有控制器的父类
        //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");

        //自定义实体，公共字段
        //strategy.setSuperEntityColumns(new String[]{"id","age"});
        //【实体】是否为构建者模型（默认 false）
        //strategy.setEntityBuilderModel(false);
        // Boolean类型字段是否移除is前缀处理
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        strategy.setControllerMappingHyphenStyle(true);

        return strategy;
    }
    /**
     * 全局配置
     * @return
     */
    public static GlobalConfig globalConfig(String projectPath) {
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //生成文件的输出目录,默认值：D 盘根目录
        gc.setOutputDir(projectPath + "/src/main/java");
        //是否覆盖已有文件
        gc.setFileOverride(true);
        //是否在xml中添加二级缓存配置
        gc.setEnableCache(true);
        //开发人员
        gc.setAuthor("yuyi");
        //开启 Kotlin 模式
        gc.setKotlin(false);
        //是否打开输出目录
        gc.setOpen(false);
        //开启 swagger2 模式
        gc.setSwagger2(false);
        //开启 ActiveRecord 模式
        gc.setActiveRecord(false);
        //开启 BaseResultMap
        gc.setBaseResultMap(true);
        //开启 baseColumnList
        gc.setBaseColumnList(true);
        //时间类型对应策略,默认值：TIME_PACK
        gc.setDateType(DateType.TIME_PACK);
        /**
         * 注意事项:
         * 如下配置 %s 为占位符
         * #
         * # entityName
         * 实体命名方式
         * 默认值：null 例如：%sEntity 生成 UserEntity
         * # mapperName
         * mapper 命名方式
         * 默认值：null 例如：%sDao 生成 UserDao
         * # xmlName
         * Mapper xml 命名方式
         * 默认值：null 例如：%sDao 生成 UserDao.xml
         * # serviceName
         * service 命名方式
         * 默认值：null 例如：%sBusiness 生成 UserBusiness
         * # serviceImplName
         * service impl 命名方式
         * 默认值：null 例如：%sBusinessImpl 生成 UserBusinessImpl
         * # controllerName
         * controller 命名方式
         * 默认值：null 例如：%sAction 生成 UserAction
         * # idType
         * 指定生成的主键的ID类型
         * 默认值：null
         */
        gc.setEntityName("%s");
        gc.setMapperName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        return gc;
    }

    /**
     * 数据源配置
     * @return
     */
    public static DataSourceConfig dataSourceConfig(DbType dbType,String url,String driverName,String username,String password) {
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        /*dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                return super.processTypeConvert(fieldType);
            }
        });*/
        //数据库类型
        dsc.setDbType(dbType);
        //驱动连接URL
        dsc.setUrl(url);
        //数据库 schema name
        //dsc.setSchemaName("public");
        //驱动名称
        dsc.setDriverName(driverName);
        //数据库登录名
        dsc.setUsername(username);
        //连接密码
        dsc.setPassword(password);
        return dsc;
    }

    /**
     * 包配置
     * @return
     */
    public static PackageConfig packageConfig() {
        // 包配置
        PackageConfig pc = new PackageConfig();
        //全局父包名
        pc.setParent("com.zr.ttappdemo");
        //实体所在包名
        pc.setEntity("model.entity");
        //mapper接口所在包名
        pc.setMapper("dao");
        //service接口所在包名
        pc.setService("service");
        //service实现类所在包名
        pc.setServiceImpl("service.impl");
        //控制器所在包名
        pc.setController("controller");
        //xml文件所在包名
        pc.setXml("mapper");
        //模块名称，单独生成模块时使用！！！！！！！！！！！
        //pc.setModuleName("usermodule");

        return pc;
    }

}