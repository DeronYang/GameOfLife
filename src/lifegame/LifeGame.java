package lifegame;
public class LifeGame{
	private int maxR;
	private int maxC;
	private Node[][] map;
	public LifeGame(){
		map=new Node[3][3];
		map[0][0]=new Node(0,-1);
		map[0][1]=new Node(0,-1);
		map[0][2]=new Node(0,-1);
		
		map[1][0]=new Node(1,-1);
		map[1][1]=new Node(1,-1);
		map[1][2]=new Node(1,-1);
		
		map[2][0]=new Node(0,-1);
		map[2][1]=new Node(1,-1);
		map[2][2]=new Node(1,-1);
		
		maxR=2;
		maxC=2;
	}
	public LifeGame(Node[][] gameMap,int mapRowNum,int mapColNum){
		map=gameMap;
		maxR=mapRowNum-1;
		maxC=mapColNum-1;
	}
	public int getAliveNeighborNum(int row,int col){
		int count=0;
		count+=getNeighborState(row-1,col-1);
		count+=getNeighborState(row-1,col);
		count+=getNeighborState(row-1,col+1);
		
		count+=getNeighborState(row,col-1);
		count+=getNeighborState(row,col+1);
		
		count+=getNeighborState(row+1,col-1);
		count+=getNeighborState(row+1,col);
		count+=getNeighborState(row+1,col+1);
		return count;
		
	}
	public int getNeighborState(int row,int col){
		if(row<0||row>maxR||col<0||col>maxC){
			return 0;
		}
		else{
			return map[row][col].getCurState();
		}
		
	}
}