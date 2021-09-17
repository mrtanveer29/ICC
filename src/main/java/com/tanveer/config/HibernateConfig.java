package com.tanveer.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.Entity;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.reflections.Reflections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Modifier;
import java.util.Properties;

@Configuration
public class HibernateConfig {
    private SessionFactory sessionFactory = null;
    private Session session = null;

    @Bean
    public SessionFactory createAndGetLocalSessionFactoryBean() {
        if (this.sessionFactory == null) {
            try {
                org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = this.getBuiltProperties("hibernate.properties");
                configuration.setProperties(settings);
                configuration.addPackage("com.tanveer.entities");

                for (Class<?> clazz : (new Reflections("com.tanveer.entities")).getTypesAnnotatedWith(Entity.class)) {
                    if (!Modifier.isAbstract(clazz.getModifiers())) {
                        configuration.addAnnotatedClass(clazz);
                    }
                }

                StandardServiceRegistry serviceRegistry =
                        new StandardServiceRegistryBuilder()
                                .applySettings(settings).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
    @Bean
    public  Session getSession(){
        this.session=createAndGetLocalSessionFactoryBean().getCurrentSession();
        return session !=null? this.session : createAndGetLocalSessionFactoryBean().openSession();
    }

    private Properties getBuiltProperties(String propertyFileName) {
        Properties properties = new Properties();
        InputStream input = HibernateConfig.class.getClassLoader().getResourceAsStream(propertyFileName);
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    public CriteriaBuilder getCriteriaBuilder() {
        Session session = getSession();
        var tx = session.getTransaction();
        if (!tx.isActive()) {
            tx = session.beginTransaction();
        }
        return session.getCriteriaBuilder();
    }
}
