package kr.co.springbootawswebservicestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringbootAwsWebServiceStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAwsWebServiceStudyApplication.class, args);
    }

}
