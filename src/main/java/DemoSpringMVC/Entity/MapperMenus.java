package DemoSpringMVC.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperMenus implements RowMapper<Menus>{

	@Override
	public Menus mapRow(ResultSet rs, int rowNum) throws SQLException {
		Menus slides = new Menus(); 
		slides.setId(rs.getInt("id")); 
		slides.setName(rs.getString("name")); 
		slides.setUrl(rs.getString("url")); 
		return slides;
	} 
	

}
