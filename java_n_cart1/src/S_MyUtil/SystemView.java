package S_MyUtil;

import java.util.ArrayList;

import S5_Board.BoardContents;

public class SystemView {
	
	public static SystemView instance=new SystemView();
	
	public void v1() {
		System.out.println("======================미니자유게시판======================");
		System.out.printf("[N]  제목%40s\n","작성자");
		System.out.println("------------------------------------------------------");
	}
	
	public void v2() {
		System.out.println();
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	}
	
	public void v3() {
		System.out.println("======================================================");
		System.out.println("[1]이전페이지 [2]다음페이지 [3]글쓰기 [4]게시글 조회 [5]뒤로가기");
	}
	
	public void v4(ArrayList<BoardContents> bList, int num) {
		System.out.println("=====================["+num+"] 번째 게시글=====================");
		System.out.println("작성자 : "+bList.get(num).writer);
		System.out.println("------------------------------------------------------\n");
		System.out.println(bList.get(num).story);
		System.out.println("\n------------------------------------------------------");
	}
	
	public void v5() {
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("[1]게시글 수정 [2]게시글 삭제 [3]댓글쓰기 [4]댓글삭제 [5]뒤로가기");
	}
	
	public void v6() {
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("[1]댓글쓰기 [2]댓글삭제 [3]뒤로가기");
	}
	
	/**/
	
}
