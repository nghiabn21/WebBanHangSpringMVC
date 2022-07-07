package DemoSpringMVC.Service.User;

import org.springframework.stereotype.Service;

import DemoSpringMVC.Dto.PaginatesDto;

@Service
public class PaginateServiceImpl implements IPaginatesService { 
	

	

	@Override
	public PaginatesDto getInforPaginates(int totalData, int limit, int currentPage) {
		PaginatesDto paginatesDto = new PaginatesDto(); 
	
		paginatesDto.setLimit(limit); 
		paginatesDto.setTotalPage(SetInforTotalPage(totalData, limit));  
		paginatesDto.setCurrentPage(checkCurrentpage(currentPage, paginatesDto.getTotalPage()));  
		 
		int start  = FindStart(paginatesDto.getCurrentPage(), limit) ;  
		paginatesDto.setStart(start); 
		
		int end  = FindEnd(paginatesDto.getStart(), limit, totalData) ;  
		paginatesDto.setEnd(end);
		
		
		return paginatesDto;
	}

	private int FindEnd(int start, int limit, int totalData) {
	    
		return start + limit  > totalData ? totalData : start + limit - 1 ;
	}

	private int FindStart(int currentPage, int limit) {
		
		return ((currentPage - 1) * limit ) + 1;
	}

	private int SetInforTotalPage(int totalData, int limit) {  
		Integer totalPage = 0 ;
		totalPage = totalData/limit ;  // tổng số dữ liệu chia cho số sản phẩm 1 trang  
		totalPage = totalPage * limit < totalData ? totalPage + 1 : totalPage ;
		return totalPage;	
	} 
	 
	public int checkCurrentpage(int currentPage, int totalPage) { 
		if(currentPage < 1) { //ng dùng nhập số trang nhỏ hơn 0 thì về trang 1
			return 1 ;
		} 
		if(currentPage > totalPage) { //ng dùng nhập số trang lớn hơn tổng số trang thì về lớn nhất
			return totalPage; 
		} 
		return currentPage ;
		
	}

}
