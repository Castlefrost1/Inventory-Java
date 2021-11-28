package def;

public class Inventory {
	
	private String inventoryID;
	private String inventoryName;
	private int inventoryPrice;
	private int inventoryStock;
	

	public Inventory() {
		// TODO Auto-generated constructor stub
	}
	public String getInventoryID() {
		return inventoryID;
	}
	public void setInventoryID(String inventoryID) {
		this.inventoryID = inventoryID;
	}
	public String getInventoryName() {
		return inventoryName;
	}
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	public int getInventoryPrice() {
		return inventoryPrice;
	}
	public void setInventoryPrice(int inventoryPrice) {
		this.inventoryPrice = inventoryPrice;
	}
	public int getInventoryStock() {
		return inventoryStock;
	}
	public void setInventoryStock(int inventoryStock) {
		this.inventoryStock = inventoryStock;
	}
	
	public Inventory(String inventoryID, String inventoryName, int inventoryPrice, int inventoryStock) {
		super();
		this.inventoryID = inventoryID;
		this.inventoryName = inventoryName;
		this.inventoryPrice = inventoryPrice;
		this.inventoryStock = inventoryStock;
	}
}
