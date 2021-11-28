package def;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner scan = new Scanner(System.in);
	Vector<Inventory> vecInven = new Vector<Inventory>();
	Inventory inv = new Inventory();

	public Main() {
		// TODO Auto-generated constructor stub
		homeScreen();
	}
	private void viewItem() {
		if (vecInven.size()==0) {
			System.out.println("No items in inventory");
			System.out.println("Press enter to continue!");
			scan.nextLine();
		} else {
			for (Inventory inv : vecInven) {
				System.out.println("[" + inv.getInventoryID() + "]" + " : " + "[" + inv.getInventoryName() + "]" + " [" + inv.getInventoryPrice() + "]" + " [" + inv.getInventoryStock() + "]");
			}
		}
	}
	private void checkoutItem() {
		if(vecInven.size()==0) {
			System.out.println("Inventory is empty!");
		} else {
			String itemIDcheckout = inputItemID();
			
			for (int i=0; i<vecInven.size();i++) {
				if(vecInven.get(i).getInventoryID().equals(itemIDcheckout)) {
					int itemStock;
					do {
						System.out.print("Input item stock to be checkout [1-" + vecInven.get(i).getInventoryStock() + "] : ");
						try {
							itemStock = scan.nextInt();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							itemStock=-1;
							System.out.println("Input must be a number!");
						}
						scan.nextLine();
					} while(itemStock <= 0 || itemStock > vecInven.get(i).getInventoryStock());
					System.out.println("Item Price = " + (itemStock * vecInven.get(i).getInventoryPrice()));
					if(itemStock == vecInven.get(i).getInventoryStock()) {
						vecInven.remove(i);
					} else {
						int stockLama = vecInven.get(i).getInventoryStock();
//						vecInven.set(i,vecInven.get(i).getInventoryStock()-stockLama);
						vecInven.get(i).setInventoryStock(vecInven.get(i).getInventoryStock()-itemStock);
					}
					return;
				}
			}
		}
	}
	private String inputItemID() {
		String insertID;
		do {
			System.out.print("Masukkan Item ID [must be 5 digit!] : ");
			insertID = scan.nextLine();
		} while (insertID.length()!=5);
		return insertID;
	}
	private void insertItem() {
		String itemID;
		String itemName;
		int itemPrice = 0;
		int itemStock;
		
		itemID = inputItemID();
		
		if(vecInven.size()!=0) {
			for (Inventory inv : vecInven) {
				System.out.println("Item already exists!");
				System.out.println("[" + inv.getInventoryID() + "]" + " : " + "[" + inv.getInventoryName() + "]" + " [" + inv.getInventoryPrice() + "]" + " [" + inv.getInventoryStock() + "]");
			
				int itemStockAdded;
				do { 
					System.out.println("Input stock to add : ");
					try {
						itemStockAdded = scan.nextInt();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						itemStockAdded=-1;
						System.out.println("Input must be number!");
					}
					scan.nextLine();
				} while(itemStockAdded==-1);
				inv.setInventoryStock(inv.getInventoryStock() + itemStockAdded);
				System.out.println("Item Stock Updated!");
			}
		}
		itemName = inputItemName();
		
		do {
			System.out.print("Masukkan Harga : ");
			try {
				itemPrice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException a) {
				// TODO Auto-generated catch block
//				itemPrice = 0;
				System.out.println("Input must be a number!");
				continue;
			}
//			scan.nextLine();
		} while (itemPrice < 10000);
		
		itemStock = inputItemStock();
		
		vecInven.add(new Inventory(itemID, itemName, itemPrice, itemStock));
		System.out.println("Success!");
		return;
	}

	private int inputItemStock() {
		// TODO Auto-generated method stub
		int itemStock;
		do {
			System.out.print("Masukkan Stok : ");
			try {
				itemStock = scan.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				itemStock = -1;
				System.out.println("Input must be a Number!");
			}
			scan.nextLine();
			} while(itemStock < 1);
		return itemStock;
	}

	private String inputItemName() {
		// TODO Auto-generated method stub
		String itemName;
//		item name 1-28
		do {
			System.out.print("Masukkan nama item (1 - 28 character[s]): ");
			itemName = scan.nextLine();
		} while (itemName.length()<1 || itemName.length()>28);
		return itemName;
	}
	
	private void homeScreen() {
		int menu;
		
		do {
			System.out.println("Inventory Management System");
			System.out.println("===========================");
			System.out.println("1. View Item in Inventory");
			System.out.println("2. Add New Item to Inventory");
			System.out.println("3. Checkout Item from Inventory");
			System.out.println("4. Exit");
			System.out.print("Option : ");
			
			try {
				menu = scan.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				menu = -1;
				System.out.println("Input must be Integer!");	
			}
			scan.nextLine();
			
			if (menu==1) {
				viewItem();
			}else if (menu==2) {
				insertItem();
			}else if (menu==3) {
				checkoutItem();
			}
		} while (menu!=4);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
}
