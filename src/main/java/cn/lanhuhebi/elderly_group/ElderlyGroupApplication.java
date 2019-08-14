package cn.lanhuhebi.elderly_group;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("cn.lanhuhebi.elderly_group.dao")
@EnableTransactionManagement
@SpringBootApplication
public class ElderlyGroupApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElderlyGroupApplication.class, args);
    }

}
