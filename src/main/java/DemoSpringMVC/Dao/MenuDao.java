package DemoSpringMVC.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DemoSpringMVC.Entity.Categorys;
import DemoSpringMVC.Entity.MapperCategorys;
import DemoSpringMVC.Entity.MapperMenus;
import DemoSpringMVC.Entity.Menus;

@Repository
public class MenuDao extends BaseDao{ 
	 
	public List<Menus> GetDataMenus(){ 
		List<Menus> list = new ArrayList<Menus>();   
		String sql = "Select * from menus" ;
		list = jdbcTemplate.query(sql, new MapperMenus());
		return list ;
		
	} 

}
