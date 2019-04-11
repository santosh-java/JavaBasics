package com.practice.rest.socialmessenger.database;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.practice.rest.socialmessenger.model.Message;
import com.practice.rest.socialmessenger.model.Profile;

public class DatabaseManager {
	private static Map<Long, Message> messages = new ConcurrentHashMap<>();
	private static Map<String, Profile> profiles = new ConcurrentHashMap<>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
