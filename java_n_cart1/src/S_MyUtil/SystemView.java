package S_MyUtil;

import java.util.ArrayList;

import S5_Board.BoardContents;

public class SystemView {
	
	public static SystemView instance=new SystemView();
	
	public void v1() {
		System.out.println("======================�̴������Խ���======================");
		System.out.printf("[N]  ����%40s\n","�ۼ���");
		System.out.println("------------------------------------------------------");
	}
	
	public void v2() {
		System.out.println();
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	}
	
	public void v3() {
		System.out.println("======================================================");
		System.out.println("[1]���������� [2]���������� [3]�۾��� [4]�Խñ� ��ȸ [5]�ڷΰ���");
	}
	
	public void v4(ArrayList<BoardContents> bList, int num) {
		System.out.println("=====================["+num+"] ��° �Խñ�=====================");
		System.out.println("�ۼ��� : "+bList.get(num).writer);
		System.out.println("------------------------------------------------------\n");
		System.out.println(bList.get(num).story);
		System.out.println("\n------------------------------------------------------");
	}
	
	public void v5() {
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("[1]�Խñ� ���� [2]�Խñ� ���� [3]��۾��� [4]��ۻ��� [5]�ڷΰ���");
	}
	
	public void v6() {
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("[1]��۾��� [2]��ۻ��� [3]�ڷΰ���");
	}
	
	/**/
	
}
