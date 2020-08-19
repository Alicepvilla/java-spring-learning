package cl.crisgvera.ensayodos.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

// Currently deactivated because H2
//@Configuration
@PropertySource(value = "classpath:properties/oracle.properties")
public class DataConfigurations {
    @Autowired
    private Environment environment;

    @Bean
    @Primary
    public DataSource getOracleConnection() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(environment.getProperty("db.url"));
        dataSourceBuilder.username(environment.getProperty("db.username")); // Set your user in properties
        dataSourceBuilder.password(environment.getProperty("db.password")); // Set your password in properties
        return dataSourceBuilder.build();
    }
}
