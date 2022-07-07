package DemoSpringMVC.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductsDtoMapper implements RowMapper<ProductsDto>{

	@Override
	public ProductsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductsDto  products = new ProductsDto();  
		products.setId_product(rs.getInt("id_product"));
		products.setId_category(rs.getInt("id_category"));
		products.setSize(rs.getString("size"));
		products.setName(rs.getString("name"));
		products.setPrice(rs.getDouble("price"));
		products.setSale(rs.getInt("sale"));
		products.setTitle(rs.getString("title"));
		products.setHighlight(rs.getBoolean("highlight"));
		products.setNew_product(rs.getBoolean("new_product"));
		products.setDetail(rs.getString("detail"));
		products.setId_color(rs.getInt("id_color"));
		products.setName_color(rs.getString("name_color"));
		products.setCode_color(rs.getString("code_color"));
		products.setImg(rs.getString("img"));
		products.setCreated_at(rs.getDate("created_at"));
		products.setUpdated_at(rs.getDate("updated_at"));
		
		return products;
	}

	
	

}
