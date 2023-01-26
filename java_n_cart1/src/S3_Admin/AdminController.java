package S3_Admin;

import java.util.ArrayList;
import java.util.Scanner;

import S1_Member.MemberController;
import S2_Item.ItemController;
import S4_Cart.Cart;
import S4_Cart.CartController;
import S_MyUtil.Util;

public class AdminController {
	private AdminController() {}
	static private AdminController instance = new AdminController();
	static public AdminController getInstance() {
		return instance;
	}	
	private Scanner scan;	
	private MemberController memberController;
	private ItemController itemController;
	private CartController cartController;
	
	static ArrayList<Cart> orderList=new ArrayList<Cart>();
	public void orderInin(ArrayList<Cart> oneCartList) {
		for(int i=0;i<oneCartList.size();i++) {
			orderList.add(oneCartList.get(i));
		}
	}
	
	public void init() {
		scan = Util.scan;
		itemController = ItemController.getInstance();
		cartController = CartController.getInstance();
		memberController= MemberController.getInstance();
	}
	public String menuAdmin() {
		while(true) {
			System.out.println("[1.회원관리] [2.상품관리] [3.장바구니관리] [0.뒤로가기]");
			int select = scan.nextInt();
			if(select == 0) {
				return null;
			}else if(select == 1) {
				menuMemberAdmin();
			}else if(select == 2) {
				menuItemAdmin();
			}else if(select == 3) {
				menuCartAdmin();
			}
		}
	}
	public void menuMemberAdmin() {
		while(true) {
			System.out.println("=== 회원 관리자 ===");
			System.out.println("[1.회원 목록] [2.주문목록 ] [0.뒤로가기]");
			int select = scan.nextInt();
			if(select == 0) {
				break;
			}else if(select == 1) {
				memberController.showMembers();
			}else if(select == 2) {
				if(orderList.size()!=0) {
					for(int i=0;i<orderList.size();i++) {
						System.out.println(orderList.get(i));
					}
				}
			}
		}
	}
	public void menuItemAdmin() {
		while(true) {		
			System.out.println("=== 아이템 관리자 ===");
			System.out.println("[1.상품전체출력 ] [2.아이템추가] [3.아이템삭제] [0.뒤로가기]");
			int select = scan.nextInt();
			if(select == 0) {
				break;
			}else if(select == 1) {
				itemController.adminPrintItemList();
				
			}else if(select == 2) {
				itemController.adminAddItem();
			}
		}
	}
	
	public void menuCartAdmin() {
		while(true) {		
			System.out.println("=== 장바구니 관리자 ===");
			System.out.println("[1.장바구니전체출력 ] [0.뒤로가기]");
				int select = scan.nextInt();
				if(select == 0) {
					break;
				}else if(select == 1) {
					cartController.printAllCartList();
					
				}
			}
	}
	
}
