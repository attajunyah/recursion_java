package com.recursion_java;

import java.util.Scanner;

public class ComputeFibonacci 
{

	public static void main(String[] args) 
	{
		// Create a scanner 
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an index for a Fibonacci number: ");
		int index = input.nextInt();
		
		//Find and display the fibonacci number 
		System.out.println("The Fibonacci number at index " 
				+ index + " is " + fib(index));

	}
	// The method for finding the fibonacci number 
	public static long fib(long index)
	{
		if (index == 0) {return 0;}
		else if (index == 1) {return 1;}
		else 
		{
			return fib(index -1) + fib(index -2);
		}
	}

}
