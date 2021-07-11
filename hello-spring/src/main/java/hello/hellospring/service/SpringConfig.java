package hello.hellospring.service;

import hello.hellospring.repository.JpaMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

	private EntityManager em;

	@Autowired
	public SpringConfig (EntityManager em){
		this.em = em;
	}

	@Bean
	public MemberService memberService(){
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
//		return new MemoryMemberRepository();
		return new JpaMemberRepository(em);
	}

}
