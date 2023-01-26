package S2_Item;


import java.util.ArrayList;
import java.util.Scanner;
import S4_Cart.CartController;
import S_MyUtil.Util;

public class ItemController {
	private ItemController() {}
	static private ItemController instance = new ItemController();
	static public ItemController getInstance() {
		return instance;
	}
	
	Scanner scan;
	ItemDAO itemDAO;
	CartController cartController;
	
	public void init(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
		scan = Util.scan;
		cartController = CartController.getInstance();
	}
	
	public void adminAddItem() {
		System.out.println("[아이템추가] 카테고리 입력 : ");
		String categoryName = scan.next();
	
		System.out.println("[아이템추가] 아이템이름 입력 :  ");
		String itemName = scan.next();
		boolean check = itemDAO.checkItemName(itemName);
		if(check == true) {
			System.out.println("[중복 아이템 이름]");
			return;
		}
		
		System.out.println("[아이템추가] 가격입력 : ");
		int price = scan.nextInt();
		int number = itemDAO.getNextItemNumber();
		
		Item item = new Item(number, itemName, categoryName, price);
		itemDAO.addItem(item);
		System.out.println("[아이템추가 성공]");
		adminPrintItemList();
	}
	
	public void adminPrintItemList() {
		itemDAO.printItemList();
	}
	
	public void adminPrintOneCategoryItemList(ArrayList<Item> categoryList) {
		itemDAO.printItemList(categoryList);
	}
	
	public void menuShop() {
		ArrayList<String> categoryList = itemDAO.getCategoryList();
		while(true) {
			System.out.println("===[ 카테고리 ]===");
			printCategoryList(categoryList);
			System.out.println("0) 뒤로가기");
			int select = scan.nextInt();
			if(select == 0) {
				break;
			}
			select -= 1;
			menuItemList(categoryList.get(select));
		}
	}
	public void printCategoryList(ArrayList<String> categoryList) {
		for(int i = 0; i < categoryList.size(); i++) {
			System.out.println(i + 1 + ")" + categoryList.get(i));
		}
	}
	
	public void menuItemList(String category) {
		ArrayList<Item> categoryList = itemDAO.getCategoryItemList(category);		
		while(true) {				
			System.out.println("===["+ category +"]===");
			adminPrintOneCategoryItemList(categoryList);
			System.out.println("0) 뒤로가기");
			int select = scan.nextInt();
			if(select == 0) {
				break;
			}
			Item item = categoryList.get(select -1);
			cartController.insertCart(item);
		}
	}
	
}
