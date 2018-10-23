package validations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.User;

public class UserValidations {

	private User u = null;
	private Map<String, List<String>> errorMap = new HashMap<String, List<String>>();

	public UserValidations(User u) {
		super();
		this.u = u;
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

	private void checkPhone() {

		Pattern p = Pattern.compile("^[6-9][0-9]{9}$");

		Matcher m = p.matcher(u.getPhone());

		if (!m.matches()) {

			this.addEntryToMap("phone", "Not a valid Indian Mobile Phone Number");
			
		}
		
		p = Pattern.compile("^.+$");

		m = p.matcher(u.getPhone());

		if (!m.matches()) {

			this.addEntryToMap("phone", "Phone Number Cannot Be Empty");
			
		}
		
		
	}
	
	private void checkUsername() {

		Pattern p = Pattern.compile("^.+$");

		Matcher m = p.matcher(u.getName());

		if (!m.matches()) {

			this.addEntryToMap("name", "Name Cannot Be Empty");
			}
			
		}
		
		private void checkUserpassword() {

			Pattern p = Pattern.compile("^.+$");

			Matcher m = p.matcher(u.getPassword());

			if (!m.matches()) {

				this.addEntryToMap("password", "Password Cannot Be Empty");
				
			}		
			p = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}");

			m = p.matcher(u.getPassword());

			if (!m.matches()) {

				this.addEntryToMap("password", "Password must have a upper case alphabet, a lower case alphabet and a alphanumeric character");
			
	}
		}

		private void checkUseremail() {

			Pattern p = Pattern.compile("^.+$");

			Matcher m = p.matcher(u.getEmail());

			if (!m.matches()) {

				this.addEntryToMap("email", "Email Cannot Be Empty");
				
			}	
			
			
			p = Pattern.compile("^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+){1,2}$");
			

			m = p.matcher(u.getEmail());

			if (!m.matches()) {

				this.addEntryToMap("email", "Email must be a valid email");
			
	}
		
		
}

		private void checkMatchpassword(String Password,String Cpassword) {

			 if( !Password.equals(Cpassword) )

			 {

				this.addEntryToMap("cpassword", "Passwords do not match");
				
			}	
		}
				
		 
	public Map<String, List<String>> getErrorMap() {
		
		checkUsername();
		checkPhone();
		checkUserpassword();
		checkUseremail();
		checkMatchpassword(u.getPassword(),u.getCpassword());
		return this.errorMap;
	}

	

}
