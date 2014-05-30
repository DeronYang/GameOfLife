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
	public int getNodeNextState(int row,int col){
		int aliveNeighborNum=getAliveNeighborNum(row, col);
		if(map[row][col].getCurState()==1&&aliveNeighborNum<2){
			return 0;
		}
		if(map[row][col].getCurState()==1&&aliveNeighborNum>3){
			return 0;
		}
		if(map[row][col].getCurState()==1&&(aliveNeighborNum==3||aliveNeighborNum==2)){
			return 1;
		}
		if(map[row][col].getCurState()==0&&aliveNeighborNum==3){
			return 1;
		}
		return 0;
	}
	/**
	 * 
	 * @param times the number of generation will be calculated
	 */
	public void startGame(int times){
		for(int n=0;n<=times;n++){
			System.out.println("generation "+n+":");
			for(int i=0;i<=maxR;i++){
				for(int j=0;j<=maxC;j++){
					System.out.print(map[i][j].getCurState()+" ");
					map[i][j].setNxtState(getNodeNextState(i,j));
				}
				System.out.println();
			}
			for(int i=0;i<=maxR;i++){
				for(int j=0;j<=maxC;j++){
					map[i][j].setCurState(map[i][j].getNxtState());
					map[i][j].setNxtState(-1);
				}
			}
		}
	}
	public static void main(String[] args) {
		LifeGame lg=new LifeGame();
		lg.startGame(3);
	}
}