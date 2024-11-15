package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="oaklandSystem")
public class EmployeeEntity {
	
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
	
	    private String name;
	    private Date dob;
	    private String gender;
	    private String address;
	    private String city;
	    private String state;
	    private String loginId;
	    private String password;
	    
	    
		public EmployeeEntity() {
			super();
			// TODO Auto-generated constructor stub
		}


		public EmployeeEntity(Long id, String name, Date dob, String gender, String address, String city, String state,
				String loginId, String password) {
			super();
			this.id = id;
			this.name = name;
			this.dob = dob;
			this.gender = gender;
			this.address = address;
			this.city = city;
			this.state = state;
			this.loginId = loginId;
			this.password = password;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public Date getDob() {
			return dob;
		}


		public void setDob(Date dob) {
			this.dob = dob;
		}


		public String getGender() {
			return gender;
		}


		public void setGender(String gender) {
			this.gender = gender;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getState() {
			return state;
		}


		public void setState(String state) {
			this.state = state;
		}


		public String getLoginId() {
			return loginId;
		}


		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		@Override
		public String toString() {
			return "EmployeeEntity [id=" + id + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", address="
					+ address + ", city=" + city + ", state=" + state + ", loginId=" + loginId + ", password="
					+ password + "]";
		}

	
		
		

}
