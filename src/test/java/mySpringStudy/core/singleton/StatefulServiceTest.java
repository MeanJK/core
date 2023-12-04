package mySpringStudy.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void 싱글턴_테스트() throws Exception {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        int item1Price = statefulService1.order("item1", 10000);
        int item2Price = statefulService2.order("item2", 20000);

        /*int price = statefulService1.getPrice()*/;
        System.out.println("price = " + item1Price);
        /*assertThat(statefulService1.getPrice()).isEqualTo(20000);*/
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}