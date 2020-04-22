package visualization;

import control.Import;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ConsoleVis {

	public ConsoleVis(String loc) throws FileNotFoundException {

		ArrayList<ArrayList<String>> dataArray = new Import(loc, false).getSheet();
		ArrayList<ArrayList<String>> objectArray = new Import(loc, true).getSheet();

		for (int i = 0; i < dataArray.size(); i++) {
			ArrayList<String> dataPoint = dataArray.get(i);

			for (int j = 0; j < dataPoint.size(); j++) {
				String dataIn = dataPoint.get(j);

				System.out.print(dataIn + "    ");
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
