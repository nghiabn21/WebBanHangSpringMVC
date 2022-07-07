package DemoSpringMVC.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DemoSpringMVC.Dto.PaginatesDto;
import DemoSpringMVC.Service.User.ICategoryService;
import DemoSpringMVC.Service.User.IPaginatesService;

@Controller
public class CategoryController extends BaseController{  
	 
	@Autowired 
	private ICategoryService categoryService; 
	 
	@Autowired 
	private IPaginatesService iPaginatesService ; 
	 
	private int totalProductsPage = 9 ;
	 
	@RequestMapping(value ="/san-pham/{id}")
	public ModelAndView Product(@PathVariable String id) {  
		
		_mvShare.setViewName("user/products/category"); 
		 
		int totalData = categoryService.getAllProductsById(Integer.parseInt(id)).size();   
		PaginatesDto dto = iPaginatesService.getInforPaginates(totalData, totalProductsPage, 1);  
		 
		_mvShare.addObject("idCategory",id); 
		
		_mvShare.addObject("paginateInfo", dto); 
		
		
		_mvShare.addObject("productsPaginate", categoryService.getDataProductsPaginate(Integer.parseInt(id) , dto.getStart(),totalProductsPage)); 
		return _mvShare ;
		
	} 
	 
	 
		@RequestMapping(value ="/san-pham/{id}/{currentPage}")
		public ModelAndView Product(@PathVariable String id,@PathVariable int currentPage) {  
			
		  
			_mvShare.setViewName("user/products/category"); 
			 
			int totalData = categoryService.getAllProductsById(Integer.parseInt(id)).size();   
			PaginatesDto dto = iPaginatesService.getInforPaginates(totalData, totalProductsPage, currentPage);  
			 
			_mvShare.addObject("idCategory", id); 
			
			_mvShare.addObject("paginateInfo", dto); 
			
			
			_mvShare.addObject("productsPaginate", categoryService.getDataProductsPaginate(Integer.parseInt(id),dto.getStart(),totalProductsPage)); 
			return _mvShare ;
			
		}

}
