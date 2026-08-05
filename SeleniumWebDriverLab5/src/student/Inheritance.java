package student;

import java.util.ArrayList;

class Appliance{
	int turnOn(int a) {
		System.out.println("appliance");
		return a;
	}
}

class Toaster extends Appliance{
	short turnOn(short a) {
		System.out.println("toaster");
		return a;
	}
		void turnOff(short b) {
	    System.out.println("turn off");		
		}
}

class C extends Toaster{
	
}

class Test{
	void give(Appliance a) {
		a.turnOn(2);
	}
}
public class Inheritance {

	public static void main(String[] args) {
		/*Test t=new Test();
		Appliance b=new Appliance();
		Appliance a= new Toaster();
		a.turnOn(2);
		//a.turnOff();
		//a.turnOn(5);
		Toaster toa=(Toaster)a;
		toa.turnOn(22);
		toa.turnOff();
		t.give(toa);
		t.give(a);
		t.give(b);
		//a.turnOn();*/
		
		
		Toaster t=new C();
		t.turnOff((short)21);
		t.turnOn((short)1);
		
		C b=new C();
		b.turnOff((short)22);
		ArrayList<Appliance> a=new ArrayList<Appliance>();
		Toaster t1=new Toaster();
		a.add(t1);
		Appliance t2=a.get(0);
		
	// TODO Auto-generated method stub

	}

}
