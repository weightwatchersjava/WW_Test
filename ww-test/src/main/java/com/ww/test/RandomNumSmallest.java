package com.ww.test;

import java.util.Arrays;
import java.util.Random;

public class RandomNumSmallest {

	public static void main(String args[]) {

		Random randomNum = new Random();
		int[] numbers = new int[500]; //initialize with 500 
		numbers[0] = randomNum.nextInt(1000); //First Random number generation
		int min = numbers[0]; // Set it as min value
		for(int i=1 ; i<500; i++) 
		{
			//Random number generation and adding to array
			numbers[i] = randomNum.nextInt(1000);

			//Getting the smallest by comparison
			min = Math.min(min , numbers[i]);  

		}
		System.out.println("List of array is: " + Arrays.toString(numbers));
		System.out.println("Small number is : " +min);
	}

}
