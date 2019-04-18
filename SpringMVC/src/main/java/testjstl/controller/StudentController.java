package testjstl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import testjstl.entity.Student;
import testjstl.entity.User;
 

/**
 * @ClassName:  StudentController   
 * @Description:控制器类，用于测试spring自带的标签库
 * @author: caiji
 * @date: 2019年4月18日 下午9:54:09
 */

@Controller
public class StudentController {

	/*
	 * @Description:为student页面的form标签的command属性传递 实体对象student
	 * @return:返回到要传递对象的页面
	 */
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView student() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("student");
		/*
		 *	这里传递的属性值为command1，默认为command
		 *	当属性值不为command的时候，form 中要设置属性值commandName = "command" 	 
		 */
		mav.addObject("command1", new Student());
		 
		return mav;
	}

	/*
	 * @Description: 接受表单数据，然后将数据装在模型model中传递到student_result页面
	 * @param student：Student对象
	 * @param model：
	 * @return
	 */
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ModelAndView addStudent(Student student) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("name", student.getName());
		mav.addObject("age", student.getAge());
		mav.addObject("id", student.getId());

		mav.setViewName("student_result");
		/*
		model.addAttribute("name", student.getName());
		model.addAttribute("age", student.getAge());
		model.addAttribute("id", student.getId());*/

		return mav;
	}

}
