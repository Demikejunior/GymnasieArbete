package visualization;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;

public class App extends Application {

	private static boolean visual = false;

	public static void main(String[] args) throws FileNotFoundException {

		String loc = new File("").getAbsolutePath() + "\\src\\model\\spreadsheet\\spreadsheetTemplate.csv";
		System.out.println(loc);
		System.out.println();

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
