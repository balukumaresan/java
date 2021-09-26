package com.balu.gl.algorithms.stockers.client;

import com.balu.gl.algorithms.stockers.analyzer.StockAnalyzer;

/**
 * Stockers client app.
 * Initiates the application.
 * 
 * @author baluk
 *
 */
public class StockersClient {

	public static void main(String[] args) {

		StockAnalyzer sa = new StockAnalyzer();
		sa.analyzeStock();
	}
}
