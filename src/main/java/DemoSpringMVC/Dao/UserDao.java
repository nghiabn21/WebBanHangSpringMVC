package DemoSpringMVC.Dao;

import org.springframework.stereotype.Repository;

import DemoSpringMVC.Dto.ProductsDto;
import DemoSpringMVC.Dto.ProductsDtoMapper;
import DemoSpringMVC.Entity.MapperUser;
import DemoSpringMVC.Entity.UserEntity;

@Repository
public class UserDao extends BaseDao{ 
	 
	public int AddAccount(UserEntity user) {  
		StringBuffer var = new StringBuffer(); 
		var.append("insert "); 
		var.append("into user "); 
		var.append("( "); 
		var.append("   user, ");  
		var.append("   password, ");  
		var.append("   display_name, ");  
		var.append("   address ");  
		var.append(") ");  
		var.append("values ");  
		var.append("( ");  
		var.append("    '"+user.getUser()+"', ");  
		var.append("    '"+user.getPassword()+"', ");  
		var.append("    '"+user.getDisplayName()+"', ");  
		var.append("    '"+user.getAddress()+"' ");  
		var.append(") ");  
		
		int insert = jdbcTemplate.update(var.toString()); 
		return insert ;
	} 
	 
	public UserEntity getUserByAccount(UserEntity user) {  
		String sql = "select * from user where user = '"+user.getUser()+"' ";
		
		UserEntity us = jdbcTemplate.queryForObject(sql, new MapperUser());
		
		return us ;
	}

}
