package com.tw.businesshousegame.vo;

import com.tw.businesshousegame.constant.HotelType;

public class Hotel extends Cell {
	private HotelType hotelType;
	private boolean isFree;
	private Player player;

	public HotelType getHotelType() {
		return hotelType;
	}

	public void setHotelType(HotelType hotelType) {
		this.hotelType = hotelType;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
