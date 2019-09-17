package de.dc.fx.event.log.ui.control;

import java.util.function.Function;
import com.google.inject.Inject;

import de.dc.fx.event.log.ui.model.*;
import de.dc.fx.event.log.ui.repository.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class EventLogTableView extends TableView<EventLog>{
	
	private ObservableList<EventLog> masterData = FXCollections.observableArrayList();
	private FilteredList<EventLog> filteredData = new FilteredList<>(masterData, p->true);
	
	private EventLogFX context;
	private EventLogRepository eventLogRepository;
	
	@Inject
	public EventLogTableView(EventLogFX context, EventLogRepository eventLogRepository) {
		this.context = context;
		this.eventLogRepository = eventLogRepository;
		
		TableColumn<EventLog, Long> columnId = new TableColumn<>("#ID");
		columnId.setPrefWidth(100);
		setupCellValueFactory(columnId, e->new SimpleObjectProperty<>(e.getId()));
		getColumns().add(columnId);
		TableColumn<EventLog, java.lang.Long> columnEventId = new TableColumn<>("#EVENTID");
		columnEventId.setPrefWidth(100.0);
		setupCellValueFactory(columnEventId, e->new SimpleObjectProperty<>(e.getEventId()));
		getColumns().add(columnEventId);
		TableColumn<EventLog, java.lang.String> columnClassName = new TableColumn<>("#CLASSNAME");
		columnClassName.setPrefWidth(100.0);
		setupCellValueFactory(columnClassName, e->new SimpleObjectProperty<>(e.getClassName()));
		getColumns().add(columnClassName);
		TableColumn<EventLog, java.lang.Integer> columnSeverity = new TableColumn<>("#SEVERITY");
		columnSeverity.setPrefWidth(100.0);
		setupCellValueFactory(columnSeverity, e->new SimpleObjectProperty<>(e.getSeverity()));
		getColumns().add(columnSeverity);
		TableColumn<EventLog, java.time.LocalDateTime> columnDate = new TableColumn<>("#DATE");
		columnDate.setPrefWidth(100.0);
		setupCellValueFactory(columnDate, e->new SimpleObjectProperty<>(e.getDate()));
		getColumns().add(columnDate);
		TableColumn<EventLog, java.lang.String> columnMessage = new TableColumn<>("#MESSAGE");
		columnMessage.setPrefWidth(100.0);
		setupCellValueFactory(columnMessage, e->new SimpleObjectProperty<>(e.getMessage()));
		getColumns().add(columnMessage);
		TableColumn<EventLog, java.lang.String> columnStackTrace = new TableColumn<>("#STACKTRACE");
		columnStackTrace.setPrefWidth(100.0);
		setupCellValueFactory(columnStackTrace, e->new SimpleObjectProperty<>(e.getStackTrace()));
		getColumns().add(columnStackTrace);
		TableColumn<EventLog, java.lang.String> columnSessionData = new TableColumn<>("#SESSIONDATA");
		columnSessionData.setPrefWidth(100.0);
		setupCellValueFactory(columnSessionData, e->new SimpleObjectProperty<>(e.getSessionData()));
		getColumns().add(columnSessionData);
		
		context.getMasterData().addAll(eventLogRepository.findAll());
		setItems(context.getFilteredMasterData());
	}

	public FilteredList<EventLog> getFilteredList(){
		return filteredData;
	}
	
	public ObservableList<EventLog> getMasterData(){
		return masterData;
	}
	
	public void add(EventLog... eventLogs) {
		masterData.addAll(eventLogs);
	}
	
	public void remove(EventLog... eventLogs) {
		masterData.removeAll(eventLogs);
	}

	private <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
}
