package impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import config.Config;
import dao.CartDAO;
import dao.ProductDAO;
import model.Cart;
import model.Category;

public class CartDAOImpl implements CartDAO{

	public void insert(Cart c) {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		s.save(c);
		
		t.commit();
		s.close();
		

		
	}
	
	public void update(String email, String shipTo, String billTo) {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		s.createQuery("update Cart set shippingAddress = :shippingAddress,billingAddress = :billingAddress where email=:email").setString("email", email).setString("shippingAddress", shipTo).setString("billingAddress", billTo).executeUpdate();
		
		s.close();
	}

	
	public String[] getShippingAddBillingAddress(String email) {
		
		String[] retArr = new String[2];
		Session s = Config.sessionFactory.openSession();
		for(Cart k : (List<Cart>)s.createQuery("from Cart where email=:email").setString("email", email).getResultList()) {
			
			retArr[0] = k.getShippingAddress();
			retArr[1] = k.getBillingAddress();
			
		}
		s.close();
		return retArr;
	}

	public List<Cart> getCart(String email) {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		ProductDAO pdao = new ProductDAOImpl();
		
		List<Cart> k = s.createQuery("from Cart where email=:email").setString("email", email).getResultList();
		
		for(Cart c : k) c.setProduct( pdao.getProduct(c.getProductId()) );

		s.close();
		
		return k;
		
	}

	public void deleteAllItemsByEmail(String email) {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		s.createQuery("delete from Cart where email=:email").executeUpdate();
		
		t.commit();
		s.close();
		
	}

	public void delete(int id) {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		s.createQuery("delete from Cart where id=:id").setInteger("id", id).executeUpdate();
		
		t.commit();
		s.close();
		
	}

	public void delete(String email) {
		Session s = Config.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		
		s.createQuery("delete from Cart where email=:email").setString("email", email).executeUpdate();
		
		t.commit();
		s.close();
	}

	public Cart getCart(String email, int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
