package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Import {
	public ArrayList<ArrayList<String>> getSheet() {
		return sheet;
	}

	public void clearSheet() {
		sheet.clear();
	}

	private ArrayList<ArrayList<String>> sheet = new ArrayList<ArrayList<String>>();

	/**
	 * loc is the location of the .csv file that is to be imported
	 * target is which part of the model.spreadsheet that is supposed to be imported,
	 * target == false targets the data points, and the minimum value, maximum value and the data type of those data points
	 * target == true targets the objects
	 *
	 * @param loc
	 * @param target
	 */
	public Import(String loc, boolean target) throws FileNotFoundException {

		clearSheet();
		Scanner sc = new Scanner(new File(loc));

		if (!target) {
			while (sc.hasNextLine()) {

				sheet.add(HorizontalInsert(sc.nextLine().split(";"), 0, 4));

			}

		} else {
			int dataIndex = 0;
			ArrayList<ArrayList<String>> objectArray = new ArrayList<ArrayList<String>>();

			while (sc.hasNextLine()) {

				ArrayList<String> dataPoint = HorizontalInsert(sc.nextLine().split(";"), 4, 0);

				for (int objectIndex = 0; objectIndex < dataPoint.size(); objectIndex++) {

					ArrayList<String> arrayObject = new ArrayList<String>();

					if (dataIndex == 0) {

						arrayObject.add(dataPoint.get(objectIndex));

						objectArray.add(arrayObject);

					} else {

						arrayObject.addAll(objectArray.get(objectIndex));

						arrayObject.add(dataPoint.get(objectIndex));

						objectArray.set(objectIndex, arrayObject);

					}


				}

				dataIndex++;

			}

			for (ArrayList<String> out: objectArray) {

				sheet.add(out);

			}

		}


		sc.close();
	}

	private ArrayList<String> HorizontalInsert(String[] in, int start, int end) {
		ArrayList<String> arrayObject = new ArrayList<String>();

		if (end == 0) {

			for (int i = start; i < in.length; i++) {
				String dataPoint = in[i];

				arrayObject.add(dataPoint);
			}

			return arrayObject;

		} else {

			for (int i = start; i < end; i++) {
				String dataPoint = in[i];

				arrayObject.add(dataPoint);
			}

			return arrayObject;

		}

	}

}
