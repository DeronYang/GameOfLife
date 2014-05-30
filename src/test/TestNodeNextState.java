package test;
import lifegame.LifeGame;
import lifegame.Node;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class TestNodeNextState {
	private LifeGame lg;
	@Before
	public void setUp() throws Exception {
		Node[][] map;
		map=new Node[4][4];
		
		map[0][0]=new Node(0,-1);
		map[0][1]=new Node(0,-1);
		map[0][2]=new Node(0,-1);
		map[0][3]=new Node(0,-1);
		
		map[1][0]=new Node(0,-1);
		map[1][1]=new Node(0,-1);
		map[1][2]=new Node(0,-1);
		map[1][3]=new Node(1,-1);
		
		map[2][0]=new Node(1,-1);
		map[2][1]=new Node(1,-1);
		map[2][2]=new Node(1,-1);
		map[2][3]=new Node(0,-1);
		
		map[3][0]=new Node(0,-1);
		map[3][1]=new Node(1,-1);
		map[3][2]=new Node(1,-1);
		map[3][3]=new Node(0,-1);
		lg=new LifeGame(map,4,4);
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testNodeShouldDieOfLonely() {
		org.junit.Assert.assertEquals(0,lg.getNodeNextState(1,3));
	}
	@Test
	public void testNodeShouldDieOfcrowd() {
		org.junit.Assert.assertEquals(0,lg.getNodeNextState(3,1));
	}
}
