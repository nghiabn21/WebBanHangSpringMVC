package DemoSpringMVC.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DemoSpringMVC.Dto.CartDto;
import DemoSpringMVC.Dto.ProductsDto;
 
@Repository
public class CartDao extends BaseDao {
	@Autowired
	ProductsDao productsDao = new ProductsDao();

	public HashMap<Integer, CartDto> AddCart(int id, HashMap<Integer, CartDto> cart) {
		CartDto itemCart = new CartDto();
		ProductsDto product = productsDao.FindProductById(id);
		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(itemCart.getQuanty() + 1); 
			itemCart.setTotalPrice(itemCart.getQuanty() * itemCart.getProduct().getPrice());
		}else { 
			itemCart.setProduct(product);
			itemCart.setQuanty(1);
			itemCart.setTotalPrice(product.getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Integer, CartDto> EditCart(int id, int quanty, HashMap<Integer, CartDto> cart) {

		// ProductsDto product = productsDao.FindProductById(id);
		CartDto itemCart = new CartDto();
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(quanty);
			itemCart.setTotalPrice(quanty * itemCart.getProduct().getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Integer, CartDto> DeleteCart(int id, HashMap<Integer, CartDto> cart) {

		// ProductsDto product = productsDao.FindProductById(id);
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	public int ToltalQuanty(HashMap<Integer, CartDto> cart) {
		int totalQuanty = 0;
		for (Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
			totalQuanty += itemCart.getValue().getQuanty(); // lấy giá trị của quanty

		}
		return totalQuanty;

	}

	public double ToltalPrice(HashMap<Integer, CartDto> cart) { // tổng giá
		int totalPrice = 0;
		for (Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice(); // lấy giá trị của price

		}
		return totalPrice;

	}

}
