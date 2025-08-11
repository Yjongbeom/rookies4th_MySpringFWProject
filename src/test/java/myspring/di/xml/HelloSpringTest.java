package myspring.di.xml;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
// ApplicaionContext 객체 생성하는 어노테이션
public class HelloSpringTest {
	
	// getbean() 대신
	// Autowired는 클래스가 같으면, 변수명을 우선적으로 가져온다. Qualifier를 쓰면, 클래스가 같은 다른id의 클래스를 지정가능
	@Autowired
	@Qualifier("helloC")
	Hello hello;
	
	// 전략1 Constructor Injection, Seeter Injection 테스트
	@Test
	void helloBeanByConstructor() {
		System.out.println(hello.sayHello());
		assertEquals("Hello 생성자", hello.sayHello());
		
		hello.print();
		
		assertEquals(3, hello.getNames().size());
		
		for(String name: hello.getNames()) {
			System.out.println(name);
		}
	}
}
