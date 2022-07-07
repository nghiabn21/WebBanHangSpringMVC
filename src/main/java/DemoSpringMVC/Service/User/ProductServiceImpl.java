package DemoSpringMVC.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DemoSpringMVC.Dao.ProductsDao;
import DemoSpringMVC.Dto.ProductsDto;

@Service
public class ProductServiceImpl implements IProductService{ 
	@Autowired 
	ProductsDao dao ;

	

	@Override
	public ProductsDto GetProductById(int id) {
		List<ProductsDto> listProduct = dao.getProductById(id);
		 return listProduct.get(0);
	}



	@Override
	public List<ProductsDto> GetProductByIdCategory(int id) {
		
		return dao.GetAllProductsById(id);
	}

}
