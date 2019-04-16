package com.practice.rest.messenger;

import java.util.HashMap;
import java.util.Map;

import com.practice.rest.messenger.model.Message;
import com.practice.rest.messenger.model.Profile;

public class DataSourceManager {
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

}
