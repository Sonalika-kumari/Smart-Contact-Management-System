package com.SmartContact.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SmartContact.dao.UserRepository;
import com.SmartContact.entities.Contact;
import com.SmartContact.entities.User;

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

    
    @RequestMapping("/signup/")
    public String signup(Model model)
    {  model.addAttribute("title","Resister smart Contact");
    	return "signup";
    }
}
