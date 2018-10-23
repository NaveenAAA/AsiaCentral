package dao;

import java.util.List;

import model.Cart;

public interface CartDAO {
	
	void insert (Cart k);
	
	void update (String email, String shipTo , String billTo );
	
	String[] getShippingAddBillingAddress (String email);
	
	List<Cart> getCart(String email);
	
	void deleteAllItemsByEmail(String email);
	
	void delete(int id);
	void delete(String email);

	Cart getCart(String email , int productId);
}
