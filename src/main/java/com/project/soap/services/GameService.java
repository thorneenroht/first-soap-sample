package com.project.soap.services;

import java.util.List;

public interface GameService {

	public List<String> getGameList();

	public String getGameType(String name);
}
