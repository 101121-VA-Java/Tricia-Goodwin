package com.revature;

import java.util.Scanner;

public class ScannerDriver{


	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		menu();
		int num = sc.nextInt();
		sc.nextLine();
		System.out.println("You chose: "+num);
		
		while(num != 3) {
			
			switch (num) {
				case 1: 

					long rn = Math.round( Math.random()*100 );
					System.out.println("Here's a random number: "+ rn);
					menu();
					num = sc.nextInt();
					sc.nextLine();
					System.out.println("You chose: "+num);
					break;
					
				case 2: 
					System.out.println("Write word you wish to be reversed: ");
					String wrd = sc.nextLine();
					StringBuilder rword = new StringBuilder(wrd);
					System.out.println(rword.reverse());
					menu();
					num = sc.nextInt();
					sc.nextLine();
					System.out.println("You chose: "+num);
					break;
					
				default: System.out.println("Invalid input");
					menu();
					num = sc.nextInt();
					sc.nextLine();
					System.out.println("You chose: "+num);
					break;
			}
		
		}
		System.out.println("Good-bye!");
		
		
		
		
		sc.close();

	}

	public static void menu() {
		System.out.println("Please Select an Option from the Menu below:");
		System.out.println("1 - Get a random number");
		System.out.println("2 - Reverse a Word");
		System.out.println("3 - Exit this program");
	
		
	}
}


