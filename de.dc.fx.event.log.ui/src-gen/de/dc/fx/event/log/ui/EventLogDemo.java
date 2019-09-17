package de.dc.fx.event.log.ui;

import de.dc.fx.event.log.ui.control.*;
import de.dc.fx.event.log.ui.di.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EventLogDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		EventLogTableView eventLogTableView = EventLogPlatform.getInstance(EventLogTableView.class);
		EventLogFormular eventLogFormular = EventLogPlatform.getInstance(EventLogFormular.class);

		BorderPane root = new BorderPane();
		root.setCenter(eventLogTableView);
		root.setRight(eventLogFormular);
		stage.setScene(new Scene(root , 1200, 600));
		stage.show();
	}

	public static void main(String[] args) {
		EventLogPlatform.init();
		
		launch(args);
	}
}
