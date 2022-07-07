package DemoSpringMVC.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DemoSpringMVC.Dao.CartDao;
import DemoSpringMVC.Dto.CartDto;

@Service
public class CartServiceImpl implements ICartService{ 
	 
	@Autowired 
	private CartDao dao ;

	@Override
	public HashMap<Integer, CartDto> AddCart(int id, HashMap<Integer, CartDto> cart) {
		
		return dao.AddCart(id, cart);
	}

	@Override
	public HashMap<Integer, CartDto> EditCart(int id, int quanty, HashMap<Integer, CartDto> cart) {
		
		return dao.EditCart(id, quanty, cart);
	}

	@Override
	public HashMap<Integer, CartDto> DeleteCart(int id, HashMap<Integer, CartDto> cart) {
		
		return dao.DeleteCart(id, cart);
	}

	@Override
	public int ToltalQuanty(HashMap<Integer, CartDto> cart) {
		// TODO Auto-generated method stub
		return dao.ToltalQuanty(cart);
	}

	@Override
	public double ToltalPrice(HashMap<Integer, CartDto> cart) {
		// TODO Auto-generated method stub
		return dao.ToltalPrice(cart);
	}

}
