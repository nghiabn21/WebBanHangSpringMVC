package DemoSpringMVC.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import DemoSpringMVC.Service.User.HomeImpl;
 
@Controller
public class BaseController { 
	 
	@Autowired
	HomeImpl basehomeImpl ; 
	 
	public ModelAndView _mvShare = new ModelAndView();  
	 
	@PostConstruct    // giúp cho khi bật controller thì phương thức Init sẽ được chạy trước 
	public ModelAndView Init() { 
		_mvShare.addObject("menus", basehomeImpl.GetDataMenus()); 
		return _mvShare ;
	}

}
