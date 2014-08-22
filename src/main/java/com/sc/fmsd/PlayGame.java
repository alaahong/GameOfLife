package com.sc.fmsd;

import com.sc.fmsd.vo.Point;

public class PlayGame {

	/**
	 * @param args
	 */


	public String liveFlag = "*";

	public int liveStockNum(Point p, String[][] arr) {
		int liveNum = 0;
		for (int i = p.getX() - 1; i < p.getX() + 2; i++) {
			for (int j = p.getY() - 1; j < p.getY() + 2; j++) {
				if (i != p.getX() || j != p.getY()) {
					if (liveFlag.equals(arr[i][j])) {
						liveNum++;
					}
				}
			}
		}
		return liveNum;
	}
	public int nextStatus(Point p, String[][] arr){
		int result = 0;
		if(p.getStatus() == 0 ){
			result = validateNotEqualsThreeDead(p,arr);
		}else if(liveStockNum(p, arr) ==2){
			result = validateEqualsTwoLive(p,arr);
		}else if(liveStockNum(p, arr) ==3){
			result = validateEqualsThreeLive(p,arr);
		}else if(liveStockNum(p, arr) <2){
			result = validateFewerThanTwoLive(p,arr);
		}else if(liveStockNum(p, arr) >3){
			result = validateMoreThanThreeLive(p,arr);
		}
		return result;
	}
	public int validateFewerThanTwoLive(Point p, String[][] arr) {
		int result;
		if (p.getStatus() == 0) {
			result =validateNotEqualsThreeDead(p, arr);
		} else {
			result = liveStockNum(p, arr) < 2 ? 0 : 1;
		}
		return result;
	}

	public int validateMoreThanThreeLive(Point p, String[][] arr) {
		int result;
		if (p.getStatus()  == 0) {
			result = validateNotEqualsThreeDead(p, arr);
		} else {
			result = liveStockNum(p, arr) > 3 ? 0 : 1;
		}
		return result;
	}

	public int validateEqualsThreeLive(Point p, String[][] arr) {
		int result;
		if (p.getStatus()  == 0) {
			result = validateNotEqualsThreeDead(p, arr);
		} else {
			result = liveStockNum(p, arr) == 3 ? 0 : 1;
		}
		return result;
	}

	public int validateEqualsTwoLive(Point p, String[][] arr) {
		int result;
		if (p.getStatus() == 0) {
			result = validateEqualsThreeDead(p, arr);
		} else {
			result = liveStockNum(p, arr) == 2 ? 1 : 0;
		}
		return result;
	}

	public int validateEqualsThreeDead(Point p, String[][] arr) {
		int result = 0;
		if (p.getStatus() == 0) {
			result = validateNotEqualsThreeDead(p, arr);
		}
		return result;
	}

	public int validateNotEqualsThreeDead(Point p, String[][] arr) {
		int result =0;
		if(p.getStatus()==0 ){
			result = liveStockNum(p, arr) != 3 ? 0 : 1;
		}else if(liveStockNum(p, arr) ==2){
			result = validateEqualsTwoLive(p,arr);
		}else if(liveStockNum(p, arr) ==3){
			result = validateEqualsThreeLive(p,arr);
		}else if(liveStockNum(p, arr) <2){
			result = validateFewerThanTwoLive(p,arr);
		}else if(liveStockNum(p, arr) >3){
			result = validateMoreThanThreeLive(p,arr);
		}
		return result;
	}
}
