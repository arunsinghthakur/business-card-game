package com.tw.businesshousegame.service.impl;

import java.util.Random;

import com.tw.businesshousegame.constant.Constants;
import com.tw.businesshousegame.constant.HotelType;
import com.tw.businesshousegame.constant.TransactionType;
import com.tw.businesshousegame.service.PlayService;
import com.tw.businesshousegame.service.TransactionService;
import com.tw.businesshousegame.vo.Bank;
import com.tw.businesshousegame.vo.Cell;
import com.tw.businesshousegame.vo.Hotel;
import com.tw.businesshousegame.vo.Player;

public class PlayServiceImpl implements PlayService {
	private static final TransactionService TRANSACTION_SERVICE = new TransactionServiceImpl();

	@Override
	public void play(Bank bank, Cell[] cells, Player player) {
		Random random = new Random(10);
		int diceOutput = random.nextInt();

		move(bank, player, cells, diceOutput);
	}

	@Override
	public void move(Bank bank, Player player, Cell[] cells, int diceOutput) {
		int nextCellPosition = cells.length % player.getCurrentCellIndex() + diceOutput;

		Cell nextCell = cells[nextCellPosition];
		player.setCurrentCellIndex(nextCellPosition);

		switch (nextCell.getCellType()) {
		case J:
			TRANSACTION_SERVICE.transfer(bank, player, Constants.JAIL_COST, TransactionType.DEBIT);
			break;
		case L:
			TRANSACTION_SERVICE.transfer(bank, player, Constants.LOTTERY_COST, TransactionType.CREDIT);
			break;
		case H:
			handleHotelMove(bank, player, (Hotel) nextCell);
			break;
		case E:
			// Do nothing
			break;
		default:
			break;
		}
	}

	private void handleHotelMove(Bank bank, Player player, Hotel cell) {
		if (cell.isFree()) {
			// Free hotel logic
			handleFreeHotelMove(bank, player, cell);
		} else {
			if (cell.getPlayer().getId().equals(player.getId())) {
				// Upgrade logic
				handleHotelUpgradeMove(bank, player, cell);
			} else {
				// Rent logic
				handleHotelRentMove(player, cell);
			}
		}
	}

	private void handleHotelUpgradeMove(Bank bank, Player player, Hotel cell) {
		if (cell.getHotelType() == HotelType.SILVER && player.getBalance() >= (Constants.HOTEL_GOLD_TYPE_COST - Constants.HOTEL_SILVER_TYPE_COST)) {
			cell.setHotelType(HotelType.GOLD);
			TRANSACTION_SERVICE.transfer(bank, player, Constants.HOTEL_GOLD_TYPE_COST - Constants.HOTEL_SILVER_TYPE_COST, TransactionType.DEBIT);
		} else if (cell.getHotelType() == HotelType.GOLD
				&& player.getBalance() >= (Constants.HOTEL_PLATINUM_TYPE_COST - Constants.HOTEL_GOLD_TYPE_COST)) {
			cell.setHotelType(HotelType.GOLD);
			TRANSACTION_SERVICE.transfer(bank, player, Constants.HOTEL_PLATINUM_TYPE_COST - Constants.HOTEL_GOLD_TYPE_COST, TransactionType.DEBIT);
		}
	}

	private void handleHotelRentMove(Player player, Hotel cell) {
		switch (cell.getHotelType()) {
		case SILVER: {
			TRANSACTION_SERVICE.transfer(cell.getPlayer(), player, Constants.HOTEL_SILVER_TYPE_RENT, TransactionType.DEBIT);
		}
		case GOLD: {
			TRANSACTION_SERVICE.transfer(cell.getPlayer(), player, Constants.HOTEL_GOLD_TYPE_RENT, TransactionType.DEBIT);
		}
		case PLATINUM: {
			TRANSACTION_SERVICE.transfer(cell.getPlayer(), player, Constants.HOTEL_PLATINUM_TYPE_RENT, TransactionType.DEBIT);
		}

		}
	}

	private void handleFreeHotelMove(Bank bank, Player player, Hotel cell) {
		if (player.getBalance() >= Constants.HOTEL_SILVER_TYPE_COST) {
			cell.setHotelType(HotelType.SILVER);
			cell.setPlayer(player);
			cell.setFree(false);
			TRANSACTION_SERVICE.transfer(bank, player, Constants.HOTEL_SILVER_TYPE_COST, TransactionType.DEBIT);
		}
	}
}
