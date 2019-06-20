//package com.pchome.config;
//
//import java.util.HashMap;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//  entityManagerFactoryRef = "mysqlEntityManagerFactory", 
//  transactionManagerRef="mysqlTransactionManager",
//  basePackages = {"th.co.pchome.dus.mysql.bend.repository"}
//)
//public class MySqlConfig {
//	
//  @Value("${mysql.bend.jndi-name}")
//  private String mysqlJndi;
//
//  @Bean(name="mysqlDataSource")
//  public DataSource mysqlDatasource() {
//	  String active = System.getProperty("spring.profiles.active");
//	  if("localhost".equals(active)) {
//		  DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	  	  dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//	 	  dataSource.setUrl("jdbc:mysql://192.168.21.53:3306/thai_backend");
//		  dataSource.setUsername("c2cweb");
//		  dataSource.setPassword("web1234");
//		  return dataSource;
//	  }
//	  else {
//		  JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
//		  DataSource dataSource = dsLookup.getDataSource(mysqlJndi);
//		  return dataSource; 
//	  }
//  }
// 
//  
//  @Bean(name = "mysqlEntityManagerFactory")
//  public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory( EntityManagerFactoryBuilder builder) {
//	  	DataSource dataSource = mysqlDatasource();
//  	
//	  	JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//	  	LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
//	  	entityManager.setPackagesToScan(new String[]{"th.co.pchome.dus.mysql.bend.entity"});
//	  	entityManager.setDataSource(dataSource);
//	  	entityManager.setJpaVendorAdapter(vendorAdapter);
//	  	entityManager.setPersistenceUnitName("mysqlBend");
//	  	HashMap<String, Object> properties = new HashMap<String, Object>();
//	  	properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//		properties.put("hibernate.naming.physical-strategy", "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
//		entityManager.setJpaPropertyMap(properties);
//	  	return entityManager;
//  }
//  
//  @Bean(name = "mysqlTransactionManager")
//  public PlatformTransactionManager mysqlTransactionManager(EntityManagerFactoryBuilder builder) {
//      return new JpaTransactionManager(mysqlEntityManagerFactory(builder).getObject());
//  }
//}
