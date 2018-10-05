package com.tw.businesshousegame.service.impl;

import com.tw.businesshousegame.constant.TransactionType;
import com.tw.businesshousegame.service.TransactionService;
import com.tw.businesshousegame.vo.Bank;
import com.tw.businesshousegame.vo.Player;

public class TransactionServiceImpl implements TransactionService {

	@Override
	public void transfer(Bank bank, Player player, int amount, TransactionType transactionType) {
		switch (transactionType) {
		case DEBIT:
			bank.setBalance(bank.getBalance() + amount);
			player.setBalance(player.getBalance() - amount);
			break;
		case CREDIT:
			bank.setBalance(bank.getBalance() - amount);
			player.setBalance(player.getBalance() + amount);
			break;
		default:
			throw new IllegalArgumentException();

		}
	}

	@Override
	public void transfer(Player bank, Player player, int amount, TransactionType transactionType) {
		switch (transactionType) {
		case DEBIT:
			bank.setBalance(bank.getBalance() + amount);
			player.setBalance(player.getBalance() - amount);
			break;
		case CREDIT:
			bank.setBalance(bank.getBalance() - amount);
			player.setBalance(player.getBalance() + amount);
			break;
		default:
			throw new IllegalArgumentException();

		}
		
	}
}
