package impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import config.Config;

import dao.ProductDAO;

import model.Product;

public class ProductDAOImpl implements ProductDAO{
public void insert(Product p) {
		
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		s.save(p);
		
		t.commit();
		s.close();
		
	}

	public void update(Product p) {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		s.update(p);
		
		t.commit();
		s.close();
	}

	public void delete(int pid) {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		s.createQuery("delete from Product where id=:id").setInteger("id", pid).executeUpdate();
		
		t.commit();
		s.close();
	}

	public Product getProduct(int pid) {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		Product p = (Product)s.createQuery("from Product where id=:id").setInteger("id", pid).getSingleResult();
		
		t.commit();
		s.close();
		
		return p;
	}

	public List<Product> getProduct() {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		List<Product> p = s.createQuery("from Product").getResultList();
		
		t.commit();
		s.close();
		
		
		return p;
	}

	public List<Product> getProductCat(int category_id) {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();

		List<Product> p = s.createQuery("from Product where category_id=:category_id").setInteger("category_id", category_id).getResultList();

		t.commit();
		s.close();
		
		return p;
	}

	public void deleteCatProducts(int category_id) {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		s.createQuery("delete from Product where category_id=:category_id").setInteger("category_id", category_id).executeUpdate();
		
		t.commit();
		s.close();
		
		
		
		
	}

		
	

}
