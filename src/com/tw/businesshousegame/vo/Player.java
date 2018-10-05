package com.tw.businesshousegame.vo;

public class Player {
	private String id;
	private int totalAsset;
	private int balance;
	private int currentCellIndex;

	public Player(int balance) {
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTotalAsset() {
		return totalAsset;
	}

	public void setTotalAsset(int totalAsset) {
		this.totalAsset = totalAsset;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getCurrentCellIndex() {
		return currentCellIndex;
	}

	public void setCurrentCellIndex(int currentCellIndex) {
		this.currentCellIndex = currentCellIndex;
	}

}
