package ua.upsite.nso.config;

/**
 *  Created by gregory on 11/9/15.
 */

import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
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

public class RootContextConfiguration
{

    @Bean(name = "springJpaDatasource")
    public DataSource springJpaDataSource()
    {
        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
        return lookup.getDataSource("1nso");
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory()
    {
        Map<String, Object> properties = new Hashtable<>();
        properties.put("javax.persistence.schema-generation.database.action",
                "none");
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabasePlatform("org.hibernate.dialect.ProgressDialect");
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
}
