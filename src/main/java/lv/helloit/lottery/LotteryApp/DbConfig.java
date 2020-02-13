package lv.helloit.lottery.LotteryApp;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConfig {
    private static final String DB_URL = "jdbc:postgresql://ec2-54-247-125-38.eu-west-1.compute.amazonaws.com:5432/d8ls2ro3ul356g";
    private static final String DB_USER = "ppnyswxeziexcc";
    private static final String DB_PASSWORD = "6d4cb9e95357115cac260d5c6a6de28b7a9fc062b84a599e5ee85d6e2fbccc41";

    @Bean
    DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(DB_URL);
        ds.setUsername(DB_USER);
        ds.setPassword(DB_PASSWORD);
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setMaxTotal(3);
        return ds;
    }
}
