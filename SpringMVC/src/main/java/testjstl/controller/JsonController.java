package testjstl.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import testjstl.entity.People;
import testjstl.entity.User;

/**
 * @ClassName:  JsonController   
 * @Description:测试Json数据交互方式
 * @author: caiji
 * @date: 2019年4月19日 上午10:20:18
 */

@Controller
public class JsonController {

	
	/*
	 * 	进入jsonuser页面
	 */
	@RequestMapping("/json")
	public String jsonuser() {
		return "json_user";
	}

	
	/*
	 * 	以json字符串的形式传递数据
	 * @Description:接受前台的json数据并转化为Java对象，此处为User对象， 但是前端的User属性要与后端的User属性名保持一致
	 * @RequestBody:接受json格式的字符串，并将其转化为java对象
	 * @ResponseBody:作用是将controller方法返回的对象通过适当的转换器转换为指定的格式，写入到reponse对象的body区。通常用来返回json或者xml数据，返回到前端
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/jsonUser")
	public String submitCategory(@RequestBody User user) {
		System.out.println("SSM接受到浏览器提交的json，并转换为User对象:" + "username:"+user.getUsername()+"  password:"+user.getPassword());
		return "ok";
	}


	
	/*
	 * 	以json对象的形式传递数据
	 */
	@ResponseBody
	@RequestMapping("/jsonUser2")
	public String jsonUser2(@RequestParam("username") String username,@RequestParam("password") String password) {
		System.out.println("SSM接受到浏览器提交的json对象："+username + " "+password);
		return "ok";
	}
	
	/*
	 * @Description: 前端通过id查询people信息，然后将查询到的结果进行显示
	 * @param map：用来接受前端发送过来的id数据，<id,1>
	 * @return:将people转换为json数据(对象)返回到前端
	 */
	@RequestMapping("/peopleSelect")
    @ResponseBody
    public People peopleSelect(@RequestBody Map<String,String> map) {
        
		System.out.println(map.get("id"));
        //查找对应id的用户信息
        People people =  new People();
        people.setAge("11");
        people.setName("yuqiang");
        //返回用户信息，要使用@ResponseBody将返回值转换为JSON对象
        return people;
    }
	
	
	 
	
}
