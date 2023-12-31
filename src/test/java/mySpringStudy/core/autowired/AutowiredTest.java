package mySpringStudy.core.autowired;

import jakarta.annotation.Nullable;
import mySpringStudy.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void autowiredOptionTest() throws Exception {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }
     static class TestBean{

        @Autowired(required = false)
        public void setNoBean1(Member member){
            System.out.println("member = " + member);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member2){
            System.out.println("member2 = " + member2);
        }

        @Autowired
         public void setNoBean3(Optional<Member> member3){
            System.out.println("member3 = " + member3);
        }


    }
}
