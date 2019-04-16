package com.practice.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.practice.rest.messenger.DataSourceManager;
import com.practice.rest.messenger.model.Profile;

public class ProfileService {
	Map<String,Profile> profiles = DataSourceManager.getProfiles();
	
	public ProfileService() {
		profiles.put("msgg", new Profile(1,"msgg","Govind","MSG"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		if (profile != null && !profile.getProfileName().isEmpty()) {
			profile.setId(profiles.size() + 1);
			profiles.put(profile.getProfileName(), profile);
			return profile;
		}
		return null;
	}

	public Profile updateProfile(Profile profile) {
		if (profile == null || profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile deleteProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
