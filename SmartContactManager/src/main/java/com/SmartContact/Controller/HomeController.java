package com.SmartContact.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SmartContact.dao.UserRepository;
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
		
		 return "working";
	}

}
