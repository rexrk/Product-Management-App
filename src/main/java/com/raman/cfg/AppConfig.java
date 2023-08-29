package com.raman.cfg;

import com.raman.entity.Product;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration.Dynamic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;

@EnableAspectJAutoProxy
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.raman.dao", "com.raman.web.controllers", "com.raman.aspects"})
@EnableWebMvc
@Configuration
public class AppConfig implements WebApplicationInitializer, WebMvcConfigurer {

    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.pass}")
    private String pass;


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx;
        ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);

        Dynamic servlet = servletContext.addServlet("ds", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }


    private SessionFactory factory;
    @Bean("sf")
    public SessionFactory factory() {
        if(factory == null) {
            Properties props = new Properties();
            props.setProperty("hibernate.connection.driver", driverClassName);
            props.setProperty("hibernate.connection.url", url);
            props.setProperty("hibernate.connection.username", user);
            props.setProperty("hibernate.connection.password", pass);
            props.setProperty("hibernate.h2ddl.auto", "update");

            org.hibernate.cfg.Configuration cnf = new org.hibernate.cfg.Configuration();
            cnf.setProperties(props);
            cnf.addAnnotatedClass(Product.class);

            StandardServiceRegistry service = cnf.getStandardServiceRegistryBuilder().applySettings(props).build();
            factory = cnf.buildSessionFactory(service);
        }
        return factory;
    }

    @Bean("ssn")
    public Session session(SessionFactory sessionFactory) {
        return sessionFactory.openSession();
    }

}