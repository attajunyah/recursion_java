/*
 * In order to compute a power of two, 
 * you can take the next-lower power and double it. 
 * For example, if you want to compute 211 and you know that 210 = 1024, 
 * then 211 = 2 × 1024 = 2048. Write a recursive method
 * public static int pow2(int n) where n is the exponent, 
 * that is based on this observation. If the exponent is negative, return -1.

 */

package com.recursion_java;

public class PowerTwo 
{
	public static int pow2(int n)
	{
		if (n < 0) {return -1;}
		else if (n == 0) { return 1;}
		else 
		{
			return 2 * pow2(n-1);
		}
	}

	public static void main(String[] args) 
	{
		System.out.println(pow2(10));
		System.out.println(pow2(7));
		System.out.println(pow2(0));
		System.out.println(pow2(-2));
		System.out.println(pow2(2));

	}

}
