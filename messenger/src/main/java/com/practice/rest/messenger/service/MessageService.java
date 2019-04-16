package com.practice.rest.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.practice.rest.messenger.DataSourceManager;
import com.practice.rest.messenger.model.Message;

public class MessageService {
	Map<Long, Message> messages = DataSourceManager.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "msgg", "test message 1"));
		messages.put(2L, new Message(2, "giri", "test message 2"));
		messages.put(3L, new Message(3, "vijaya", "test message 3"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesOfYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for (Message m : messages.values()) {
			cal.setTime(m.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesOfYear.add(m);
			}
		}
		return messagesOfYear;
	}

	public List<Message> getAllMessagesPaginated(int start, int size) {
		List<Message> list = new ArrayList<Message>(messages.values());
		if (list.size() < start + size)
			return new ArrayList<Message>();
		return list.subList(start, start + size);
	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		if (message != null) {
			message.setId(messages.size() + 1);
			messages.put(message.getId(), message);
			return message;
		}
		return null;
	}

	public Message updateMessage(Message message) {
		if (message == null || message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message deleteMessage(long id) {
		return messages.remove(id);
	}
}
