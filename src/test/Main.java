package test;

import importation.Import;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
	private static String loc = "C:/Users/usr/Documents/GitHub/GymnasieArbete/src/spreadsheet/spreadsheetTemplate.csv";

	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<ArrayList<String>> dataArray = new Import(loc, false).getSheet();
		ArrayList<ArrayList<String>> objectArray = new Import(loc, true).getSheet();

		for (int i = 0; i < dataArray.size(); i++) {
			ArrayList<String> dataPoint = dataArray.get(i);

			for (int j = 0; j < dataPoint.size(); j++) {
				String dataValue = dataPoint.get(j);

				System.out.print(dataValue + "    ");
			}
			System.out.println();
		}

		System.out.println();

		for (int i = 0; i < objectArray.size(); i++) {
			ArrayList<String> object = objectArray.get(i);

			for (int j = 0; j < object.size(); j++) {
				String objectValue = object.get(j);

				System.out.print(objectValue + "    ");
			}
			System.out.println();
		}

	}

}
