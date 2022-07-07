package DemoSpringMVC.Service.User;

import org.springframework.stereotype.Service;

import DemoSpringMVC.Dto.PaginatesDto;

@Service
public interface IPaginatesService { 
	public PaginatesDto getInforPaginates(int totalData,int limit, int currentPage);

}
