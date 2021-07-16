package hello.hellospring.service;

import hello.hellospring.aop.TimeTraceAop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.MemberRepository;

@Configuration
public class SpringConfig {

	private final MemberRepository memberRepository;

//	@Autowired 생성자가 하나 있으면 autowired 생략 가능
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}


	@Bean
	public MemberService memberService(){
		return new MemberService(memberRepository);
	}


//	@Bean
//	public MemberRepository memberRepository() {
//		return new MemoryMemberRepository();
//		return new JpaMemberRepository(em);
//	}

}
