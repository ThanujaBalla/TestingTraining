package student;

public class Studentinfo {
	public String name ="Thanu";
	private int rollno=21;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float e=10;
		Float b=Float.valueOf(e);
		int a=21;
		System.out.println(a++);
		System.out.println(a);
		
		Integer i=new Integer(21);
		System.out.println(i instanceof Integer);
		System.out.println(Float.SIZE+""+Float.MIN_VALUE);

	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

}
