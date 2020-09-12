package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
//@Service, @Repository, @autowire 어노테이션 대신 Bean으로 직접 주입해주는 방법

@Configuration
public class SpringConfig {
    //private DataSource dataSource;
    private EntityManager em;

    @Autowired
    public SpringConfig(//DataSource dataSource
                        EntityManager em) {
        //this.dataSource = dataSource;
        this.em = em;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    // 현재 메모리 리포지토리를 다른 리포지토리로 변경한다면 컴포넌트 스캔 방식 대신
    // 현재 클래스와 같은 방식으로 하면 return new 새로운Repository 로 바꿔주기만 하면 됨.
    @Bean
    public MemberRepository memberRepository() {
       // return new MemoryMemberRepository();
       // return new JdbcMemberRepository(dataSource);
       // return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}

