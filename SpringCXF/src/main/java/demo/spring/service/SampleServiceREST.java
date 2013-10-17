package demo.spring.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import demo.spring.model.Test;
import demo.spring.model.User;
import demo.spring.model.UserRequest;
import demo.spring.model.UserResponse;

//REST Setup (Follows JAX-RS)
@Path("/sampleService")
@Produces("application/json")
public class SampleServiceREST {

 @GET
 @Path("/restService")
 public ModelAndView testSpring(){
     System.out.println("get users:");
     ModelAndView mv=new ModelAndView("index");
     Map<String,Test> testMap=new HashMap<String,Test>();
     Test t1=new Test();
     t1.setId(1);
     t1.setName("mahi");
     testMap.put("jsonlist", t1);
     Test t2=new Test();
     t2.setId(2);
     t2.setName("mahi2");
     testMap.put("Test1", t2);
     String result="";
     try {
		result=new ObjectMapper().writeValueAsString(t1).toString();
		
	} catch (JsonGenerationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     mv.addObject("data", result);
 return mv;
 }
 @POST
 @Path("/fetchUsers")
 public ModelAndView fetchUserById()
	{
	 ModelAndView mv=new ModelAndView("index");
		UserResponse response = new UserResponse();
		System.out.println("in fetch");
		String result="";
		try
		{
			List<User> userList=new ArrayList<User>();
			User u1=new User();
			u1.setCity("hyd");
			u1.setEmail("mahesh.g@tech.com");
			u1.setId(1);
			u1.setName("mahesh");
			u1.setState("ap");
			userList.add(u1);
			result=new ObjectMapper().writeValueAsString(userList).toString();
			response.setUsers(userList);
		}
		catch (Exception e)
		{
			response.setSuccess(false);
			response.setErrorMessage(e.getClass() + ": " + e.getMessage());
		}
		mv.addObject("data",result);
		return mv;
	}
 @POST
 @Path("/fetch")
 public UserResponse fetchUser(UserRequest request)
	{
	// ModelAndView mv=new ModelAndView("index");
		UserResponse response = new UserResponse();
		System.out.println("in fetch");
		//System.out.println("from request:::::::::::::"+request.getUser().getId());
		String result="";
		try
		{
			List<User> userList=new ArrayList<User>();
			User u1=new User();
			u1.setCity("hyd");
			u1.setEmail("mahesh.g@tech.com");
			u1.setId(1);
			u1.setName("mahesh");
			u1.setState("ap");
			userList.add(u1);
			//result=new ObjectMapper().writeValueAsString(userList).toString();
			response.setUsers(userList);
		}
		catch (Exception e)
		{
			response.setSuccess(false);
			response.setErrorMessage(e.getClass() + ": " + e.getMessage());
		}
		//mv.addObject("data",result);
		return response;
	}
}
