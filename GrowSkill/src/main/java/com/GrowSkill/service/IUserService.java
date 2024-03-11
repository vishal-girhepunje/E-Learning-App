package com.GrowSkill.service;

import com.GrowSkill.api.request.UserCreationRequest;
import com.GrowSkill.model.User;

public interface IUserService {
	public void addUser(UserCreationRequest request);
	
	public void updateUser(String  uid);
	
	public void deleteUser(String uid);

	public void disableUser(String uid);
}
