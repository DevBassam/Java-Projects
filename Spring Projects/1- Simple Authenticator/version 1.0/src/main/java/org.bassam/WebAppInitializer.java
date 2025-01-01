package org.bassam;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        var ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfigApp.class);
        servletContext.addListener(new ContextLoaderListener(ctx));
        ServletRegistration.Dynamic appServlet = servletContext.addServlet("mvc",
                new DispatcherServlet(new GenericWebApplicationContext()));
        appServlet.setLoadOnStartup(1); // use it to make sure that it initialized in startup not after 1st request
        appServlet.addMapping("/"); // to ensure all requests get here first to make it a front controller
    }
}
