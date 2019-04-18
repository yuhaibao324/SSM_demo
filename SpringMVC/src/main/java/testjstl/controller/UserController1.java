package testjstl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import testjstl.entity.User;

@Controller
public class UserController1 {

	@RequestMapping("/index1")
	public String spring_form() {
		return "spring_form_index";
	}
	
	@RequestMapping(value = "/action") //这里action的地址
	public String InputName(Model model) {
		model.addAttribute("user", new User());//这里给视图层提供了数据的对象，用来数据绑定
		return "spring_form_result";//返回的是视图的文件名
	}

}
