package com.tw.businesshousegame.vo;

import com.tw.businesshousegame.constant.CellType;

public abstract class Cell {
	private CellType cellType;
	private int cost;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public CellType getCellType() {
		return cellType;
	}

	public void setCellType(CellType cellType) {
		this.cellType = cellType;
	}

}
