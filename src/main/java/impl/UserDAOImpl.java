package impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import model.User;
import dao.UserDAO;

import config.Config;


public class UserDAOImpl implements UserDAO {
	
	public User getUser(String name, String password) {
		try {

			Session s = Config.sessionFactory.openSession();
			Transaction t = s.beginTransaction();
			
			User u = (User)s.createQuery("from User where name=:name and password=:password").setString("name", name).setString("password", password).getSingleResult();
			
			t.commit();
			s.close();
			
			return u;
			
		}catch( Exception e ) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void insert(User u) {
		
	
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		s.save(u);
		
		t.commit();
		s.close();
	
		
	}

	public void update(User u) {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		s.update(u);
		
		t.commit();
		s.close();
		
}

	public void delete(int id) {
	
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
				
		s.createQuery("delete from User where id=:id").setInteger("id", id).executeUpdate();			
		
		t.commit();
		
		s.close();
		
	}

	public User getUser(int id) {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		User u = (User)s.createQuery("from User where id=:id").setInteger("id", id).getSingleResult();
		
		t.commit();
		s.close();
		
		return u;
	}

	public List<User> getUser() {
	
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		List<User> u = s.createQuery("from User").getResultList();
		
		t.commit();
		s.close();
		
		return u;
	}

}
