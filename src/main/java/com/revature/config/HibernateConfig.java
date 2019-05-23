package com.revature.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.models.Day;
import com.revature.models.Employee;
import com.revature.models.Shift;
import com.revature.models.ShiftConfig;
import com.revature.models.Week;
import com.revature.models.WeekDays;
import com.revature.models.Users;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	@Value("${spring.datasource.url}")
    private String jdbcURl;

	@Value("${spring.datasource.username}")
    private String dbUsername;

	@Value("${spring.datasource.password}")
    private String dbPassword;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		System.out.println("Configuring sessionFactory bean");
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
		
		factoryBean.setAnnotatedClasses(Shift.class, Employee.class, Day.class, Week.class, ShiftConfig.class, Users.class, WeekDays.class);
		
		factoryBean.setDataSource(getDataSource());
		
		return factoryBean;
	}
	@Bean
	@Inject
	public JpaTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		System.out.println("Configuring transaction manager");
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.getEntityManagerFactory();    //setSessionFactory(sessionFactory);
		return transactionManager;
	}
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		System.out.println("Getting data source");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl(jdbcURl);
		dataSource.setUsername(dbUsername);
		dataSource.setPassword(dbPassword);
		return dataSource;
	}
}
