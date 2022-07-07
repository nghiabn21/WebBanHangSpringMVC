package DemoSpringMVC.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DemoSpringMVC.Dto.ProductsDto;
import DemoSpringMVC.Dto.ProductsDtoMapper;

@Repository
public class ProductsDao extends BaseDao {

	private final boolean YES = true;
	private final boolean NO = false;

	private StringBuffer SqlString() { // câu sql dài thì dùng Stringbuider hoặc StringBuffer nối chuỗi
		StringBuffer varname1 = new StringBuffer();
		varname1.append("select ");
		varname1.append("p.id as id_product ");
		varname1.append(", p.id_category ");
		varname1.append(", p.size ");
		varname1.append(", p.name ");
		varname1.append(", p.price ");
		varname1.append(", p.sale ");
		varname1.append(", p.title ");
		varname1.append(", p.highlight ");
		varname1.append(", p.new_product ");
		varname1.append(", p.detail ");
		varname1.append(", c.id as id_color ");
		varname1.append(", c.name as name_color ");
		varname1.append(", c.code as code_color ");
		varname1.append(", c.img ");
		varname1.append(", p.created_at ");
		varname1.append(", p.updated_at ");
		varname1.append("from ");
		varname1.append("products as p ");
		varname1.append("Inner join ");
		varname1.append("colors as c ");
		varname1.append("on p.id = c.id_product ");

		return varname1;
	}

	private String SqlProducts(boolean newProduct, boolean highlight) {
		StringBuffer varname1 = SqlString();
        
		if (highlight) {
			varname1.append("where p.highlight = true ");

		}
		if (newProduct) {
			varname1.append("and p.new_product = true ");

		}
		varname1.append("group by p.id, c.id_product ");
		varname1.append("order by rand() ");
		if (highlight) {

			varname1.append("limit 9 ");
		}
		if (newProduct) {

			varname1.append("limit 12 ");
		}

		return varname1.toString();
	}

	public List<ProductsDto> GetDataProducts() {
		String sql = SqlProducts(NO, YES);
		List<ProductsDto> list = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}

	public List<ProductsDto> GetDataNewProducts() {
		String sql = SqlProducts(YES, NO);
		List<ProductsDto> list = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}

	public StringBuffer SqlProductsById(int id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND id_category =  " + id + " ");
		return sql;

	}

	public String SqlProductPaginate(int id, int start, int totalPage) {
		StringBuffer sql = SqlProductsById(id);

		sql.append("limit  " + start + ", " + totalPage);
		return sql.toString();

	}

	public List<ProductsDto> GetDataProductsPaginate(int id, int start, int totalPage) {
		StringBuffer sqlGetDataById = SqlProductsById(id);
		List<ProductsDto> listProductsById = jdbcTemplate.query(sqlGetDataById.toString(), new ProductsDtoMapper());
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		if (listProductsById.size() > 0) {
			String sql = SqlProductPaginate(id, start, totalPage);
			list = jdbcTemplate.query(sql, new ProductsDtoMapper());
		}

		return list;
	}

	public List<ProductsDto> GetAllProductsById(int id) {

		String sql = SqlProductsById(id).toString();
		List<ProductsDto> list = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	} 
	 
	public String SqlProductById(int id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND p.id =  " + id + " "); 
		sql.append("limit 1 ");
		return sql.toString();

	}

	public List<ProductsDto> getProductById(int id) { 
		String sql =SqlProductById( id) ;
		List<ProductsDto> listProduct = jdbcTemplate.query(sql, new ProductsDtoMapper());
		return listProduct;
	} 
	 
	public ProductsDto FindProductById(int id) { 
		String sql =SqlProductById( id) ;
		ProductsDto product = jdbcTemplate.queryForObject(sql, new ProductsDtoMapper());
		return product;
	}

}
