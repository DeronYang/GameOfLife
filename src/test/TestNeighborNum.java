package test;
import lifegame.LifeGame;
import lifegame.Node;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class TestNeighborNum {

	private LifeGame lg;
	@Before
	public void setUp() throws Exception {
		Node[][] map;
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
		lg=new LifeGame(map,3,3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAliveNeighborNum() {
		//test node in corner
		org.junit.Assert.assertEquals(2,lg.getAliveNeighborNum(0, 0));	
		//test node in edges
		org.junit.Assert.assertEquals(2,lg.getAliveNeighborNum(1, 0));	
		//test node in the middle
		org.junit.Assert.assertEquals(4,lg.getAliveNeighborNum(1, 1));	
	}	
}
