package S4_Cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import S3_Admin.AdminController;
import S_MyUtil.Util;

public class CartDAO {

	private ArrayList<Cart> cartList;
	private int cartNumber;

	public CartDAO() {
		cartList = new ArrayList<Cart>();
		cartNumber = 1000;
	}

	public int getCartNumber() {
		cartNumber += 1;
		return cartNumber;
	}

	public void insertCart(Cart cart) {
		cartList.add(cart);
	}

	public ArrayList<Cart> getOneCartList(String memberLoginID) {
		ArrayList<Cart> oneCartList = new ArrayList<Cart>();


		for (int i = 0; i < cartList.size(); i++) {
			if(cartList.get(i).getMemberID().equals(memberLoginID)) {
				oneCartList.add(cartList.get(i));
			}
		}
	
		return oneCartList;
	}
	
	public void printOneCartList(ArrayList<Cart> oneCartList) {
		for (int i = 0; i < oneCartList.size(); i++) {
			System.out.println(i + 1 + ")" + oneCartList.get(i));
		}
	}
	
	public void printAllCartList() {
		for (int i = 0; i < cartList.size(); i++) {
			System.out.println(i + 1 + ")" + cartList.get(i));
		}
	}
	
	public void deleteItemFromOneCartList(ArrayList<Cart> oneCartList) {
		System.out.println("목록에서 삭제할 번호를 입력하다.");
		int idx=Util.scan.nextInt();
		idx--;
		oneCartList.remove(idx);
		cartList.remove(idx);
		System.out.println((idx+1)+"번, 목록에서 삭제 완료하다.");
	}
	
	public void purchaseItemsFromOneCartList(ArrayList<Cart> oneCartList) {
		if(oneCartList.size()==0) {System.out.println("즐");return;}
		int sum=0;
		for(int i=0;i<oneCartList.size();i++) {
			sum+=oneCartList.get(i).getItemPrice();
		}
		System.out.println(oneCartList.size()+"개 품목을 구입하다. ("+sum+"원)\n[1]y [2]n");
		int sel=Util.scan.nextInt();
		if(sel==2) return;
		else {
			reportPurchaseListToAdministrator(oneCartList);
			cleanCart(oneCartList);
			System.out.println(sum+"원 결제 완료.");
		}
		
	}
	
	public void cleanCart(ArrayList<Cart> oneCartList) {
		for(int i=0;i<oneCartList.size();i++) {
			int itemNum=oneCartList.get(i).getNumber();
			for(int j=0;j<cartList.size();j++) {
				if(cartList.get(j).getNumber()==itemNum) {cartList.remove(j);}
			}
		}
		oneCartList.clear();
	}
	
	public void reportPurchaseListToAdministrator(ArrayList<Cart> oneCartList) {
		AdminController.getInstance().orderInin(oneCartList);
	}
	
}
