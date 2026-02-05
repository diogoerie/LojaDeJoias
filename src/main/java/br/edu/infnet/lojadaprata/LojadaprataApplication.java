package br.edu.infnet.lojadaprata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LojadaprataApplication {

    public static void main(String[] args) {
        SpringApplication.run(LojadaprataApplication.class, args);
    }

}
