package S0_MALL;


import S1_Member.MemberController;
import S1_Member.MemberDAO;
import S2_Item.ItemController;
import S2_Item.ItemDAO;
import S3_Admin.AdminController;
import S4_Cart.CartController;
import S4_Cart.CartDAO;
import S_MyUtil.Util;

public class _Main {

	public static void main(String[] args) {
	
		MallController.getInstance().init();
		AdminController.getInstance().init();
		MemberController.getInstance().init(new MemberDAO());		
		ItemController.getInstance().init(new ItemDAO());
		CartController.getInstance().init(new CartDAO());
		
		MallController.getInstance().menuMall();
		Util.scan.close();
	}

}
