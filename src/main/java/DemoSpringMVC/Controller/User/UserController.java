package DemoSpringMVC.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DemoSpringMVC.Entity.UserEntity;
import DemoSpringMVC.Service.User.IAccountService;

@Controller
public class UserController extends BaseController {

	@Autowired
	private IAccountService accountService;

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView Register() {
		_mvShare.setViewName("user/account/register"); 
		_mvShare.addObject("categorys", basehomeImpl.GetDataCategorys());   
		_mvShare.addObject("user", new UserEntity());
		return _mvShare;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView CreaterAcc(@ModelAttribute("user") UserEntity user) {
		int count = accountService.AddAccount(user);
		if (count > 0) {
			_mvShare.addObject("status", "đăng ký thành công");
		} else {
			_mvShare.addObject("status", "đăng ký không thành công");
		}
		_mvShare.setViewName("user/account/register");
		return _mvShare;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session, @ModelAttribute("user") UserEntity user) {
		user = accountService.CheckAccount(user);

		if (user != null) {
			
			_mvShare.setViewName("redirect:trang-chu");
			session.setAttribute("LoginInfo", user);
		} else {
			_mvShare.addObject("statusLogin", "Đăng nhập không thành công");
		}

		return _mvShare;
	}

	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String dangXuat(HttpSession session, HttpServletRequest request) {

		session.removeAttribute("LoginInfo");
		

		return "redirect:" + request.getHeader("Referer");
	}

}
