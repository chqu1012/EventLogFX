package de.dc.fx.event.log.ui.model;

import de.dc.fx.event.log.ui.model.*;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.lang.Long;
import java.lang.String;
import java.lang.Integer;
import java.time.LocalDateTime;
import java.lang.String;
import java.lang.String;
import java.lang.String;

public class EventLogFX {
	
  private EventLog eventLog;
  private ObjectProperty<EventLog> eventLogProperty = new SimpleObjectProperty<>();
  private ObservableList<EventLog> masterData = FXCollections.observableArrayList();
  private FilteredList<EventLog> filteredMasterData = new FilteredList<>(masterData, p-> true);
  
  private LongProperty idProperty = new SimpleLongProperty();
  private BooleanProperty enableSubmitProperty = new SimpleBooleanProperty(false);
  
  private LongProperty eventIdProperty = new SimpleLongProperty();
  private StringProperty classNameProperty = new SimpleStringProperty();
  private IntegerProperty severityProperty = new SimpleIntegerProperty();
  private ObjectProperty<java.time.LocalDateTime> dateProperty = new SimpleObjectProperty<>();
  private StringProperty messageProperty = new SimpleStringProperty();
  private StringProperty stackTraceProperty = new SimpleStringProperty();
  private StringProperty sessionDataProperty = new SimpleStringProperty();
  
  public EventLogFX() {
    this(new EventLog());
  }
  
  public EventLogFX(EventLog eventLog) {
    this.eventLog=eventLog;
    this.eventLogProperty.set(eventLog);
    
	this.eventLogProperty.addListener((observable, oldValue, newValue) -> {
		if (newValue!=null) {
			eventIdProperty.set(newValue.getEventId());
			classNameProperty.set(newValue.getClassName());
			severityProperty.set(newValue.getSeverity());
			dateProperty.set(newValue.getDate());
			messageProperty.set(newValue.getMessage());
			stackTraceProperty.set(newValue.getStackTrace());
			sessionDataProperty.set(newValue.getSessionData());
		}
	});

    BooleanBinding isEnabled = classNameProperty.isNotEmpty().and(messageProperty.isNotEmpty()).and(stackTraceProperty.isNotEmpty()).and(sessionDataProperty.isNotEmpty());
    this.enableSubmitProperty.bind(isEnabled);
  }

  public ObjectProperty<EventLog> getEventLogProperty() {
    return eventLogProperty;
  }

  public BooleanProperty getEnabledSubmitProperty() {
    return enableSubmitProperty;
  }
  
  public ObservableList<EventLog>  getMasterData(){
  	return masterData;
  }

  public FilteredList<EventLog> getFilteredMasterData(){
  	return filteredMasterData;
  }
  
  public EventLog getEventLog() {
  	this.eventLog = new EventLog();
  	this.eventLog.setEventId(eventIdProperty.getValue());
  	this.eventLog.setClassName(classNameProperty.getValue());
  	this.eventLog.setSeverity(severityProperty.getValue());
  	this.eventLog.setDate(dateProperty.getValue());
  	this.eventLog.setMessage(messageProperty.getValue());
  	this.eventLog.setStackTrace(stackTraceProperty.getValue());
  	this.eventLog.setSessionData(sessionDataProperty.getValue());
    return this.eventLog;
  }
  
  public LongProperty getIdProperty(){
  	return idProperty;
  }
  
  public void setIdProperty(LongProperty idProperty){
  	this.idProperty = idProperty;
  }
  
  public LongProperty getEventIdProperty() {
    return this.eventIdProperty;
  }
  
  public void setEventIdProperty(LongProperty eventIdProperty) {
    this.eventIdProperty = eventIdProperty;
  }
  public StringProperty getClassNameProperty() {
    return this.classNameProperty;
  }
  
  public void setClassNameProperty(StringProperty classNameProperty) {
    this.classNameProperty = classNameProperty;
  }
  public IntegerProperty getSeverityProperty() {
    return this.severityProperty;
  }
  
  public void setSeverityProperty(IntegerProperty severityProperty) {
    this.severityProperty = severityProperty;
  }
  public ObjectProperty<java.time.LocalDateTime> getDateProperty() {
    return this.dateProperty;
  }
  
  public void setDateProperty(ObjectProperty<java.time.LocalDateTime> dateProperty) {
    this.dateProperty = dateProperty;
  }
  public StringProperty getMessageProperty() {
    return this.messageProperty;
  }
  
  public void setMessageProperty(StringProperty messageProperty) {
    this.messageProperty = messageProperty;
  }
  public StringProperty getStackTraceProperty() {
    return this.stackTraceProperty;
  }
  
  public void setStackTraceProperty(StringProperty stackTraceProperty) {
    this.stackTraceProperty = stackTraceProperty;
  }
  public StringProperty getSessionDataProperty() {
    return this.sessionDataProperty;
  }
  
  public void setSessionDataProperty(StringProperty sessionDataProperty) {
    this.sessionDataProperty = sessionDataProperty;
  }

  public void clear() {
  	  this.eventIdProperty.set(0l);
  	  this.classNameProperty.set("");
  	  this.severityProperty.set(0);
  	  this.dateProperty.set(java.time.LocalDateTime.now());
  	  this.messageProperty.set("");
  	  this.stackTraceProperty.set("");
  	  this.sessionDataProperty.set("");
  }

  public String toString() {
    return  org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(getEventLog());
  }
}
