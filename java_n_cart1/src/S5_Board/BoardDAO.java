package S5_Board;

import java.util.ArrayList;

import S_MyUtil.SystemView;
import S_MyUtil.Util;

public class BoardDAO {
	
	static public BoardDAO instance=new BoardDAO();
	
	Board b=new Board();
	ArrayList<BoardContents> bList=new ArrayList<BoardContents>();
	ArrayList<Reply> rList=new ArrayList<Reply>();
	
	public void boardInit() {
		b.count=0;
		b.pageSize=10;
		b.curPageNum=1;
		b.pageCount=0;
		b.startRow=0;
		b.endRow=0;
	}
	
	public void Board(String loginID, String loginPwd) {
		while(true) {
			/*����*/
			int length=bList.size();
			
			/*pgCnt*/
			b.pageCount=length%b.pageSize==0 ? length/b.pageSize : (length/b.pageSize)+1;
			int pgCnt=b.pageCount;
			
			/*srow*/
			b.startRow=(b.curPageNum-1)*b.pageSize;
			int startRow=b.startRow;
			
			/*erow*/
			if(length==0) b.endRow=0;
			else {
				b.endRow=startRow+b.pageSize>length ? length : startRow+b.pageSize;
				b.endRow--;
			}
			int endRow=b.endRow;
			
			SystemView.instance.v1();
			if(length!=0) {
				for(int i=startRow;i<=endRow;i++) {
					System.out.printf("[%d]  ",i);
					System.out.print(bList.get(i).title);
					System.out.printf("%40s\n",bList.get(i).writer);
				}
			}
			else System.out.println("");
			SystemView.instance.v2();
			System.out.println("���� ������ ��ȣ : "+b.curPageNum);
			SystemView.instance.v3();
			
			int sel=Util.scan.nextInt();
			Util.scan.nextLine();
			
			if(sel>5 || sel<0) {System.err.println("err");continue;}
			
			if(sel==1) {
				if(b.curPageNum==1) {System.err.println("[������ ��ȣ�� ����.]");continue;}
				b.curPageNum--;
			}
			else if(sel==2) {
				if(b.curPageNum==pgCnt || length==0) {System.err.println("[������ ��ȣ�� ����.");continue;}
				b.curPageNum++;
			}
			else if(sel==3) {
				writeBoard(loginID,loginPwd);
			}
			else if(sel==4) {
				if(length==0) {System.err.println("[��ȸ�� �Խñ��� ����.]");continue;}
				
				System.out.println("��ȸ�� �Խñ��� ��ȣ�� �Է��ϴ�. ");
				int read=Util.scan.nextInt();
				String writer=bList.get(read).writer;
				if(loginID.equals(writer)) {
					matchReadBoard(read,loginID,loginPwd);
				}
				else {
					disMatchReadBoard(read,loginID,loginPwd);
				}
			}
			else if(sel==5) {
				return;
			}
		}
	}
	
	String breakLine(String story) {
		String line="";
		if(story.length()>40) {
			while(true) {
				line+=story.substring(0,39)+"\n";
				story=story.substring(39,story.length());
				if(story.length()<=40) {line+=story;break;}
			}
		}
		else line=story;
		return line;
	}
	
	void writeBoard(String loginID, String loginPwd) {
		System.out.println("�Խñ��� ������ �Է��ϴ�. ");
		String title=Util.scan.nextLine();
		System.out.println("�Խñ��� ������ �ۼ��ϴ�. ");
		String story=Util.scan.nextLine();
		
		String line=breakLine(story);
		bList.add(new BoardContents(title,line,loginID,loginPwd));
	}
	
	void matchReadBoard(int num, String loginID, String loginPwd) {
		while(true) {
			int length=rList.size();
			SystemView.instance.v4(bList, num);
			if(length!=0) {
				int cnt=0;
				for(int i=0;i<length;i++) {
					if(rList.get(i).boardNum==num) {
//					int space=40-rList.get(i).story.length();
						System.out.print(i+")  "+rList.get(i).story);
						System.out.printf("%40s\n",rList.get(i).writer);
					}
				}
			}
			SystemView.instance.v5();
			
			int sel=Util.scan.nextInt();
			if(sel>5 || sel<0) continue;

			if(sel==1) {
				System.out.println("���ο� ������ �ۼ��ϴ� ");
				String update=Util.scan.next();
				
				String line=breakLine(update);
				bList.get(num).story=line;
				System.out.println("["+num+"��° �Խñ� ���� �Ϸ�.]");
				continue;
			}
			else if(sel==2) {
				bList.remove(num);
				System.out.println("["+num+"��° �Խñ� ���� �Ϸ�.]");
				break;
			}
			else if(sel==3) {
				writeRpy(num, loginID, loginPwd);
			}
			else if(sel==4) {
				deleteRpy(num, loginID, loginPwd);
			}
			else if(sel==5) break;
		}
	}
	
	void disMatchReadBoard(int num, String loginID, String loginPwd) {
		while(true) {
			int length=rList.size();
			SystemView.instance.v4(bList, num);
			if(length!=0) {
				int cnt=0;
				for(int i=0;i<length;i++) {
					if(rList.get(i).boardNum==num) {
//					int space=40-rList.get(i).story.length();
						System.out.print(i+")  "+rList.get(i).story);
						System.out.printf("%40s\n",rList.get(i).writer);
					}
				}
			}
			SystemView.instance.v6();
			
			int sel=Util.scan.nextInt();
			if(sel>3 || sel<0) continue;
			
			if(sel==1) writeRpy(num, loginID,loginPwd);
			if(sel==2) deleteRpy(num, loginID, loginPwd);
			else if(sel==3) break;
		}
		
	}
	
	void writeRpy(int boardNum, String loginID, String loginPwd) {
		Util.scan.nextLine();
		System.out.println("(40byte �̸�) ����� �Է��ϴ�. ");
		String story=Util.scan.nextLine();
		
		if(story.length()>=40) {
			System.out.println("����� �ʹ� ���.");
			return;
		}
		
		String line=breakLine(story);
		rList.add(new Reply("",line,loginID,loginPwd,boardNum));
	}
	
	void deleteRpy(int boardNum, String loginID, String loginPwd) {
		int length=rList.size();
		boolean admin=false;
		if(loginID.equals("admin")) admin=true;
		
		System.out.println("������ ����� ��ȣ�� �Է��ϴ�. ");
		int del=Util.scan.nextInt();
		if(del<0 || del>length) {
			System.out.println("�������� �ʴ� ��۹�ȣ.");
			return;
		}
		
		if(admin==false) {
			System.out.println("��й�ȣ�� �Է��ϴ�.");
			String pwd=Util.scan.next();
			if(!pwd.equals(loginPwd)) {
				System.out.println("��й�ȣ ����");
				return;
			}
		}
		
		rList.remove(del);
		System.out.println("["+del+"�� ��� ���� �Ϸ�.]");
	}

}
