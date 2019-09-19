package com.example.springData.POJO;

public class student {
	
	private String name;
	
	private int id;

	public String getName() {
		return name;
	}

	public student(String name, int id){
		this.id = id;
		this.name = name;

	}
	public student(){
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
}
