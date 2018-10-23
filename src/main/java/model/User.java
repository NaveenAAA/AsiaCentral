package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String password;
	private String Cpassword;
	private String email;
	private String phone;
    private String role = "ROLE_USER";
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return Cpassword;
	}
	public void setCpassword(String cpassword) {
		Cpassword = cpassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public User() {}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", Cpassword=" + Cpassword + ", email="
				+ email + ", phone=" + phone + ", role=" + role + "]";
	}
	
	
	
	
	
	
	

}
