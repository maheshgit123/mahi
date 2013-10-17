package demo.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.spring.service.HelloWorld;

public class Client {
	public static void main(String args[]) throws Exception {
			        // START SNIPPET: client
			        ClassPathXmlApplicationContext context 
			            = new ClassPathXmlApplicationContext(new String[] {"client-beans.xml"});
			
			        HelloWorld client = (HelloWorld)context.getBean("client");
			
			        String response = client.sayHi("Joe");
			        System.out.println("Response: " + response);
			        System.exit(0);
			        // END SNIPPET: client
			    }

}
