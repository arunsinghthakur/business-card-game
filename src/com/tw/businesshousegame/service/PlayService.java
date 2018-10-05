package com.tw.businesshousegame.service;

import com.tw.businesshousegame.vo.Bank;
import com.tw.businesshousegame.vo.Cell;
import com.tw.businesshousegame.vo.Player;

public interface PlayService {
	void play(Bank banks, Cell[] cells, Player player);

	void move(Bank bank, Player player, Cell[] cells, int diceOutput);
}
