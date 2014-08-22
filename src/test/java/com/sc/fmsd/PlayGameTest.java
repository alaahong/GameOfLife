package com.sc.fmsd;

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

	@Test
	public void testValidateFewerThanTwoLive() {
		org.junit.Assert.assertEquals(0,
				pg.validateFewerThanTwoLive(p5, strArr));
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
