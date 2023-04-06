package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class TVUser {
	public static void main(String[] args) {
		
//		SamsungTV tv1 = new SamsungTV();
//		tv1.powerOn();
//		tv1.volumeUp();
//		tv1.volumeDown();
//		tv1.powerOff();
				
//		LgTV tv2 = new LgTV();
//		tv2.turnOn();
//		tv2.soundUp();
//		tv2.soundDown();
//		tv2.turnOff();
		
//		TV tv3 = new SamsungTV();
//		tv3.powerOn();
//		tv3.volumeUp();
//		tv3.volumeDown();
//		tv3.powerOff();
		
//		BeanFactory factory = new BeanFactory();
//		TV tv4 = (TV)factory.getBean(args[0]);
//		tv4.powerOn();
//		tv4.volumeUp();
//		tv4.volumeDown();
//		tv4.powerOff();
		
		// 1. Spring �����̳ʸ� �����Ѵ�.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring �����̳ʷκ��� �ʿ��� ��ü�� ��û(Lookup)�Ѵ�.
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. Spring �����̳ʸ� �����Ѵ�.
		factory.close();
		
		
//		// 1. Spring IoC �����̳ʸ� �����Ѵ�.
//		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
//		
//		// 2. Spring �����̳ʷκ��� �ʿ��� ��ü�� ��û(Lookup)�Ѵ�.
//		TV tv1 = (TV)factory.getBean("tv");
//		TV tv2 = (TV)factory.getBean("tv");
//		TV tv3 = (TV)factory.getBean("tv");
//		
//		// 3. Spring �����̳ʸ� �����Ѵ�.
//		factory.close();
	}
}
