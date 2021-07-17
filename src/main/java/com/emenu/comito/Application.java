package com.emenu.comito;
// 프로젝트의 메인 클래스이다.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 해당 위치부터 설정을 읽어 가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야만 한다.

@EnableJpaAuditing     // JPA Auditing 활성화
@SpringBootApplication // 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정되도록 한다.
public class Application {
    public static void main(String[]args) {
        // 내장 WAS(Web Application Server)를 실행한다.
        /*
            내장 WAS란?
            별도로 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행하는 것을 의미한다.
            이렇게 되면 항상 서버에 톰캣을 설치할 필요가 없게 되고,
            스프링 부트로 만들어진 Jar(실행 가능한 Java 패키징 파일)로 실행하면 된다.

            장점
            언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있다.
         */
        SpringApplication.run(Application.class, args);
    }
}
