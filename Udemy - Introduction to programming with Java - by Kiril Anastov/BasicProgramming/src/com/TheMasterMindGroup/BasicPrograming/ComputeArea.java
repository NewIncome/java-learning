package com.TheMasterMindGroup.BasicPrograming;

import java.util.Scanner;
/** To quick-import the above we need to put the cursor
 *  after the word Scanner, then press CTRL + Space
 */


public class ComputeArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		double area;
		double radius;
		
		System.out.println("Provide value for the radius");
		radius = input.nextDouble();
		
		area = radius * radius * 3.14159;
		
		System.out.println("The area for the circle of radius " + radius + " is " + area);
		/**
		 * 1. Read in the radius
		 * 2. Compute the area using the following formula:
		 * 	  area = radius * radius * p
		 * 3. Display the area
		 */
	}

}
