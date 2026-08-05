package student;
public class Static2 {
	int age;
	String name;
	Static2(){
		System.out.println("default");
	}
	Static2(int i){
		System.out.println(i);
	}
	Static2(int i, String n){
		this.age=i;
		this.name=n;
		System.out.println(age+name);
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Static2 s1=new Static2();
		Static2 s2=new Static2(45);
		Static2 s3 = new Static2(21,"thanu");
		
		
	}

}
