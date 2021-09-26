package com.balu.gl.algorithms.stockers.analyzer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.balu.gl.algorithms.stockers.util.BinarySearchImpl;
import com.balu.gl.algorithms.stockers.util.MergeSortImpl;

/**
 * Stock Analyzer takes the input from the user. Give the insight based on the
 * Operation selected.
 * 
 * @author baluk
 *
 */
public class StockAnalyzer {

	int noOfCompanies;
	double[] todaysShares;
	int increasedCount;
	int decreasedCount;
	Scanner sc = new Scanner(System.in);
	Map<String, Integer> stockVariationStatus = new HashMap<>();

	/**
	 * Take stocks details input from the user and analyze and provide the insight.
	 * 
	 */
	public void analyzeStock() {

		collectUserShareInput();
		MergeSortImpl.sort(todaysShares, 0, todaysShares.length - 1);

		boolean start = true;
		while (start) {
			System.out.println("");
			System.out.println("-------------------------------------------------");
			System.out.println("Please enter the operation you want to perform\n"
					+ "1. Display the companies stock prices in ascending order\n"
					+ "2. Display the companies stock prices in descending order\n"
					+ "3. Display the total no of companies for which stock prices rose today\n"
					+ "4. Display the total no of companies for which stock prices declined today\n"
					+ "5. Search a specific stock price\n" + "6. press 0 to exit");
			System.out.println("-------------------------------------------------");
			int operation = sc.nextInt();
			switch (operation) {
			case 1: {
				System.out.println("Stock prices in ascending order are :");
				System.out.println("");
				displayStocksInAscendingOrder();
				break;
			}
			case 2: {
				System.out.println("Stock prices in descending order are :");
				System.out.println("");
				diplayStocksInDecendingOrder();
				break;
			}
			case 3: {
				System.out.println("Total no of companies whose stock price rose today : " + increasedCount);
				break;
			}
			case 4: {
				System.out.println("Total no of companies whose stock price declined today : " + decreasedCount);
				break;
			}
			case 5: {
				System.out.println("Please neter the key value");
				double key = sc.nextDouble();
				serachTheStockPrice(key);
				break;
			}
			case 0: {
				start = false;
				System.out.println("Exited successfully");
				break;
			}
			}

			if (!start) {
				System.exit(0);
			}
		}
	}

	private void collectUserShareInput() {
		System.out.println("Please enter No of Companies");
		noOfCompanies = sc.nextInt();
		todaysShares = new double[noOfCompanies];
		for (int i = 0; i < todaysShares.length; i++) {
			System.out.println("Enter current stock price of the company " + (i + 1));
			todaysShares[i] = sc.nextDouble();

			System.out.println("Whether company's stock price rose today compare to yesterday?");
			boolean changeOfStatus = sc.nextBoolean();
			if (changeOfStatus) {
				increasedCount++;
			}
			if (!changeOfStatus) {
				decreasedCount++;
			}
		}
	}

	private void displayStocksInAscendingOrder() {
		for (int i = 0; i < todaysShares.length; i++) {
			System.out.print(todaysShares[i] + " ");
		}
	}

	private void diplayStocksInDecendingOrder() {
		for (int i = todaysShares.length - 1; i >= 0; i--) {
			System.out.print(todaysShares[i] + " ");
		}
	}

	private void serachTheStockPrice(double stock) {

		if (BinarySearchImpl.search(todaysShares, stock)) {
			System.out.println("Stock value " + stock + " is present");
		} else {
			System.out.println("Value not found");
		}
	}
}
