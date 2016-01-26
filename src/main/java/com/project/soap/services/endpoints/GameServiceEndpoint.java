package com.project.soap.services.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.project.soap.services.GameService;
import com.project.soap.webservices.gameservice.GetGamesListRequest;
import com.project.soap.webservices.gameservice.GetGamesListResponse;
import com.project.soap.webservices.gameservice.GetGamesTypeRequest;
import com.project.soap.webservices.gameservice.GetGamesTypeResponse;


@Endpoint
public class GameServiceEndpoint {

	private static final String TARGET_NAMESPACE = "http://com/project/soap/webservices/gameservice";

	@Autowired
	private GameService gameService;

	/**
	 * Gets the account details.
	 *
	 * @param accountNumber
	 *            the account number
	 * @return the account details
	 */
	@PayloadRoot(localPart = "GetGameListRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload GetGamesListResponse getGames(@RequestPayload GetGamesListRequest request) {
		GetGamesListResponse response = new GetGamesListResponse();

		/*
		 * call Spring injected service implementation to retrieve account data
		 */
		response.getGames().addAll(gameService.getGameList());

		return response;
	}

	@PayloadRoot(localPart = "Request", namespace = TARGET_NAMESPACE)
	public @ResponsePayload GetGamesTypeResponse getGameType(
			@RequestPayload GetGamesTypeRequest request) {
		GetGamesTypeResponse response = new GetGamesTypeResponse();

		/*
		 * call Spring injected service implementation to retrieve account data
		 */
		response.setType(gameService.getGameType(request.getGame()));

		return response;
	}

	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}
}
