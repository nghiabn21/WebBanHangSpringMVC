package DemoSpringMVC.Service.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import DemoSpringMVC.Dao.CategorysDao;
import DemoSpringMVC.Dao.MenuDao;
import DemoSpringMVC.Dao.ProductsDao;
import DemoSpringMVC.Dao.SlidesDao;
import DemoSpringMVC.Dto.ProductsDto;
import DemoSpringMVC.Entity.Categorys;
import DemoSpringMVC.Entity.MapperSlides;
import DemoSpringMVC.Entity.Menus;
import DemoSpringMVC.Entity.Slides;
 
@Service
public class HomeImpl implements IHome{ 
	@Autowired
	private SlidesDao dao;  
	 
	@Autowired 
	private CategorysDao categorysDao ; 
	 
	@Autowired 
	private MenuDao dao2 ; 
	 
	@Autowired 
	private ProductsDao product ;

	@Override
	public List<Slides> GetDataSlide(){ 
		return dao.GetDataSlide() ;
		
	}

	@Override
	public List<Categorys> GetDataCategorys() {
		
		return categorysDao.GetDataCategory() ;
	}

	@Override
	public List<Menus> GetDataMenus() {
		
		return dao2.GetDataMenus();
	}

	@Override
	public List<ProductsDto> GetDataProducts() {
		 List<ProductsDto> list = product.GetDataProducts();
		return list;
	}

	@Override
	public List<ProductsDto> GetDataNewProducts() {
		List<ProductsDto> list = product.GetDataNewProducts();
		return list;
	}

	
	

}
