package com.tw.businesshousegame.constant;

public enum CellType {

	J("Jail"), H("Hotel"), L("Lottery"), E("Empty Cell");

	private String description;

	CellType(String desciption) {
		this.description = desciption;
	}

	public String getDescription() {
		return description;
	}
}
