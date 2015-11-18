package ua.upsite.nso.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ua.upsite.nso.PreSecurityLoggingFilter;

import javax.servlet.*;

@SuppressWarnings("unused")
@Order(1)
public class FrameworkBootstrap implements WebApplicationInitializer
{
    private static final Logger log = LogManager.getLogger();

    @Override
    public void onStartup(ServletContext container) throws ServletException
    {
        log.info("Executing framework bootstrap.");

        container.getServletRegistration("default")
                .addMapping("/resource/*", "*.css", "*.js", "*.png", "*.gif", "*.jpg", "*.ico");

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootContextConfiguration.class);
        container.addListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(ServletContextConfiguration.class);
        ServletRegistration.Dynamic dispatcher = container.addServlet(
                "springWebDispatcher", new DispatcherServlet(webContext)
        );
        dispatcher.setLoadOnStartup(1);
        dispatcher.setMultipartConfig(new MultipartConfigElement(
                null, 20_971_520L, 41_943_040L, 512_000
        ));
        dispatcher.addMapping("/");


        FilterRegistration.Dynamic registration = container.addFilter(
                "preSecurityLoggingFilter", new PreSecurityLoggingFilter()
        );
        registration.addMappingForUrlPatterns(null, false, "/*");
    }
}
