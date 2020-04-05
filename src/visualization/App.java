package visualization;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class App extends Application {

	private static boolean visual = false;

	public static void main(String[] args) throws FileNotFoundException {

		String loc = "C:/Users/usr/Documents/GitHub/GymnasieArbete/src/model/spreadsheet/spreadsheetTemplate.csv";


		if (visual) {
			launch();
		} else {
			ConsoleVis vis = new ConsoleVis(loc);
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

	}
}
