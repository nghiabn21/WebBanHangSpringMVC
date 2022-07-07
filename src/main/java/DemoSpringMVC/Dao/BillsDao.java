package DemoSpringMVC.Dao;

import org.springframework.stereotype.Repository;

import DemoSpringMVC.Entity.BillDetail;
import DemoSpringMVC.Entity.Bills;

@Repository
public class BillsDao extends BaseDao {  
	
	public int AddBills(Bills bill) { 
		StringBuffer sql = new StringBuffer(); 
		sql.append("insert into bills ");
		sql.append("( ");
		sql.append("    'user', 'phone', 'displayName', 'address', 'total', 'quanty', 'note' ");
		sql.append(") ");
		sql.append("value ");
		sql.append("( ");
		sql.append("    '"+bill.getUser()+"', ");
		sql.append("    '"+bill.getPhone()+"', ");
		sql.append("    '"+bill.getDisplayName()+"', ");
		sql.append("    '"+bill.getAddress()+"', ");
		sql.append("    '"+bill.getTotal()+"', ");
		sql.append("    '"+bill.getQuanty()+"', ");
		sql.append("    '"+bill.getNote()+"' ");
		sql.append(");");
		 
		int insert = jdbcTemplate.update(sql.toString()); 
		return insert ;
	} 
	 
	public int GetIDLastBills() { 
		StringBuffer sql = new StringBuffer(); 
		sql.append("select max(id) from bills;"); 
		int id = jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, int.class); 
		return id ;
	}  
	 
	public int AddBillsDetail(BillDetail bill) { 
		StringBuffer sql = new StringBuffer(); 
		sql.append("insert into billdetail ");
		sql.append("( ");
		sql.append("    'idProduct', 'idBills', 'quanty', 'total' ");
		sql.append(") ");
		sql.append("value ");
		sql.append("( ");
		sql.append("    '"+bill.getIdProduct()+"', "); 
		sql.append("    '"+bill.getIdBills()+"', ");
		sql.append("    '"+bill.getQuanty()+"', ");
		sql.append("    '"+bill.getTotal()+"' ");
		sql.append(")");
		 
		int insert = jdbcTemplate.update(sql.toString()); 
		return insert ;
	} 
	 
	
	

}
