package com.yedam.java.pack;

public class PlayerRepo implements Access {

	private Player[] playerList;
	private int listIndex;

	private static PlayerRepo instance = new PlayerRepo();

	private PlayerRepo() {
		init();
	}

	public static PlayerRepo getInstance() {
		return instance;
	}

	private void init() {
		playerList = new Player[100];
		listIndex = -1;
	}

	@Override
	public void insert(Player player) {
		playerList[++listIndex] = player;
	}

	@Override
	public Player[] selectAll() {
		Player[] list = new Player[listIndex + 1];
		for (int i = 0; i <= listIndex; i++) {
			list[i] = playerList[i];
		}
		return list;
	}

	@Override
	public Player selectOne(String name) {
		Player selected = null;
		for (int i = 0; i <= listIndex; i++) {
			if (playerList[i].getName().equals(name)) {
				selected = playerList[i];
			}
		}
		return selected;
	}

	@Override
	public void update(Player player) {
		for (int i = 0; i <= listIndex; i++) {
			if (playerList[i].getName().equals(player.getName())) {
				playerList[i] = player;
			}
		}
	}

	@Override
	public void delete(String name) {
		for (int i = 0; i <= listIndex; i++) {
			if (playerList[i].getName().equals(name)) {
				playerList[i] = null;
			}
		}

		cleanData();
	}

	private void cleanData() {
		Player[] temp = playerList;

		init();

		for (int i = 0; i < temp.length; i++) {
			if (temp != null) {
				playerList[++listIndex] = temp[i];
			}
		}
	}

}
