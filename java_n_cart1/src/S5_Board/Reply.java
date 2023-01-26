package S5_Board;

public class Reply extends BoardContents {
	
	public int boardNum;

	public Reply(String title, String story, String writer, String pwd, int boardNum) {
		super(title, story, writer, pwd);
		this.boardNum=boardNum;
	}

}
