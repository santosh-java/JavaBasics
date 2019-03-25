/**
 * 
 */
package com.oracle.websockets.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.Session;

/**
 * @author smarthi
 *
 */
public class ScrambleWordHelper {
	private Map<String, List<String>> wordToScrambledMap = new HashMap<String, List<String>>();
	private Map<String, Map<String, String>> sessionToWordMap = new HashMap<String, Map<String, String>>();

	private String[] animals;
	private Logger logger = Logger.getLogger(this.getClass().getName());;

	public void initMap() {
		this.animals = new String[] { "rhino", "tiger", "buffalo" };

		this.wordToScrambledMap.put("rhino", Arrays.asList(new String[] { "rohin", "norhi", "rohin", "inhro" }));
		this.wordToScrambledMap.put("tiger", Arrays.asList(new String[] { "regit", "igetr", "trige", "grite" }));
		this.wordToScrambledMap.put("buffalo",
				Arrays.asList(new String[] { "fbuloaf", "fulfoab", "aolfbuf", "ffuolab" }));
	}

	public String getScrambleWord(Session session) {
		int animalToChoose = (int) (Math.random() * 3);
		int scrambleToChoose = (int) (Math.random() * 4);

		Map<String, String> sessionWord = sessionToWordMap.get(session.getId());
		String question = wordToScrambledMap.get(animals[animalToChoose]).get(scrambleToChoose);
		if (sessionWord == null) {
			sessionWord = new HashMap<String, String>();
		}
		sessionWord.put(animals[animalToChoose], question);
		sessionToWordMap.put(session.getId(), sessionWord);
		return question;
	}

	public void checkIfAnsweredCorrectly(Session session, String message) {
		Map<String, String> sessionWord = sessionToWordMap.get(session.getId());
		String question = sessionWord.get(message);
		if (question != null) {
			sendText(session, "Excellent!!! you have gussed it right... Next question:: " + getScrambleWord(session));
		} else {
			sendText(session, "You are mistaken!!! Try once more to guess the animal correctly:: ");
		}
	}

	public void sendText(Session session, String message) {
		try {
			session.getBasicRemote().sendText(message);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Exception occurred while sending text to client..." + e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
}