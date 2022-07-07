package DemoSpringMVC.Entity;

import java.sql.ResultSet; 
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class MapperCategorys implements RowMapper<Categorys> {

	public Categorys mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categorys slides = new Categorys(); 
		slides.setId(rs.getInt("id")); 
		slides.setName(rs.getString("name")); 
		slides.setDescription(rs.getString("description")); 
	
		return slides;
	}


}
