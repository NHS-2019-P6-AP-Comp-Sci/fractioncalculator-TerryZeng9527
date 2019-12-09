/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter an equation: ");
		
		String equation = s.nextLine();
		if (equation == "quit") {
			System.out.println("Bye bye");
		} else {
			String number2 = produceAnswer(equation);

		System.out.println(number2 );

		}
		
	}
	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"

	public static String produceAnswer(String input) {
		// TODO: Implement this function to produce the solution to the input

	    String eq = (input);
		int operator = 0;
		if (eq.contains(" - ")) {
			operator = eq.indexOf(" - ");
		}
		if (eq.contains(" + ")) {
			operator = eq.indexOf(" + ");
		}
		if (eq.contains(" * ")) {
			operator = eq.indexOf(" * ");
		}
		if (eq.contains(" / ")) {
			operator = eq.indexOf(" / ");
		}

		String num1 = eq.substring(0, operator);
		int op2 = operator + 1;
		int indexOfNum2 = op2 + 2;

		String num2 = eq.substring(indexOfNum2);
		
		int under = 0;
		int slash = 0;

		String wholeNumber = "0";
		String numerator = "0";
		String denominator = "1";

		String wholeNumber1 = "0";
		String numerator1 = "0";
		String denominator1 = "1";

		// System.out.println(num1);
		// System.out.println(num2);
//First Number
		if (num1.contains("/")) {
			if (num1.contains("_")) {
				under = num1.indexOf("_");
				wholeNumber = num1.substring(0, under);
				slash = num1.indexOf("/");
				numerator = num1.substring(under + 1, slash);
				denominator = num1.substring(slash + 1);
			} else {
				slash = num1.indexOf("/");
				numerator = num1.substring(0, slash);
				denominator = num1.substring(slash + 1);
			}
		} else {
			wholeNumber = num1;
		}
		//System.out.println("First Number: whole: " + wholeNumber + " numerator: " + numerator + "denominator: " + denominator);
//Second Number 		
		if (num2.contains("/")) {
			if (num2.contains("_")) {
				under = num2.indexOf("_");
				wholeNumber1 = num2.substring(0, under);
				slash = num2.indexOf("/");
				numerator1 = num2.substring(under + 1, slash);
				denominator1 = num2.substring(slash + 1);
			} else {
				slash = num2.indexOf("/");
				numerator1 = num2.substring(0, slash);
				denominator1 = num2.substring(slash + 1);
			}
		} else {
			wholeNumber1 = num2;
		}
		String result = "whole:"+wholeNumber1+" numerator:"+numerator1+" denominator:"+denominator1;
//Value of first number 
		return result;
		
	}
}
