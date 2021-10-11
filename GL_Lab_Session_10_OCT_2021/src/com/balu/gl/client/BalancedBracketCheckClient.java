package com.balu.gl.client;

import java.util.Scanner;

import com.balu.gl.util.BalancedBracketCheckUtility;

/**
 * This is the client which checks the balance of brackets in the input string
 * 
 * @author baluk
 *
 */
public class BalancedBracketCheckClient {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BalancedBracketCheckUtility utility = new BalancedBracketCheckUtility();
		System.out.println("Please enter the expression to check for balance of bracket");
		String inputString = scanner.next();
		
		if (utility.checkBracketBalance(inputString)) {
			System.out.println(" Brackets are balanced");
		} else {
			System.out.println("Brackets are not balanced");
		}
		scanner.close();
	}

}
