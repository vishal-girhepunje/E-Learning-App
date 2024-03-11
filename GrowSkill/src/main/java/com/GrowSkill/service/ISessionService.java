package com.GrowSkill.service;

import com.GrowSkill.model.Session;

public interface ISessionService {
	public Session createSession(Session session);

	public Session getSessionById(Long sessionId);

	public void deleteSessionById(Long sessionId);
}
