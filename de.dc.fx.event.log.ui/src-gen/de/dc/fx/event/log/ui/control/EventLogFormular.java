package de.dc.fx.event.log.ui.control;

import javax.annotation.PostConstruct;

import com.google.inject.Inject;

import de.dc.fx.event.log.ui.model.*;
import de.dc.fx.event.log.ui.repository.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;

public class EventLogFormular extends VBox{

	protected EventLogFX context;
	protected EventLogRepository eventLogRepository;
	
	@Inject
	public EventLogFormular(EventLogFX context, EventLogRepository eventLogRepository) {
		this.context = context;
		this.eventLogRepository = eventLogRepository;
		
		setPadding(new Insets(10));
		getChildren().add(new Label("EventId:"));
		javafx.scene.control.TextField eventIdTextField = new javafx.scene.control.TextField();
		eventIdTextField.setPromptText("Please enter a EventId");
		eventIdTextField.textProperty().bindBidirectional(context.getEventIdProperty() , java.text.NumberFormat.getInstance());
		getChildren().add(eventIdTextField);
		getChildren().add(new Label("ClassName:"));
		javafx.scene.control.TextField classNameTextField = new javafx.scene.control.TextField();
		classNameTextField.setPromptText("Please enter a ClassName");
		classNameTextField.textProperty().bindBidirectional(context.getClassNameProperty() );
		getChildren().add(classNameTextField);
		getChildren().add(new Label("Severity:"));
		javafx.scene.control.TextField severityTextField = new javafx.scene.control.TextField();
		severityTextField.setPromptText("Please enter a Severity");
		severityTextField.textProperty().bindBidirectional(context.getSeverityProperty() , java.text.NumberFormat.getInstance());
		getChildren().add(severityTextField);
		getChildren().add(new Label("Date:"));
		jfxtras.scene.control.LocalDateTimeTextField dateLocalDateTimeTextField = new jfxtras.scene.control.LocalDateTimeTextField();
		dateLocalDateTimeTextField.setPromptText("Please enter a Date");
		dateLocalDateTimeTextField.localDateTimeProperty().bindBidirectional(context.getDateProperty());
		getChildren().add(dateLocalDateTimeTextField);
		getChildren().add(new Label("Message:"));
		javafx.scene.control.TextField messageTextField = new javafx.scene.control.TextField();
		messageTextField.setPromptText("Please enter a Message");
		messageTextField.textProperty().bindBidirectional(context.getMessageProperty() );
		getChildren().add(messageTextField);
		getChildren().add(new Label("StackTrace:"));
		javafx.scene.control.TextField stackTraceTextField = new javafx.scene.control.TextField();
		stackTraceTextField.setPromptText("Please enter a StackTrace");
		stackTraceTextField.textProperty().bindBidirectional(context.getStackTraceProperty() );
		getChildren().add(stackTraceTextField);
		getChildren().add(new Label("SessionData:"));
		javafx.scene.control.TextField sessionDataTextField = new javafx.scene.control.TextField();
		sessionDataTextField.setPromptText("Please enter a SessionData");
		sessionDataTextField.textProperty().bindBidirectional(context.getSessionDataProperty() );
		getChildren().add(sessionDataTextField);
		
		Button submitButton = new Button("Submit");
		submitButton.setOnMouseClicked(this::onButtonSubmit);
		submitButton.disableProperty().bind(context.getEnabledSubmitProperty().not());
		getChildren().add(submitButton);
	}

	public void onButtonSubmit(MouseEvent e) {
		EventLog eventLog = context.getEventLog ();
		eventLogRepository.save(eventLog);
		context.getMasterData().add(eventLog);
		context.clear();
	}
}
