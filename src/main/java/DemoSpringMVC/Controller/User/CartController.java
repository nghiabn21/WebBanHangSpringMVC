package DemoSpringMVC.Controller.User;

import java.util.HashMap;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DemoSpringMVC.Dto.CartDto;
import DemoSpringMVC.Entity.Bills;
import DemoSpringMVC.Entity.UserEntity;
import DemoSpringMVC.Service.User.BillsServiceImpl;
import DemoSpringMVC.Service.User.ICartService;

@Controller
public class CartController extends BaseController {

	@Autowired
	private ICartService cartService; 
	 
	@Autowired 
	private BillsServiceImpl billsService ;

	@RequestMapping(value = "/gio-hang")
	public ModelAndView Index() {
		_mvShare.addObject("slides", basehomeImpl.GetDataSlide());
		_mvShare.addObject("categorys", basehomeImpl.GetDataCategorys());
		_mvShare.addObject("products", basehomeImpl.GetDataProducts());
		_mvShare.addObject("productsNew", basehomeImpl.GetDataNewProducts());
		_mvShare.setViewName("user/cart/list_cart");
		return _mvShare;
	}

	@RequestMapping(value = "/AddCart/{id}")
	public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable int id) {
		@SuppressWarnings("unchecked")
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart"); // giả sử có sẵn hàng

		if (cart == null) {
			cart = new HashMap<Integer, CartDto>();
		}
		cart = cartService.AddCart(id, cart); // set hàng mới về hàng cũ
		session.setAttribute("Cart", cart); // set lại hàng 

		session.setAttribute("TotalQuantyCart", cartService.ToltalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.ToltalPrice(cart));

		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "EditCart/{id}/{quanty}")
	public String EditCart(HttpServletRequest request, HttpSession session, @PathVariable int id,
			@PathVariable int quanty) {
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart"); // giả sử có sẵn hàng

		if (cart == null) {
			cart = new HashMap<Integer, CartDto>();
		}
		cart = cartService.EditCart(id, quanty, cart); // set hàng mới về hàng cũ
		session.setAttribute("Cart", cart); // set lại hàng

		session.setAttribute("TotalQuantyCart", cartService.ToltalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.ToltalPrice(cart));

		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "/DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable int id) {
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart"); // giả sử có sẵn hàng

		if (cart == null) {
			cart = new HashMap<Integer, CartDto>();
		}
		cart = cartService.DeleteCart(id, cart); // sau khi xóa thành công thì put lại hàng
		session.setAttribute("Cart", cart); // set lại hàng
		session.setAttribute("TotalQuantyCart", cartService.ToltalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.ToltalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkOut(HttpServletRequest request, HttpSession session) {
		_mvShare.setViewName("user/bills/checkout"); 
		Bills bills = new Bills(); //tạo đối tượng mới
		UserEntity loginInfo = (UserEntity) session.getAttribute("LoginInfo"); //lấy thông tin login
		if(loginInfo != null) {  //khác rỗng có nghĩa là ng dùng đã đăng nhập r
			bills.setAddress(loginInfo.getAddress()) ;
			bills.setDisplayName(loginInfo.getDisplayName()) ;
			bills.setUser(loginInfo.getUser());
		}
		_mvShare.addObject("bills", bills);
		return _mvShare;
	} 
	

	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkOutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bills") Bills bill) {  
		bill.setQuanty(Integer.parseInt((String) session.getAttribute("TotalPriceCart"))); 
		bill.setTotal(Double.parseDouble((String) session.getAttribute("TotalPriceCart")));
		
		if(billsService.AddBills(bill) > 0) { 
			HashMap<Integer, CartDto> carts = (HashMap<Integer, CartDto>) session.getAttribute("Cart"); 
			billsService.AddBillsDetail(carts);
		} 
		session.removeAttribute("Cart");
		return "redirect:gio-hang";
	}
}
