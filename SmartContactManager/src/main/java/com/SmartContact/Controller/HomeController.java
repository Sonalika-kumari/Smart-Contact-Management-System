package com.SmartContact.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SmartContact.dao.UserRepository;
import com.SmartContact.entities.Contact;
import com.SmartContact.entities.User;


import com.SmartContact.helper.Message;

import jakarta.servlet.http.HttpSession;
@Controller
public class HomeController {
	
    @Autowired
	private UserRepository userRepository;
    
    @RequestMapping("/start")
	@ResponseBody
	public String start()
	{
		System.out.println("yes run");
		User user=new User();
		user.setName("sonalika kumari");
		user.setEmail("sonali@gmail.com");
		Contact contact=new Contact();
		user.getContacts().add(contact);
		
		userRepository.save(user);
		
		 return "working";
	}
    @RequestMapping("/")
    public String home(Model model)
    {  model.addAttribute("title","Home smart Contact");
    	return "home";
    }
    
    @RequestMapping("/about")
    public String about(Model model)
    {  model.addAttribute("title","about smart Contact");
    	return "about";
    }

    
    @RequestMapping("/signup")
    public String signup(Model model)
    {   System.out.println("signup");
    	model.addAttribute("title","Resister-smart Contact");
        model.addAttribute("user", new User());
      return "signup";
    }
    
  //handler for resister user
    @RequestMapping(value="/do_register", method=RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user,@RequestParam(value="agreement" ,defaultValue ="false") boolean agreement, Model model,HttpSession session)
    { System.out.println("do resister...............");
    	try{    
    		if(!agreement)
            {   System.out.println("do resister  1...............");
    			System.out.println("You have not agreed the terms and condition");
    			throw new Exception("You have not agreed the terms and condition");
            }
    		System.out.println("do resister  2...............");
        	user.setRole("ROLE_USER");
        	user.setEnabled(true);
        	user.setImageurl("default.png");
        	
        	
        	System.out.print(agreement);
              System.out.println("user=......."+user);
           
             User result= this.userRepository.save(user);
             System.out.println("result............+" +result);
           
             model.addAttribute("user",result);
           
             model.addAttribute("user",new User());
	         session.setAttribute("message" , new Message("succ resister","alert-success"));
	    	 return "signup";
           
    		}catch(Exception e ){
    			System.out.println("do resister  exce...............");
    			System.out.println("error......... ");
    			e.printStackTrace();
    			model.addAttribute("user",user);
    	    	session.setAttribute("message" ,new  Message("Something worng!! sons", "alert-danger"));
    	    	 return "signup";
    		}    
    	
    	
     
    }
}
