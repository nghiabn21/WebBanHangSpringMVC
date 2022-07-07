package DemoSpringMVC.Service.User;

import org.springframework.stereotype.Service;

import DemoSpringMVC.Entity.UserEntity;

@Service
public interface IAccountService { 
	public int AddAccount(UserEntity entity); 
	 
	public UserEntity CheckAccount(UserEntity userEntity);

}
