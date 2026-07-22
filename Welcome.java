import java.util.Scanner;

public class Welcome {
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.println("_".repeat(40));
		System.out.print(" ".repeat(15));
		System.out.println("QUESTION 1");
		System.out.println("_".repeat(40));

		System.out.print("Enter your First Name: ");
		String nameF = input.next();
		System.out.print("Enter your Last Name: ");
		String nameL = input.next();

		System.out.println("_".repeat(40));
		System.out.printf("\nWelcome to Second Year, %s %s!\n", nameF, nameL);
		System.out.println("_".repeat(40));
	}
}
