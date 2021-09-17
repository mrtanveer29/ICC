package com.tanveer;

import com.tanveer.config.SecurityConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInit implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext=new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class, SecurityConfig.class);
        rootContext.refresh();

        servletContext.addListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext servletRegisterer=new AnnotationConfigWebApplicationContext();
        servletRegisterer.register(WebMvcConfig.class);
        ServletRegistration.Dynamic registration=servletContext.addServlet("frontliner",new DispatcherServlet(servletRegisterer));

        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
