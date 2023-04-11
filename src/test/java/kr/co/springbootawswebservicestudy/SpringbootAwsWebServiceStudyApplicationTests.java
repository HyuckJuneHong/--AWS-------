package kr.co.springbootawswebservicestudy;

import kr.co.springbootawswebservicestudy.web.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class SpringbootAwsWebServiceStudyApplicationTests {

    @Test
    void contextLoads() {
    }

    @Configuration
    static class Config {
        @Bean
        public MockMvc mockMvc() {
            return MockMvcBuilders.standaloneSetup(new HelloController()).build();
        }
    }
}
