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

	@Test
	public void nextStatusTest() {
		org.junit.Assert.assertEquals(1, pg.nextStatus(p1, strArr));
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

	@Test
	public void testValidateEqualsThreeLive() {
		org.junit.Assert
				.assertEquals(1, pg.validateEqualsThreeLive(p1, strArr));
	}

	@Test
	public void testValidateEqualsTwoLive() {
		org.junit.Assert.assertEquals(1, pg.validateEqualsTwoLive(p6, strArr));
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

}
