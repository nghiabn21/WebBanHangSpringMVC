package DemoSpringMVC.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DemoSpringMVC.Service.User.IProductService;

@Controller
public class ProductController extends BaseController{  
	@Autowired 
	private IProductService _iProductService;
	 
	@RequestMapping(value= {"chi-tiet-san-pham/{id}" }, method = RequestMethod.GET) 
	public ModelAndView Index(@PathVariable int id) {  
		
		_mvShare.setViewName("user/products/product");  
		
		_mvShare.addObject("product", _iProductService.GetProductById(id));   
		int id_category = _iProductService.GetProductById(id).getId_category() ;
		
		_mvShare.addObject("productByIdCategory", _iProductService.GetProductByIdCategory(id_category)); 
		return _mvShare;
	} 

}
