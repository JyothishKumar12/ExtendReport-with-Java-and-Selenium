package Checking;

public class Base {

	int a ;
	
	
	public void test1() {
		System.out.println(a=19);
	}
	
	public void test2() {
		System.out.println(a);
	}
	
	
	public static void main(String ar[]) {
		Base b1 = new Base();
		b1.test1();
		b1.test2();
	}
}
