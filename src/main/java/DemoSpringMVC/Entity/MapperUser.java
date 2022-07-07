package DemoSpringMVC.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUser implements RowMapper<UserEntity> {

	@Override
	public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserEntity user = new UserEntity(); 
		user.setId(rs.getInt("id"));  
		user.setUser(rs.getString("user")); 
		user.setPassword(rs.getString("password")); 
		user.setDisplayName(rs.getString("displayName")); 
		user.setAddress(rs.getString("address"));
		
		return user;
	} 
	

}
