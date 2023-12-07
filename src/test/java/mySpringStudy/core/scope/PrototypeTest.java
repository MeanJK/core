package mySpringStudy.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {
    @Test
    void protoTypeTest() throws Exception {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Prototype.class);
        System.out.println("findPrototypeBean1");
        Prototype bean1 = ac.getBean(Prototype.class);
        System.out.println("findPrototypeBean2");
        Prototype bean2 = ac.getBean(Prototype.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        Assertions.assertThat(bean1).isNotSameAs(bean2);

        ac.close();
    }

    @Scope("prototype")
    static class Prototype {

        @PostConstruct
        public void init(){
            System.out.println("prototype.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("prototype.destroy");
        }
    }
}
