package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Import {
	
	/**
	 * Gets the sheet that the object currently holds
	 * @return
	 */
	public ArrayList<ArrayList<String>> getSheet() {
		return sheet;
	}
	
	/**
	 * Clears the sheet that the object currently holds
	 */
	public void clearSheet() {
		sheet.clear();
	}

	
	private ArrayList<ArrayList<String>> sheet = new ArrayList<ArrayList<String>>();

	/**
	 * loc - the location of the .csv file that is to be imported
	 * target - the part of the model.spreadsheet that is supposed to be imported,
	 * target == false - targets the data points, the value range, and the data type of those data points
	 * target == true - targets the objects
	 *
	 * @param loc
	 * @param target
	 */
	public Import(String loc, boolean target) throws FileNotFoundException {

		clearSheet();
		Scanner sc = new Scanner(new File(loc));

		if (!target) {
			// Imports the objects part of the spreadsheet
			
			while (sc.hasNextLine()) {

				sheet.add(HorizontalInsert(sc.nextLine().split(";"), 0, 4));

			}

		} else {
			// Imports the objects part of the spreadsheet
			
			// The row the method is currently working on
			int dataIndex = 0;
			// The sheet that the method will export
			ArrayList<ArrayList<String>> objectArray = new ArrayList<ArrayList<String>>();

			while (sc.hasNextLine()) {

				// An array of the values on the current row
				ArrayList<String> dataPoint = HorizontalInsert(sc.nextLine().split(";"), 4, 0);

				// Adds the values to the relevant object in objectArray
				for (int objectIndex = 0; objectIndex < dataPoint.size(); objectIndex++) {

					
					ArrayList<String> sheetObject = new ArrayList<String>();

					if (dataIndex == 0) {

						sheetObject.add(dataPoint.get(objectIndex));

						objectArray.add(sheetObject);

					} else {

						sheetObject.addAll(objectArray.get(objectIndex));

						sheetObject.add(dataPoint.get(objectIndex));

						objectArray.set(objectIndex, sheetObject);

					}


				}

				dataIndex++;

			}

			// Exports objectArray
			for (ArrayList<String> out: objectArray) {

				sheet.add(out);

			}

		}


		sc.close();
	}
	
	/**
	 * A method for handling the partitioning of a row
	 *
	 * @param in
	 * @param start
	 * @param end
	 * @return rowPart
	 */
	private ArrayList<String> HorizontalInsert(String[] in, int start, int end) {
		ArrayList<String> rowPart = new ArrayList<String>();

		if (end == 0) {

			for (int i = start; i < in.length; i++) {
				String dataPoint = in[i];

				rowPart.add(dataPoint);
			}

			return rowPart;

		} else {

			for (int i = start; i < end; i++) {
				String dataPoint = in[i];

				rowPart.add(dataPoint);
			}

			return rowPart;

		}

	}

}
