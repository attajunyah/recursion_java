package com.recursion_java;

import java.util.Scanner;

/**
   This program calculates the value of an expression 
   consisting of numbers, arithmetic operators, and parentheses.
*/
public class ExpressionCalculator
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter an expression: ");
      String input = in.nextLine();
      Evaluator e = new Evaluator(input);
      int value = e.getExpressionValue();
      System.out.println(input + "=" + value);
   }
}

/**
A class that can compute the value of an arithmetic expression.
*/
class Evaluator
{
   private ExpressionTokenizer tokenizer;

   /**
      Constructs an evaluator.
      @param anExpression a string containing the expression
      to be evaluated
   */
   public Evaluator(String anExpression)
   {
      tokenizer = new ExpressionTokenizer(anExpression);
   }

   /**
      Evaluates the expression.
      @return the value of the expression.
   */
   public int getExpressionValue()
   {
      int value = getTermValue();
      boolean done = false;
      while (!done)
      {
         String next = tokenizer.peekToken();
         if ("+".equals(next) || "-".equals(next))
         {
            tokenizer.nextToken(); // Discard "+" or "-"
            int value2 = getTermValue();
            if ("+".equals(next)) { value = value + value2; }
            else { value = value - value2; }
         }
         else 
         {
            done = true;
         }
      }
      return value;
   }

   /**
      Evaluates the next term found in the expression.
      @return the value of the term
   */
   public int getTermValue()
   {
      int value = getFactorValue();
      boolean done = false;
      while (!done)
      {
         String next = tokenizer.peekToken();
         if ("*".equals(next) || "/".equals(next))
         {
            tokenizer.nextToken();
            int value2 = getFactorValue();
            if ("*".equals(next)) { value = value * value2; }
            else { value = value / value2; }
         }
         else 
         {
            done = true;
         }
      }
      return value;
   }

   /**
      Evaluates the next factor found in the expression.
      @return the value of the factor
   */
   public int getFactorValue()
   {
      int value;
      String next = tokenizer.peekToken();
      if ("(".equals(next))
      {
         tokenizer.nextToken(); // Discard "("
         value = getExpressionValue();
         tokenizer.nextToken(); // Discard ")"
      }
      else
      {
         value = Integer.parseInt(tokenizer.nextToken());
      }
      return value;
   }
}

/**
This class breaks up a string describing an expression
into tokens: numbers, parentheses, and operators.
*/
class ExpressionTokenizer
{
	private String input;
	private int start; // The start of the current token
	private int end; // The position after the end of the current token
	
	/**
	   Constructs a tokenizer.
	   @param anInput the string to tokenize
	*/
	public ExpressionTokenizer(String anInput)
	{
	   input = anInput;
	   start = 0;
	   end = 0;
	   nextToken(); // Find the first token
	}
	
	/**
	   Peeks at the next token without consuming it.
	   @return the next token or null if there are no more tokens
	*/
	public String peekToken()
	{
	   if (start >= input.length()) { return null; }
	   else { return input.substring(start, end); }
	}
	
	/**
	   Gets the next token and moves the tokenizer to the following token.
	   @return the next token or null if there are no more tokens
	*/
	public String nextToken()
	{
	   String r = peekToken();
	   start = end;
	   if (start >= input.length()) { return r; }
	   if (Character.isDigit(input.charAt(start)))
	   {
	      end = start + 1;
	      while (end < input.length() 
	            && Character.isDigit(input.charAt(end)))
	      {
	         end++;
	      }
	   }
	   else
	   {
	      end = start + 1;
	   }
	   return r;      
	}
}