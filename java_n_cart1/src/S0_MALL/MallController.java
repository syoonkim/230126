package S0_MALL;

import java.util.Scanner;

import S1_Member.MemberController;
import S3_Admin.AdminController;
import S_MyUtil.Util;

public class MallController {
	
	private MallController() {}
	static private MallController instance=  new MallController();
	static public MallController getInstance() {
		return instance;
	}
	private MemberController memberController;	
	private AdminController adminController;
	private Scanner scan;
	private String memberLoginID;	
	private String memberLoginPwd;
	public void init(){
		scan = Util.scan;
		memberController = MemberController.getInstance();	
		adminController = AdminController.getInstance();
		memberLoginID = null;
		memberLoginPwd=null;
	}	
	public String getMemberLoginID() {
		return memberLoginID;
	}
	
	public String getMemberLoginPwd() {
		return memberLoginPwd;
	}
	
	public void menuMall() {
		while(true) {
			System.out.println("=== ���θ� ===");
			System.out.println("[1] �α��� [2] ȸ������ [0] ����");
			int select = scan.nextInt();
			if(select == 0) {
				System.out.println("[����]");
				break;
			}
			if(select == 1) {
				memberLoginID = memberController.memberLogin();
				memberLoginPwd=memberController.memberLoginPwd(memberLoginID);
				if(memberLoginID == null) {
					System.out.println("[�α��� ����]");
				}else if(memberLoginID.equals("admin")) {
					memberLoginID = adminController.menuAdmin();
					memberLoginPwd="admin";
				}else {
					memberLoginID = memberController.menuMember();
				}
			}
			else if(select == 2) {
				memberController.memberJoin();
			}
		}
	}
}
