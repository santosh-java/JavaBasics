package com.practice.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.practice.rest.messenger.DataSourceManager;
import com.practice.rest.messenger.model.Comment;
import com.practice.rest.messenger.model.Message;

public class CommentService {
	private Map<Long, Message> messages = DataSourceManager.getMessages();

	public List<Comment> getAllCommens(long messageId) {
		Message message = messages.get(messageId);
		return new ArrayList<>(message.getComments().values());
	}

	public Comment getComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}

	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() < 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment deleteComment(long messageId, long commentId) {
		return messages.get(messageId).getComments().remove(commentId);
	}
}
