package testjstl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import testjstl.entity.User;

/**
 * @ClassName:  Controller   
 * @Description:Spring表单标签的测试
 * @author: caiji
 * @date: 2019年4月18日 下午5:10:03
 */

@Controller
public class UserController {

	@RequestMapping("/index")
	public String index() {
		return "user";
	}

	
	/*
	 * @Description: 
	 * @param user：User类
	 * @return :返回一个模型到result页面
	 */
	@RequestMapping("/adduser")
	public ModelAndView inputName(User user) {
		ModelAndView model = new ModelAndView();
		/*
		 * user和password：属性名
		 */
		model.addObject("user", user.getUsername());
		model.addObject("password", user.getPassword());

		model.setViewName("result");
		return model;
	}

	 
}
