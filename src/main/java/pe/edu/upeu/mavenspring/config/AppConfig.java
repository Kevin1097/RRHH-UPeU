/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.mavenspring.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import pe.edu.upeu.mavenspring.dao.UsuarioDAO;

/**
 *
 * @author UPEU
 */
@Configuration
@ComponentScan(basePackages="pe.edu.upeu.mavenspring")
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter{
   @Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	} 
        
        @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/**");
		registry.addResourceHandler("/jspf/**").addResourceLocations("/resources/*");
	}

        
        @Bean
	public static DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("GrupoPrestamo");
		dataSource.setPassword("grupoprestamo");
		return dataSource;
	}
        @Bean
        public UsuarioDAO geUsuarioDAO()
        {
            return new UsuarioDAO(getDataSource());
        }
        
       
//        @Bean
//	public PrestamoDAO getPrestamoDAO() {
//		return new PrestamoDAO(getDataSource());
//	}
//        
//        @Bean
//	public ReservaDAO getReservaDAO() {
//		return new ReservaDAO(getDataSource());
//	}

}