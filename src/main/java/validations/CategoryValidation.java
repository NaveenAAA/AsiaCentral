package validations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Category;
import model.User;

public class CategoryValidation {

	private Category c = null;
	private Map<String, List<String>> errorMap = new HashMap<String, List<String>>();

	public CategoryValidation(Category c) {
		super();
		this.c = c;
	}

	private void addEntryToMap(String key, String errorMsg) {

		if (this.errorMap.get(key) == null) {
			List<String> list = new ArrayList<String>();

			list.add(errorMsg);

			this.errorMap.put(key, list);
		} else {

			List<String> list = this.errorMap.get(key);

			list.add(errorMsg);

			this.errorMap.put(key, list);
		}

	}

	
	
	private void checkCategoryname() {

		Pattern p = Pattern.compile("^.+$");

		Matcher m = p.matcher(c.getName());

		if (!m.matches()) {

			this.addEntryToMap("name", "Cannot be Empty");
			}
		
			
		}
	
	private void checkCategoryDescription() {

		Pattern p = Pattern.compile("^.+$");

		Matcher m = p.matcher(c.getDescription());

		if (!m.matches()) {

			this.addEntryToMap("description", "Cannot be Empty");
			}
		
			
		}
				
		 
	public Map<String, List<String>> getErrorMap() {
		
		checkCategoryname();
		checkCategoryDescription();

		return this.errorMap;
	}

	

}

