package DemoSpringMVC.Entity;

public class BillDetail {
	private int id;
	private int idProduct; 
	private int idBills;
	public int getIdBills() {
		return idBills;
	}

	public void setIdBills(int idBills) {
		this.idBills = idBills;
	}

	private int quanty;
	private double total;

	public BillDetail() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
