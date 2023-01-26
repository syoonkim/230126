package S1_Member;

import java.util.Scanner;

import S0_MALL.MallController;
import S2_Item.ItemController;
import S4_Cart.CartController;
import S5_Board.BoardDAO;
import S_MyUtil.Util;

public class MemberController {
	private MemberController() {}
	static private MemberController instance = new MemberController();
	static public MemberController getInstance() {
		return instance;
	}
	private MemberDAO memberDAO;
	private BoardDAO boardDAO;
	private ItemController itemController;
	private CartController cartController;
	private Scanner scan;
	public void init(MemberDAO memberDAO){
		this.memberDAO = memberDAO;
		boardDAO=BoardDAO.instance;
		itemController = ItemController.getInstance();
		cartController = CartController.getInstance();
		scan = Util.scan;
		managerSetting();
		boardInit();
	}
	public void managerSetting() {
		if(memberDAO.checkMember("admin") == false) {
			Member member = new Member( 1,"admin","admin","관리자");		
			memberDAO.addMember(member);
		}	
	}
	public String memberLogin() {
		System.out.println("===[ 로그인 ]===");
		System.out.println("[로그인] 아이디 입력 : ");
		String id = scan.next();
		System.out.println("[로그인] 비밀번호 입력 : ");
		String pw = scan.next();
		boolean check = memberDAO.checkMemberLogin(id, pw);
		if(check == true) {
			System.out.println("["+id+" 로그인]");
			return id;
		}
		return null;
	}
	
	public String memberLoginPwd(String memberLoginID) {
		String pwd=memberDAO.findPwd(memberLoginID);
		return pwd;
	}
	
	public void memberJoin() {		
		System.out.println("===[ 회원가입 ]===");
		System.out.println("[회원가입] 아이디 입력 : ");
		String id = scan.next();
		boolean check = memberDAO.checkMember(id);
		if(check == true) {
			System.out.println("[중복아이디]");
		}
		else {
			System.out.println("[회원가입] 비밀번호 입력 : ");
			String pw = scan.next();
			System.out.println("[회원가입] 이름 입력 : ");
			String name = scan.next();		
			int memberNumber = memberDAO.getNextNumber();
			Member member = new Member(memberNumber , id , pw , name);		
			memberDAO.addMember(member);
			System.out.println("[회원가입 성공]");
		}
	}
	public String menuMember() {
		while(true) {
			System.out.println("[1.쇼핑] [2.장바구니] [3.게시판] [0.뒤로가기] ");
			int select = scan.nextInt();
			if(select == 0) {
				return null;
			}else if(select == 1) {
				itemController.menuShop();
			}else if(select == 2) {
				cartController.menuCart();
			}else if(select == 3) {
				board();
			}
		}	
	}
	
	public void showMembers() {
		memberDAO.showMembers();
	}
	
	public void boardInit() {
		boardDAO.boardInit();
	}
	
	public void board() {
		String loginID=MallController.getInstance().getMemberLoginID();
		String loginPwd=MallController.getInstance().getMemberLoginPwd();
		System.out.println(loginPwd);
		boardDAO.Board(loginID,loginPwd);
	}
	
}
