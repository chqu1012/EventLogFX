package de.dc.fx.event.log.ui;

import de.dc.fx.event.log.ui.control.EventLogTableView;
import de.dc.fx.event.log.ui.control.ExtendedEventLogFormular;
import de.dc.fx.event.log.ui.control.ExtendedEventLogTableView;
import de.dc.fx.event.log.ui.di.EventLogPlatform;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ExtendedEventLogDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		ExtendedEventLogTableView eventLogTableView = EventLogPlatform.getInstance(ExtendedEventLogTableView.class);
		ExtendedEventLogFormular eventLogFormular = EventLogPlatform.getInstance(ExtendedEventLogFormular.class);
		
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
