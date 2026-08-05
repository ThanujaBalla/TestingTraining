package com.vehicle;

import student.Studentinfo;

public class Car {
	public String color ="black";
	public String model = "Skoda";
	void start() {
		System.out.println("I am riding a car");
		
	}

	public static void main(String[] args) {
		int i=10;
		for(;i<12;i++) 
			System.out.println(i==10); System.out.println("hi");
		
		Car sk = new Car();
		System.out.println("I have a "+sk.color+"coloured "+sk.model+"Car");
		Studentinfo n=new Studentinfo();
		System.out.println(n.name+n.getRollno());
		
	}

}
