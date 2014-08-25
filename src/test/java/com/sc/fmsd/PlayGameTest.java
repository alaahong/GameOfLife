package com.sc.fmsd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sc.fmsd.vo.Point;

public class PlayGameTest {
	private PlayGame pg;
	private String[][] strArr = new String[][] {
			{ ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", "*", ".", ".", "." },
			{ ".", ".", ".", "*", "*", ".", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", "." } };
	Point p1 = new Point(1, 3, 0);
	Point p2 = new Point(1, 4, 1);
	Point p3 = new Point(2, 3, 1);
	Point p4 = new Point(2, 4, 1);
	Point p5 = new Point(1, 1, 0);
	Point p6 = new Point(1, 5, 1);
	Point p7 = new Point(3, 3, 0);
	@Before
	public void setUp() throws Exception {
		pg = new PlayGame();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void liveStockNumTest() {
		org.junit.Assert.assertEquals(3, pg.liveStockNum(p1, strArr));
	}


	/*
	 * @author :ChenChen :1492148
	 * 
	 * @description : Any live cell with fewer than two live neighbours dies
	 */
	@Test
	public void testValidateFewerThanTwoLive() {
		// 初始矩阵生命生死状态
		String[][] initalArray = new String[][] {
				{ ".", ".", ".", ".", ".", ".", ".", "." },
				{ ".", "*", ".", "*", ".", ".", "*", "." },
				{ ".", ".", ".", "*", "*", ".", "*", "." },
				{ ".", ".", ".", ".", ".", ".", ".", "." } };

		// 活着的生命周围有0个活着生命对象，下一代该生命死去
		Point p0 = new Point(1, 1, 1);
		assertEquals(0, pg.validateFewerThanTwoLive(p0, initalArray));

		// 活着的生命周围有1个活着生命对象，下一代该生命死去
		Point p1 = new Point(1, 6, 1);
		assertEquals(0, pg.validateFewerThanTwoLive(p1, initalArray));

		// 活着的生命周围有2个活着生命对象，下一代该生命还活着
		Point p2 = new Point(1, 4, 1);
		assertEquals(1, pg.validateFewerThanTwoLive(p2, initalArray));
	}


	/*
	** @author : Wang Huiyuan : 1492174
	** 
	** @description : Any live cell with two live neighbours lives 
	** on to the next generation
	** p3 stands for a live cell with two live neighbours
	** p7 stands for a dead cell with two live neighbours
	** Both of them are defined and initialized at the beginning of PlayGameTest definition 
	*/
	@Test
	public void testValidateEqualsTwoLives() {
		// A live cell with two live neighbours lives on to next generation
		org.junit.Assert
				.assertEquals("A live cell with two live neighbours lives on to next generation",
						1, pg.validateEqualsTwoLives(p3, strArr));
		// A dead cell should still be dead in next generation
		org.junit.Assert
				.assertFalse("Dead cell with two live neighbours should be dead in next generation", 
						1 == pg.validateEqualsTwoLives(p7, strArr));  
	}


	@Test
	public void testValidateEqualsThreeDead() {
		org.junit.Assert
				.assertEquals(0, pg.validateEqualsThreeDead(p5, strArr));
	}

	@Test
	public void testValidateNotEqualsThreeDead() {
		org.junit.Assert.assertEquals(1,
				pg.validateNotEqualsThreeDead(p1, strArr));
	}
	/* 
	 * @author: Tingxun Shi (1492124)
	 *
	 * @description: generate the next global status, using a complex example
	 */
	@Test
	public void nextStatusTest() {
		String[][] initialArray = new String[][] {
				{ ".", ".", ".", ".", ".", ".", ".", "." },
				{ ".", "*", "*", "*", "*", "*", "*", "." },
				{ ".", ".", ".", ".", ".", "*", "*", "." },
				{ ".", ".", ".", ".", ".", ".", ".", "." } };
		for (int i = 1; i <= 5; i++) {
			Point p = new Point(1, i, 1);
			if (i == 1 || i == 4) {
				assertEquals(0, pg.nextStatus(p, initialArray));
			} else {
				assertEquals(1, pg.nextStatus(p, initialArray));
			}
		}
		Point p1 = new Point(2, 2, 0);
		assertEquals(1, pg.nextStatus(p1, initialArray));

		Point p2 = new Point(2, 4, 1);
		assertEquals(0, pg.nextStatus(p2, initialArray));

		Point p3 = new Point(2, 5, 1);
		assertEquals(1, pg.nextStatus(p3, initialArray));
	}
/* 
	 * @author: Hao Li
	 *
	 * @description: given an alive cell surrounded by three alive cells,
	 * it should still live
	 */
	@Test
	public void testValidateEqualsThreeLive() {
		String[][] initialArray = new String[][] {
				{ ".", ".", ".", ".", ".", ".", ".", "." },
				{ ".", "*", "*", "*", ".", ".", "*", "." },
				{ ".", ".", ".", "*", "*", ".", "*", "." },
				{ ".", ".", ".", ".", ".", ".", ".", "." } };
		Point p = new Point(1, 3, 1);
		org.junit.Assert
				.assertEquals(1, pg.validateEqualsThreeLive(p, initialArray));
	}

}
