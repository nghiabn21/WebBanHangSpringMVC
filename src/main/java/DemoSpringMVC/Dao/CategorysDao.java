package DemoSpringMVC.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import DemoSpringMVC.Entity.Categorys;
import DemoSpringMVC.Entity.MapperCategorys;
import DemoSpringMVC.Entity.MapperSlides;
import DemoSpringMVC.Entity.Slides;
 
@Repository
public class CategorysDao extends BaseDao{ 
	
	 
	public List<Categorys> GetDataCategory(){ 
		List<Categorys> list = new ArrayList<Categorys>();   
		String sql = "Select * from categorys" ;
		list = jdbcTemplate.query(sql, new MapperCategorys());
		return list ;
		
	} 

}
