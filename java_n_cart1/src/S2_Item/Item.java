package S2_Item;

public class Item {
	private int number;
	private String categoryName;
	private String itemName;
	private int price;
	
	public Item(int number, String categoryName, String itemName, int price) {
		super();
		this.number = number;
		this.categoryName = categoryName;
		this.itemName = itemName;
		
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		String print = String.format("[%-6d] [%10s] [%10s] [%10d]", 
				number , categoryName , itemName , price);
		return print;
	}
}
