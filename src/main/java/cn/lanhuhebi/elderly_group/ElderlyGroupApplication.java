package cn.lanhuhebi.elderly_group;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.lanhuhebi.elderly_group.dao")
@SpringBootApplication
public class ElderlyGroupApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElderlyGroupApplication.class, args);
    }

}
