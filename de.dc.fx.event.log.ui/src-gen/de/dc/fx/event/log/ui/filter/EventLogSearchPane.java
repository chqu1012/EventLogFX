package de.dc.fx.event.log.ui.filter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.util.Optional;

public class EventLogSearchPane extends VBox{

    @FXML
    protected VBox paneContent;

    @FXML
    protected Button buttonAccept;

    @FXML
    protected Hyperlink linkCancel;

    @FXML
    protected VBox root;
    @FXML
    protected HBox hboxEventId;

    @FXML
    protected CheckBox checkboxEventId;

    @FXML
    protected ComboBox<EventLogSearchType> comboboxEventId;

    @FXML
    protected TextField textEventId;
    @FXML
    protected HBox hboxClassName;

    @FXML
    protected CheckBox checkboxClassName;

    @FXML
    protected ComboBox<EventLogSearchType> comboboxClassName;

    @FXML
    protected TextField textClassName;
    @FXML
    protected HBox hboxSeverity;

    @FXML
    protected CheckBox checkboxSeverity;

    @FXML
    protected ComboBox<EventLogSearchType> comboboxSeverity;

    @FXML
    protected TextField textSeverity;
    @FXML
    protected HBox hboxDate;

    @FXML
    protected CheckBox checkboxDate;

    @FXML
    protected ComboBox<EventLogSearchType> comboboxDate;

    @FXML
    protected TextField textDate;
    @FXML
    protected HBox hboxMessage;

    @FXML
    protected CheckBox checkboxMessage;

    @FXML
    protected ComboBox<EventLogSearchType> comboboxMessage;

    @FXML
    protected TextField textMessage;
    @FXML
    protected HBox hboxStackTrace;

    @FXML
    protected CheckBox checkboxStackTrace;

    @FXML
    protected ComboBox<EventLogSearchType> comboboxStackTrace;

    @FXML
    protected TextField textStackTrace;
    @FXML
    protected HBox hboxSessionData;

    @FXML
    protected CheckBox checkboxSessionData;

    @FXML
    protected ComboBox<EventLogSearchType> comboboxSessionData;

    @FXML
    protected TextField textSessionData;
    
    private ObservableList<EventLogSearchContent> content = FXCollections.observableArrayList();
     
	public static final String FXML = "/de/dc/fx/event/log/ui/filter/EventLogSearchPane.fxml";

	public EventLogSearchPane() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		hboxEventId.disableProperty().bind(checkboxEventId.selectedProperty().not());
		comboboxEventId.setItems(FXCollections.observableArrayList(EventLogSearchType.values()));
		comboboxEventId.getSelectionModel().selectFirst();
		hboxClassName.disableProperty().bind(checkboxClassName.selectedProperty().not());
		comboboxClassName.setItems(FXCollections.observableArrayList(EventLogSearchType.values()));
		comboboxClassName.getSelectionModel().selectFirst();
		hboxSeverity.disableProperty().bind(checkboxSeverity.selectedProperty().not());
		comboboxSeverity.setItems(FXCollections.observableArrayList(EventLogSearchType.values()));
		comboboxSeverity.getSelectionModel().selectFirst();
		hboxDate.disableProperty().bind(checkboxDate.selectedProperty().not());
		comboboxDate.setItems(FXCollections.observableArrayList(EventLogSearchType.values()));
		comboboxDate.getSelectionModel().selectFirst();
		hboxMessage.disableProperty().bind(checkboxMessage.selectedProperty().not());
		comboboxMessage.setItems(FXCollections.observableArrayList(EventLogSearchType.values()));
		comboboxMessage.getSelectionModel().selectFirst();
		hboxStackTrace.disableProperty().bind(checkboxStackTrace.selectedProperty().not());
		comboboxStackTrace.setItems(FXCollections.observableArrayList(EventLogSearchType.values()));
		comboboxStackTrace.getSelectionModel().selectFirst();
		hboxSessionData.disableProperty().bind(checkboxSessionData.selectedProperty().not());
		comboboxSessionData.setItems(FXCollections.observableArrayList(EventLogSearchType.values()));
		comboboxSessionData.getSelectionModel().selectFirst();
	}
     
    @FXML
    protected void onActionEvent(ActionEvent event) {
    	if (event.getSource()==buttonAccept) {
    		content.clear();
			if(checkboxEventId.isSelected()){
				String value = textEventId.getText();
				String name = checkboxEventId.getText();
				EventLogSearchType type = comboboxEventId.getSelectionModel().getSelectedItem();
				content.add(new EventLogSearchContent(name, value, type));
			}
			if(checkboxClassName.isSelected()){
				String value = textClassName.getText();
				String name = checkboxClassName.getText();
				EventLogSearchType type = comboboxClassName.getSelectionModel().getSelectedItem();
				content.add(new EventLogSearchContent(name, value, type));
			}
			if(checkboxSeverity.isSelected()){
				String value = textSeverity.getText();
				String name = checkboxSeverity.getText();
				EventLogSearchType type = comboboxSeverity.getSelectionModel().getSelectedItem();
				content.add(new EventLogSearchContent(name, value, type));
			}
			if(checkboxDate.isSelected()){
				String value = textDate.getText();
				String name = checkboxDate.getText();
				EventLogSearchType type = comboboxDate.getSelectionModel().getSelectedItem();
				content.add(new EventLogSearchContent(name, value, type));
			}
			if(checkboxMessage.isSelected()){
				String value = textMessage.getText();
				String name = checkboxMessage.getText();
				EventLogSearchType type = comboboxMessage.getSelectionModel().getSelectedItem();
				content.add(new EventLogSearchContent(name, value, type));
			}
			if(checkboxStackTrace.isSelected()){
				String value = textStackTrace.getText();
				String name = checkboxStackTrace.getText();
				EventLogSearchType type = comboboxStackTrace.getSelectionModel().getSelectedItem();
				content.add(new EventLogSearchContent(name, value, type));
			}
			if(checkboxSessionData.isSelected()){
				String value = textSessionData.getText();
				String name = checkboxSessionData.getText();
				EventLogSearchType type = comboboxSessionData.getSelectionModel().getSelectedItem();
				content.add(new EventLogSearchContent(name, value, type));
			}
			
			String select = "SELECT * FROM CONTACT WHERE ";
			Optional<String> result = content.stream().map(e-> e.getName()+" = '"+e.getValue()+"'").reduce((e1,e2) -> e1 +" OR "+e2);
			result.ifPresent(e-> System.out.println(select+e));
		}
    	root.toBack();
    }
}
