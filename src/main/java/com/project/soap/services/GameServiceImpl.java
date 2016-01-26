package com.project.soap.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
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
		
		if(name.equals(GameConstants.ELDER_SCROLLS)){
			type = GameConstants.RPG;
		}else if(name.equals(GameConstants.RIFT)){
			type = GameConstants.MMO;
		}else if(name.equals(GameConstants.WITCHER)){
			type = GameConstants.RPG;
		}else if(name.equals(GameConstants.FF_7)){
			type = GameConstants.RPG;
		}else if(name.equals(GameConstants.WOW)){
			type = GameConstants.MMO;
		}
		return type;
	}

}
