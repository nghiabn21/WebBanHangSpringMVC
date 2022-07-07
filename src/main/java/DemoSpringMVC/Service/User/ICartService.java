package DemoSpringMVC.Service.User;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import DemoSpringMVC.Dto.CartDto;
import DemoSpringMVC.Dto.ProductsDto;

@Service
public interface ICartService {

	public HashMap<Integer, CartDto> AddCart(int id, HashMap<Integer, CartDto> cart ); 
	public HashMap<Integer, CartDto> EditCart(int id, int quanty, HashMap<Integer, CartDto> cart ); 
	public HashMap<Integer, CartDto> DeleteCart(int id, HashMap<Integer, CartDto> cart ); 
	public int ToltalQuanty( HashMap<Integer, CartDto> cart );  
	public double ToltalPrice( HashMap<Integer, CartDto> cart ) ;
}
