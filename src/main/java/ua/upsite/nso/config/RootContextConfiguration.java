package ua.upsite.nso.config;

/**
 *  Created by gregory on 11/9/15.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate3.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;
import java.util.Hashtable;
import java.util.Map;

@Configuration
@ComponentScan(
        basePackages = "ua.upsite.nso",
        excludeFilters = @ComponentScan.Filter(Controller.class)
)
@EnableJpaRepositories(basePackages = "ua.upsite.nso.repository")
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
@PropertySource( "classpath:config.properties")
@Import({ SecurityConfig.class })

public class RootContextConfiguration
{

    @Value("${jpa.datasource.name}")
    String datasourceName;

    @Value("${hibernate.sqlDialect}")
    String sqlDialect;

    @Value("${hibernate.showSql}")
    String showSql;

    @Value("${jpa.generation.database.action}")
    String generationDbAction;

    @Bean(name = "springJpaDatasource")
    public DataSource springJpaDataSource()
    {
        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
        return lookup.getDataSource(datasourceName);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory()
    {
        Map<String, Object> properties = new Hashtable<>();
        properties.put("javax.persistence.schema-generation.database.action", generationDbAction);
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabasePlatform(sqlDialect);
        adapter.setShowSql(Boolean.valueOf(showSql));
        adapter.setGenerateDdl(Boolean.TRUE);
        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(adapter);
        factory.setDataSource(this.springJpaDataSource());
        factory.setPackagesToScan("ua.upsite.nso.model");
        factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
        factory.setValidationMode(ValidationMode.NONE);
        factory.setJpaPropertyMap(properties);
        return factory;
    }


    @Bean(name="transactionManager")
    public PlatformTransactionManager jpaTransactionManager()
    {
        return new JpaTransactionManager(
                this.entityManagerFactory().getObject()
        );
    }

    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
