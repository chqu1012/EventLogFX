package de.dc.fx.event.log.ui.control;
import java.io.IOException;
import java.util.logging.Level;

import de.dc.fx.event.log.ui.model.EventLog;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EventDetails extends GridPane {

    @FXML
    protected TextField textClassname;

    @FXML
    protected Label labelSeverity;

    @FXML
    protected Label labelDate;

    @FXML
    protected TextArea textMessage;

    @FXML
    protected TextArea textStacktrace;

    public EventDetails(EventLog log) {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/de/dc/fx/event/log/ui/control/EventDetails.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		textClassname.setText(log.getClassName());
		labelDate.setText(log.getDate().toString());
		labelSeverity.setText(Severity.values()[log.getSeverity()].name());
		textMessage.setText(log.getMessage());
		textStacktrace.setText(log.getStackTrace());
    }
}