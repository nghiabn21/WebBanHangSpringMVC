package DemoSpringMVC.Service.User;

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DemoSpringMVC.Dao.UserDao;
import DemoSpringMVC.Entity.UserEntity;

@Service
public class AccountServiceImpl implements IAccountService{ 
	 
	@Autowired 
	private UserDao dao; 

	@Override
	public int AddAccount(UserEntity user) { 
		 
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)) ); //mã hóa mật khẩu với mật khẩu được ng dùng truyền vào
		
		return dao.AddAccount(user);
	}

	@Override
	public UserEntity CheckAccount(UserEntity userEntity) { 
		 
		String pass = userEntity.getPassword();  // lưu passwword trước
		
		userEntity = dao.getUserByAccount(userEntity); 
		if(userEntity != null) {  
			if(BCrypt.checkpw(pass, userEntity.getPassword())) { //so sánh mật khẩu ng ta truyền vào và mk mã hóa trong db
				return userEntity ;
			}else { 
				return null ;
			}
			
		}
		return null;
	} 
	

}
