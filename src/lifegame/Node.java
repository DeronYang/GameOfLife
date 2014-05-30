package lifegame;

public class Node {
	private int curState;
	private int nxtState;
	public Node(int curState, int nxtState) {
		super();
		this.curState = curState;
		this.nxtState = nxtState;
	}
	public int getCurState() {
		return curState;
	}
	public void setCurState(int curState) {
		this.curState = curState;
	}
	public int getNxtState() {
		return nxtState;
	}
	public void setNxtState(int nxtState) {
		this.nxtState = nxtState;
	}
	
}
