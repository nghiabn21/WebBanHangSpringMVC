package DemoSpringMVC.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutUs extends BaseController { 
	 
	@RequestMapping(value = "/gioi-thieu") 
	public ModelAndView About() {  
		_mvShare.setViewName("user/aboutUs/about");
		return _mvShare ;
	}

}
