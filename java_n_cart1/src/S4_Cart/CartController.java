package S4_Cart;

import java.util.ArrayList;
import java.util.Scanner;

import S0_MALL.MallController;
import S2_Item.Item;
import S_MyUtil.Util;

public class CartController {
	private CartController() {}
	static private CartController instance = new CartController();
	static public CartController getInstance() {
		return instance;
	}
	private CartDAO cartDAO;
	private Scanner scan;	
	private MallController mallController;	
	public void init(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
		scan = Util.scan;
		mallController = MallController.getInstance();
	}
	
	public void insertCart(Item item) {
		Cart cart = new Cart();
		cart.setNumber(cartDAO.getCartNumber());
		cart.setMemberID(mallController.getMemberLoginID());
		cart.setItemName(item.getItemName());
		cart.setItemPrice(item.getPrice());
		cartDAO.insertCart(cart);
	}
	
	public void menuCart() {
		ArrayList<Cart> oneCartList=cartDAO.getOneCartList(mallController.getMemberLoginID());
		while(true) {
			System.out.println("===[장바구니관리]===");
			System.out.println("1)장바구니출력 2)구입 3)삭제 0)뒤로가기");
			int sel = scan.nextInt();
			if(sel == 0) {
				break;
			}
			else if(sel == 1) {
				cartDAO.printOneCartList(oneCartList);
			}
			else if(sel==2) {
				cartDAO.purchaseItemsFromOneCartList(oneCartList);
			}
			else if(sel==3) {
				cartDAO.deleteItemFromOneCartList(oneCartList);
				
			}
		}
	}
	
	public void printAllCartList() {
		cartDAO.printAllCartList();
	}
	
	
	
	
	
}
