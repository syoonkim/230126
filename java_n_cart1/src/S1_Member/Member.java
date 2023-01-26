package S1_Member;

public class Member {
	private int memberNumber;
	private String memberID;
	private String memberPW;
	private String memberName;
	
	public Member() {}
	
	public Member(int memberNumber, String memberID, String memberPW, String memberName) {
		this.memberNumber = memberNumber;
		this.memberID = memberID;
		this.memberPW = memberPW;
		this.memberName = memberName;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemberPW() {
		return memberPW;
	}
	public void setMemberPW(String memberPW) {
		this.memberPW = memberPW;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
}
