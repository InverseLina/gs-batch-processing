package hello;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Hinsteny
 * @Describtion
 * @date 2016/12/15
 * @copyright: 2016 All rights reserved.
 */
@Configuration
public class MyDataSource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyDataSource.class);

    @Bean
    public DataSource customDataSource() {
        final String url = "jdbc:mysql://127.0.0.1:3306/batch?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String userName = "root";
        final String password = "welcome";
        LOGGER.info("Creating in-memory mysql database with jdbc url [{}], user [{}]", url, userName);

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(userName);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        HikariDataSource dataSource = new HikariDataSource(config);

        return dataSource;
    }
}
