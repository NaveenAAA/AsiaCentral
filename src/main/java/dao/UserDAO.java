package dao;

import java.util.List;

import model.User;

public interface UserDAO {
	
	void insert (User u);
	void update (User u);
	void delete (int id);
	
	User getUser(int id);
	User getUser(String name, String password);
	List <User> getUser();
	
	}
