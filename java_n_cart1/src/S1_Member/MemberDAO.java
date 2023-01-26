package S1_Member;
import java.util.ArrayList;
public class MemberDAO {
	private ArrayList<Member> memberList;
	private int memberNumber;

	public MemberDAO() {
		memberNumber = 1000;
		memberList = new ArrayList<>();
		setSampleData();
	}
	public void addMember(Member member) {
		memberList.add(member);
	}
	public int getNextNumber() {
		memberNumber += 1;
		return memberNumber;
	}
	boolean checkMember(String id) {
		for (int i = 0; i < memberList.size(); i++) {
			if (id.equals(memberList.get(i).getMemberID())) {
				return true;
			}
		}
		return false;
	}
	boolean checkMemberLogin(String id, String pw) {
		for (int i = 0; i < memberList.size(); i++) {
			if (id.equals(memberList.get(i).getMemberID()) && 
					pw.equals(memberList.get(i).getMemberPW())) {
				return true;
			}
		}
		return false;
	}
	public void setSampleData() {

		Member member = new Member(getNextNumber(), "a", "a", "±èÃ¶¹Î");
		addMember(member);
		member = new Member(getNextNumber(), "b", "b", "ÀÌ¹Î¿µ");
		addMember(member);
	}
	
	public void showMembers() {
		for(Member m:memberList) {
			System.out.println("["+m.getMemberNumber()+" | "+m.getMemberID()+" | "+m.getMemberName()+"]");
		}
	}
	
	public String findPwd(String id) {
		int length=memberList.size();
		String pwd="";
		for(int i=0;i<length;i++) {
			if(memberList.get(i).getMemberID().equals(id)) pwd=memberList.get(i).getMemberPW();
		}
		return pwd;
	}
}
