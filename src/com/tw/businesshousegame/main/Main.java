package com.tw.businesshousegame.main;

import com.tw.businesshousegame.constant.CellType;
import com.tw.businesshousegame.constant.Constants;
import com.tw.businesshousegame.service.PlayService;
import com.tw.businesshousegame.service.impl.PlayServiceImpl;
import com.tw.businesshousegame.vo.Bank;
import com.tw.businesshousegame.vo.Cell;
import com.tw.businesshousegame.vo.Hotel;
import com.tw.businesshousegame.vo.Jail;
import com.tw.businesshousegame.vo.Lottery;
import com.tw.businesshousegame.vo.Player;

public class Main {

	public static void main(String[] args) {
		String inputCells = "J,H,L,E";
		String diceInput = "1,2,3,4";
		int player = 2;
		int moves = 2;
		PlayService playService = new PlayServiceImpl();
		Bank bank = new Bank(Constants.BANK_INITITIAL_CAPACITY);
		Player[] players = new Player[player];

		String[] cellArray = inputCells.split(",");
		Cell[] cells = new Cell[cellArray.length];
		for (int i = 0; i < cellArray.length; i++) {
			if (cellArray[i].equals(CellType.J)) {
				cells[i] = new Jail();
			} else if (cellArray[i].equals(CellType.H)) {
				cells[i] = new Hotel();
			} else if (cellArray[i].equals(CellType.L)) {
				cells[i] = new Lottery();
			}
		}
		for (int i = 0; i < player; i++) {
			players[i] = new Player(Constants.PLAYER_INITITIAL_CAPACITY);
		}

		for (int i = 0; i < moves; i++) {
			for (int j = 0; j < player; i++) {
				playService.play(bank, cells, players[j]);
			}

		}

	}

}
