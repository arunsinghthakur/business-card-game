package com.tw.businesshousegame.service;

import com.tw.businesshousegame.constant.TransactionType;
import com.tw.businesshousegame.vo.Bank;
import com.tw.businesshousegame.vo.Player;

public interface TransactionService {
	void transfer(final Bank bank, final Player player, final int amount, final TransactionType transactionType);
	void transfer(final Player bank, final Player player, final int amount, final TransactionType transactionType);
}
