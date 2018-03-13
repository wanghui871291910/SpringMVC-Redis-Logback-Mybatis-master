package com.redis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//https://www.cnblogs.com/hehaiyang/p/4578488.html
@Controller
@RequestMapping("demo")
public class DemoController {
	
	@RequestMapping(value = "/index.do")
	String index(){
		 return "index";
		
	}
}
