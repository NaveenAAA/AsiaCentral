package validations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Cart;


public class CartValidation {

	private Cart k = null;
	private Map<String, List<String>> errorMap = new HashMap<String, List<String>>();

	public CartValidation(Cart k) {
		super();
		this.k = k;
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
	private void checkCartqty() {

		Pattern p = Pattern.compile("^.+$");

		Matcher m = p.matcher(k.getQty()+"");

		if (!m.matches()) {

			this.addEntryToMap("qty", "Cannot be Empty");
			}
		
			
		}
	
	private void checkCartemail() {

		Pattern p = Pattern.compile("^.+$");

		Matcher m = p.matcher(k.getEmail());

		if (!m.matches()) {

			this.addEntryToMap("email", "Email Cannot Be Empty");
			
		}	
		
		
		p = Pattern.compile("^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+){1,2}$");
		

		m = p.matcher(k.getEmail());

		if (!m.matches()) {

			this.addEntryToMap("email", "Email must be a valid email");
		
}
	
	
}
				
		 
	public Map<String, List<String>> getErrorMap() {
		
		checkCartqty();
		checkCartemail();

		return this.errorMap;
	}

	

}

