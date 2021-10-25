package com.revature.models;

import java.util.Scanner;

public class Driver {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		Plants a = new Cactus("Old Lady", "high");
		Plants b = new Flowers("Forget me nots", "medium");
		Plants c = new Vines("Pothos");
		

		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c + "\n");
		
		c.setReqSun("low");
		System.out.println(c + "\n");
		
		
		a.water();
		b.water();
		c.water();
		
		System.out.println(" ");
		System.out.println("Day passes");
		a.dayPasses();
		b.dayPasses();
		c.dayPasses();
		System.out.println("Plants that need watered:");
		
		if (a.isNeedsWatered()){
			System.out.println(a);
		}
		if (b.isNeedsWatered()){
			System.out.println(b);
		}
		if (c.isNeedsWatered()){
			System.out.println(c);
		}
		System.out.println("\n");
		
		System.out.println("Water a plant? (y/n):");
		String yn = sc.nextLine();
		while (yn.equals("y")||yn.equals("Y")) {
			System.out.println("Which plant do you want to water?");
			String plant = sc.nextLine();
			switch (plant) {
			case"Old Lady":
				a.water();
				System.out.println("Water another plant? (y/n):");
				yn = sc.nextLine();
				break;
			case "Forget me nots":
				b.water();
				System.out.println("Water another plant? (y/n):");
				yn = sc.nextLine();
				break;
			case "Pothos":
				c.water();
				System.out.println("Water another plant? (y/n):");
				yn = sc.nextLine();
				break;
			default:
				System.out.println("Plant not recognized. Try again.");
				System.out.println("Water another plant? (y/n):");
				yn = sc.nextLine();
			
			}
		}
		
		System.out.println("Day passes");
		a.dayPasses();
		b.dayPasses();
		c.dayPasses();
		System.out.println("Plants that need watered:");
		
		if (a.isNeedsWatered()){
			System.out.println(a);
		}
		if (b.isNeedsWatered()){
			System.out.println(b);
		}
		if (c.isNeedsWatered()){
			System.out.println(c);
		}
		System.out.println("\n");
		
		
		System.out.println("Water a plant? (y/n):");
		yn = sc.nextLine();
		while (yn.equals("y")||yn.equals("Y")) {
			System.out.println("Which plant do you want to water?");
			String plant = sc.nextLine();
			switch (plant) {
			case"Old Lady":
				a.water();
				System.out.println("Water another plant? (y/n):");
				yn = sc.nextLine();
				break;
			case "Forget me nots":
				b.water();
				System.out.println("Water another plant? (y/n):");
				yn = sc.nextLine();
				break;
			case "Pothos":
				c.water();
				System.out.println("Water another plant? (y/n):");
				yn = sc.nextLine();
				break;
			default:
				System.out.println("Plant not recognized. Try again.");
				System.out.println("Water another plant? (y/n):");
				yn = sc.nextLine();
			
			}
		}
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		sc.close();
		
	}


}
