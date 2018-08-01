package com.windblue;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

@EnableTransactionManagement
@Controller
@EnableWebMvc
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.windblue.mapper")
@SpringBootApplication
@Configuration
public class BabyshowApplication {

	@Autowired
	Environment env;

	public static void main(String[] args) {
		SpringApplication.run(BabyshowApplication.class, args);
	}

	@RequestMapping("/")
	String home() {
		return "redirect:countries";
	}

	@Bean(destroyMethod = "close")
	public DataSource dataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		/*dataSource.setInitialSize(2);//初始化时建立物理连接个数
        dataSource.setMaxActive(20);//最大连接池数
        dataSource.setMinIdle(0);//最小连接池数量
        dataSource.setValidationQuery("select 1");//用来检测连接是否有效的sql
        dataSource.setTestOnBorrow(false);//申请连接时执行validationQuery检测连接是否有效
        dataSource.setTestWhileIdle(true);//建议配置为true,不影响性能，并且保证安全性
        dataSource.setPoolPreparedStatements(false);//是否缓存preparedStatement,也就是PSCache*/
		return dataSource;
	}

	@Bean
	public PageHelper pageHelper(){
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("helperDialect","mysql");
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "count=countSql");
		pageHelper.setProperties(properties);
		return pageHelper;
	}

}
