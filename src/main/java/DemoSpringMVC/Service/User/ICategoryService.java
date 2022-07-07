package DemoSpringMVC.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DemoSpringMVC.Dto.ProductsDto;

@Service
public interface ICategoryService { 
	public List<ProductsDto> getDataProductsPaginate(int id ,int start, int end);  
	 
	public List<ProductsDto> getAllProductsById(int id); 
	

}
