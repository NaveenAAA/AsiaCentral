package impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import config.Config;
import dao.CategoryDAO;
import model.Category;

public class CategoryDAOImpl implements CategoryDAO {

	public void insert(Category c) {
		
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		s.save(c);
		
		t.commit();
		s.close();
		
	}

	public void update(Category c) {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		s.update(c);
		
		t.commit();
		s.close();
	}

	public void delete(int cid) {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		s.createQuery("delete from Category where id=:id").setInteger("id", cid).executeUpdate();
		
		t.commit();
		s.close();
	}

	public Category getCategory(int cid) {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		Category c = (Category)s.createQuery("from Category where id=:id").setInteger("id", cid).getSingleResult();
		
		t.commit();
		s.close();
		
		return c;
	}

	public List<Category> getCategory() {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		List<Category> c = s.createQuery("from Category").getResultList();
		
		t.commit();
		s.close();
		
		return c;
	}	
	
}
