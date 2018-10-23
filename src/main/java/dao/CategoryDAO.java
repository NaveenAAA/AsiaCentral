package dao;

import java.util.List;

import model.Category;

public interface CategoryDAO {

	void insert( Category c );
	void update( Category c );
	void delete( int cid );
	
	Category getCategory(int cid);
	List<Category> getCategory();
	
}
