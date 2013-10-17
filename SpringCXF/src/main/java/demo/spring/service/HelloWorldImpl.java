package demo.spring.service;
import javax.jws.WebService;
@WebService(endpointInterface="demo.spring.service.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	 public String sayHi(String text) {
		 	        System.out.println("mahesh");
		         return "xxxxxxxxxx" + text;
		     }
	 public String sayHello(String textval){
		 return "yyyyyyyyy"+textval;
	 }
}
