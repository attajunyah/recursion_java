package com.recursion_java;

public class RecursivePalindrome {
	
	public static boolean isPalindrome(String str)
	{
		if (str.length() <= 1) {return true;}
		else if (str.charAt(0) != str.charAt(str.length() - 1)) 
		{
			return false;
		}
		else 
		{
			return isPalindrome(str.substring(1, str.length() - 1));
		}
	}

	public static void main(String[] args) {
		System.out.println("Is moon a palindrome? " + isPalindrome("moon"));
		System.out.println("Is noon a palindrome? " + isPalindrome("noon"));
		System.out.println("Is madam a palindrome? " + isPalindrome("madam"));
		System.out.println("Is dad a palindrome? " + isPalindrome("dad"));

	}

}
