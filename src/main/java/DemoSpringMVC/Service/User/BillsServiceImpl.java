package DemoSpringMVC.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DemoSpringMVC.Dao.BillsDao;
import DemoSpringMVC.Dto.CartDto;
import DemoSpringMVC.Entity.BillDetail;
import DemoSpringMVC.Entity.Bills;

@Service
public class BillsServiceImpl implements IBillsService { 
	 
	@Autowired 
	private BillsDao billsDao ;

	@Override
	public int AddBills(Bills bill) {
		// TODO Auto-generated method stub
		return billsDao.AddBills(bill);
	}

	@Override
	public void AddBillsDetail(HashMap<Integer, CartDto> carts) {
		// TODO Auto-generated method stub 
		int idBills = billsDao.GetIDLastBills(); 
		 
		for(Map.Entry<Integer, CartDto> itemCart : carts.entrySet()) { 
			BillDetail billDetail = new BillDetail(); 
			billDetail.setIdBills(idBills); 
			billDetail.setIdProduct(itemCart.getValue().getProduct().getId_product()); 
			billDetail.setQuanty(itemCart.getValue().getQuanty()); 
			billDetail.setTotal(itemCart.getValue().getTotalPrice()); 
			 
			billsDao.AddBillsDetail(billDetail);
		}
		
	} 
	 
	

}
