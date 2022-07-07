package DemoSpringMVC.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DemoSpringMVC.Dao.ProductsDao;
import DemoSpringMVC.Dto.ProductsDto;

@Service
public class CategoryServiceImpl implements ICategoryService{ 
	@Autowired 
	private ProductsDao dao ;

	@Override
	public List<ProductsDto> getDataProductsPaginate(int id, int start, int totalPage) {
		
		return dao.GetDataProductsPaginate(id, start,totalPage);
	}

	@Override
	public List<ProductsDto> getAllProductsById(int id) {
		
		return dao.GetAllProductsById(id);
	}

}
