package ua.upsite.nso.config;

import com.lyncode.jtwig.mvc.JtwigViewResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;


@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = "ua.upsite.nso.controller",
        useDefaultFilters = false,
        includeFilters = @ComponentScan.Filter(Controller.class)
)
public class ServletContextConfiguration extends WebMvcConfigurerAdapter
{

//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/view/jsp/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }

    @Bean
    public ViewResolver viewResolver() {
        JtwigViewResolver viewResolver = new JtwigViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/twig/");
        viewResolver.setSuffix(".twig");
        return viewResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    @Bean
    public LocaleResolver localeResolver(){
        CookieLocaleResolver resolver = new CookieLocaleResolver();
//        resolver.setDefaultLocale(new Locale("en"));
        resolver.setCookieName("locale");
        resolver.setCookieMaxAge(4800);
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("locale");
        registry.addInterceptor(interceptor);
    }
}

