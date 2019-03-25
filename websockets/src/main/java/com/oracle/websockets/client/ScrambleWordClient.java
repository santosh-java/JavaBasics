/**
 * 
 */
package com.oracle.websockets.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.glassfish.tyrus.client.ClientManager;

/**
 * @author smarthi
 *
 */
@ClientEndpoint
public class ScrambleWordClient {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private static CountDownLatch latch;

	@OnOpen
	public void onOpen(Session session) throws IOException {
		logger.info("Connected to Scramble game server... " + session.getId());
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		String userInput = bufferRead.readLine();
		session.getBasicRemote().sendText(userInput);
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		try {
			logger.info("Received::: " + message);
			String userInput = bufferRead.readLine();
			session.getBasicRemote().sendText(userInput);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		logger.info(String.format("Session %s close because of %s", session.getId(), closeReason));
		latch.countDown();
	}

	public static void main(String[] args) {
		latch = new CountDownLatch(1);

		ClientManager client = ClientManager.createClient();
		try {
			client.connectToServer(ScrambleWordClient.class, new URI("ws://localhost:8025/websockets/scrambleWord"));
			latch.await();

		} catch (DeploymentException | URISyntaxException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
