package mySpringStudy.core.beanfind;

import mySpringStudy.core.member.MemberRepository;
import mySpringStudy.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
    
    @Test
    void 타입으로_조회시_같은_타입이_둘_이상_있으면_중복_에러를_반환한다() throws Exception {
//        MemberRepository bean = ac.getBean(MemberRepository.class);
        assertThrows(NoUniqueBeanDefinitionException.class, () ->
                ac.getBean(MemberRepository.class));
    }

    @Test
    void 타입으로_조회시_같은_타입이_둘_이상_있으면_빈_이름을_지정한다() throws Exception {
        MemberRepository bean = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(bean).isInstanceOf(MemberRepository.class);
    }

    @Test
    void 같은_타입을_모두_조회() throws Exception {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + "value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

        @Configuration
        static class SameBeanConfig{

            @Bean
            public MemberRepository memberRepository1(){
                return new MemoryMemberRepository();
            }

            @Bean
            public MemberRepository memberRepository2(){
                return new MemoryMemberRepository();
            }
        }
    }
