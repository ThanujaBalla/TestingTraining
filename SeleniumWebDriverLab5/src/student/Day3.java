package student;
class D3{
	int id;
	String name;
	static String company="Encora";
	D3(int i, String n){
	id=i;
	name=n;
	company="Microsoft";
	}
	void display() {
		System.out.println(id+name+company);
	}
}

public class Day3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D3 d1=new D3(123,"thanu");
		D3 d2=new D3(124,"nani");
		d1.display();
		d2.company="Google";
		d2.display();
		
	}

}
