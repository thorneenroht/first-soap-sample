package com.project.soap.services;

import java.util.ArrayList;
import java.util.List;

public class GameServiceImpl implements GameService{

	public List<String> getGameList() {
		List<String> games = new ArrayList<String>();
		games.add(GameConstants.ELDER_SCROLLS);
		games.add(GameConstants.RIFT);
		games.add(GameConstants.WITCHER);
		games.add(GameConstants.FF_7);
		games.add(GameConstants.WOW);
		
		return games;
	}

	public String getGameType(String name) {
		String type = null;
		
		if(name == GameConstants.ELDER_SCROLLS){
			type = GameConstants.RPG;
		}else if(name == GameConstants.RIFT){
			type = GameConstants.MMO;
		}else if(name == GameConstants.WITCHER){
			type = GameConstants.RPG;
		}else if(name == GameConstants.FF_7){
			type = GameConstants.RPG;
		}else if(name == GameConstants.WOW){
			type = GameConstants.MMO;
		}
		return type;
	}

}
