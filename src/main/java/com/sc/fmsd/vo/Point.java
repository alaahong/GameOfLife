package com.sc.fmsd.vo;

public class Point {
	int x;
	int y;
	int status;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Point(int x, int y, int status) {
		super();
		this.x = x;
		this.y = y;
		this.status = status;
	}

}
