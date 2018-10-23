package dao;

import java.util.List;

import model.Product;

public interface ProductDAO {
	void insert(Product p);
	void update(Product p);
	void delete(int pid);
	void deleteCatProducts(int category_id);
	
	Product getProduct(int pid);
	List<Product> getProductCat(int category_id);
	List<Product> getProduct();

}
