package ua.upsite.nso.config;

/**
 *  Created by gregory on 11/9/15.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.stereotype.Controller;
import ua.upsite.nso.service.TestServiceImpl;

import javax.sql.DataSource;

@Configuration
@ComponentScan(
        basePackages = "ua.upsite.nso",
        excludeFilters = @ComponentScan.Filter(Controller.class)
)
@EnableJpaRepositories(basePackages = "ua.upsite.nso.repository")

public class RootContextConfiguration
{
    @Bean(name = "testService")
    public TestServiceImpl newService() {
        return new TestServiceImpl();
    }

//    @Bean(name = "dataSource")
//    public DataSource getDataSource() {
//        DataSource source = new DriverManagerDataSource(
//                "jdbc:postgresql://localhost:5432/1nso",
//                "postgres",
//                "root"
//        );
//
//        return source;
//    }

    @Bean(name = "datasource")
    public DataSource dataSource()
    {
        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
        return lookup.getDataSource("1nso");
    }
}
