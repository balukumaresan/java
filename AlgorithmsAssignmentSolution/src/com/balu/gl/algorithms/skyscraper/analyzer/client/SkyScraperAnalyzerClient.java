package com.balu.gl.algorithms.skyscraper.analyzer.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.balu.gl.algorithms.skyscraper.analyzer.util.SkyScraperAnalyzer;
import com.balu.gl.algorithms.skyscraper.analyzer.util.SkyScraperAnalyzer;

/**
 * Sky Scraper analyzer client
 * 
 * @author baluk
 *
 */
public class SkyScraperAnalyzerClient {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("please enter the total no of floors in the building");
		int noOfFloors = scanner.nextInt();

		ArrayList<Integer> floorSizeList = new ArrayList<>();
		for (int i = 1; i <= noOfFloors; i++) {
			System.out.println("please enter the floor size given on day :" + i);
			int floorSize = scanner.nextInt();
			boolean distinct = false;
			while (!distinct) {
				if (floorSizeList.contains(floorSize)) {
					System.out.println("Floor size is not distinct");
					System.out.println("please re enter the floor size given on day :" + i);
					floorSize = scanner.nextInt();
				} else {
					floorSizeList.add(floorSize);
					distinct = true;
				}
			}
		}

		SkyScraperAnalyzer SkyScraperAnalyzer2 = new SkyScraperAnalyzer();
		SkyScraperAnalyzer2.analyze2(floorSizeList);

		scanner.close();
	}
}
