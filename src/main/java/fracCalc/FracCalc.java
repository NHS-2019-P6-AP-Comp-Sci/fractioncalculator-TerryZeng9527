/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner s = new Scanner(System.in);
		String equation = "";
		while (equation != "quit") {
		System.out.println(" Please enter an equation: ");
		equation = s.nextLine();

		if (equation == "quit") {
			System.out.println("Bye bye");
		}
		String number2 = produceAnswer(equation);
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
//		System.out.println(
//				"First Number: whole: " + wholeNumber + " numerator: " + numerator + "denominator: " + denominator);
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
//		System.out.println("Second Number: whole: " + wholeNumber1 + " numerator: " + numerator1 + " denominator: "
//				+ denominator1);
		
		
		
//Value of first number 
		int whole = Integer.parseInt(wholeNumber);
		int top = Integer.parseInt(numerator);
		int bot = Integer.parseInt(denominator);

		int whole1 = Integer.parseInt(wholeNumber1);
		int top1 = Integer.parseInt(numerator1);
		int bot1 = Integer.parseInt(denominator1);

		int wholeTotal = 0;
		int topTotal = top;
		int botTotal = bot;
//Convert Whole number to fractions
		top = top + whole*bot;
		top1 = top1 + whole1*bot1;
		whole = 0;
		whole1= 0;
//		System.out.println(
//		"First Number: numerator: " + top + "denominator: " + bot);
//
//		System.out.println("Second Number: numerator: " + top1 + " denominator: "
//		+ bot1);

//Calculations 

		for (int process = 0; process <= 0; process++) {
			if (eq.contains(" + ")) {

				

				top *= bot1;
				bot *= bot1;
				top1 *= botTotal;
				bot1 *= botTotal;

				topTotal = top + top1;
				botTotal = bot;
			}
			if (eq.contains(" - ")) {

				

				top *= bot1;
				bot *= bot1;
				top1 *= botTotal;
				bot1 *= botTotal;

				topTotal = top - top1;
				botTotal = bot;
			}

			if (eq.contains(" * ")) {
				topTotal = top * top1;
				botTotal = bot * bot1;
				
			}
			if (eq.contains(" / ")) {
				topTotal = top * bot1;
				botTotal = bot * top1;
			}

//			System.out.println(
//					"Final whole: " + wholeTotal + " Total numerator: " + topTotal + " Total denominator: " + botTotal);

		}

//Simplify fraction
		int redu = 0;
		int x = 2;
		while (x <= topTotal/2) {
			if (topTotal % x == 0 && botTotal % x == 0) {
				topTotal /= x;
				botTotal /= x;
				x = 2;
			} else {
				x++;
			}
		}
		if (topTotal == botTotal && topTotal != 0) {
			if (topTotal != 0) {
				wholeTotal += 1;
				topTotal = 0;
				botTotal = 1;

			}

			while (topTotal > botTotal) {
				topTotal -= botTotal;
				wholeTotal++;
			}

		}
		while (topTotal >= botTotal) {
			topTotal = topTotal - botTotal;
			wholeTotal ++;
		}
		if (topTotal == 0 && wholeTotal == 0) {
			botTotal = 0;
		}
		if (topTotal == botTotal && botTotal != 0) {
			whole += 1;
			redu = 1;
			botTotal = 0;
			topTotal = 0;
		}
//Prints out answer for mix faction or whole number
		if (botTotal == 0 && redu ==1) {
			System.out.println("Cannot divide by 0");
		}else {
		if (wholeTotal != 0) {
			System.out.print(wholeTotal);
			if (topTotal != 0) {
				System.out.print("_" + topTotal + "/" + botTotal);
			}
		}

		if (wholeTotal == 0) {
			
				
				if (topTotal == 0 && botTotal ==0 && redu == 0){
					System.out.println("0");
				}
					else {
				
					if (botTotal != 1) {
					System.out.print(topTotal + "/" + botTotal);
					}
					else {
						System.out.println(topTotal);
					}
				}

			}
		}
		// TODO: Fill in the space below with any helper methods that you think you will
		// need

		return num2;

	}
}
