package mrcsFelipe.springjava.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(value="request")
public class HelloWorldController {
	
	@RequestMapping(value="/hello", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView hello(Model model) {
		
		ModelAndView view = new ModelAndView("helloworld");
		Map<String, Object> modelView = new HashMap<String, Object>();
		String teste = "Seja Bem-Vindo ao Spring 4 MVC com JavaConfig, by:MrcsFelipe !";
		modelView.put("name", teste);
		model.addAllAttributes(modelView);
		view.addAllObjects(modelView);
		return view;
	}
	
	@RequestMapping("/hello/{name}")
	public String hello(
			@PathVariable("name") String name,
			Model model) {
		System.out.println(name);
		model.addAttribute("name", name);
		return "helloworld";
	}
}