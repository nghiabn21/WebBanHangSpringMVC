package DemoSpringMVC.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DemoSpringMVC.Dto.ProductsDto;

@Service
public interface IProductService {  
	public ProductsDto GetProductById(int id);  
	 
	public List<ProductsDto> GetProductByIdCategory(int id); 
	
	

}
