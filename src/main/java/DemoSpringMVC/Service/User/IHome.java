package DemoSpringMVC.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DemoSpringMVC.Dto.ProductsDto;
import DemoSpringMVC.Entity.Categorys;
import DemoSpringMVC.Entity.Menus;
import DemoSpringMVC.Entity.Slides;
 
@Service
public interface IHome {
	public List<Slides> GetDataSlide(); 
	public List<Categorys>  GetDataCategorys() ; 
	public List<Menus>  GetDataMenus() ; 
	public List<ProductsDto>  GetDataProducts() ; 
	public List<ProductsDto> GetDataNewProducts() ;
}
