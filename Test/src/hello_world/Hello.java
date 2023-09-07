package hello_world;

public class Hello {

	public static void main(String[] args) {
		System.out.println("Hello World!!");
		System.out.println("<------------------>");
		System.out.println("Esto es una suma");
		
		int num1 = 5;
		int num2 = 10;

		int result = sum(num1, num2);
		System.out.println("The sum of " + num1 + " and " + num2 + " is: " + result);
	}
	
	public static int sum(int a, int b) {
		return a + b;
	}
}
