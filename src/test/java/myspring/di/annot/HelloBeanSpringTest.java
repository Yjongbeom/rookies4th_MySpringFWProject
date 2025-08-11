package myspring.di.annot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	HelloBean hello;
	
	@Autowired
	@Qualifier("stringPrinterBean")
	PrinterBean printer;
	
	@Test // @Disabled
	void helloBean() {
		assertEquals("Hello 어노테이션", hello.sayHello());
		hello.print();
		assertEquals("Hello 어노테이션", printer.toString());
		
		assertEquals(3, hello.getNames().size());
	
		for(String name: hello.getNames()) {
			System.out.println(name);
		}
	}
	
	// 전략2의 setter injection 설정을 테스트
	@Test @Disabled
	void helloBeanConstructor() {
		assertEquals("Hello 생성자어노테이션", hello.sayHello());
		hello.print();
		assertEquals("Hello 생성자어노테이션", printer.toString());
	}
	
}
