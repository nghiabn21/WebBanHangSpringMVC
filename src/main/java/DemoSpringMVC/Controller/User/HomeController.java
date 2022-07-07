package DemoSpringMVC.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DemoSpringMVC.Dao.SlidesDao;
import DemoSpringMVC.Service.User.HomeImpl;

@Controller
public class HomeController extends BaseController {  
	
	 
	@RequestMapping(value= {"/", "/trang-chu" }, method = RequestMethod.GET) 
	public ModelAndView Index() {  
		//ModelAndView mv = new ModelAndView("user/index"); //model set dữ liệu và view là vào file giao diện 
		_mvShare.addObject("slides", basehomeImpl.GetDataSlide()); 
		_mvShare.addObject("categorys", basehomeImpl.GetDataCategorys());   
		_mvShare.addObject("products", basehomeImpl.GetDataProducts());   
		_mvShare.addObject("productsNew", basehomeImpl.GetDataNewProducts());  
		_mvShare.setViewName("user/index");
		return _mvShare;
	} 
	 

}
