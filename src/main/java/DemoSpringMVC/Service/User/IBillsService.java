package DemoSpringMVC.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import DemoSpringMVC.Dto.CartDto;
import DemoSpringMVC.Entity.Bills;

@Service
public interface IBillsService {
   public int AddBills(Bills bill); 
    
   public void AddBillsDetail(HashMap<Integer, CartDto> carts) ;
}
