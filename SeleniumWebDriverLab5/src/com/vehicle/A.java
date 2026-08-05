package com.vehicle;

class C {

	public C() {System.out.println("aaa");}
	public C(int a) { System.out.println("a");}
}

 class B extends C{
	public B() {
	super();
	System.out.println("b");
	}
}
 
public class A{
	public static void main(String[] args) {
		B b=new B();
	}
	
}

