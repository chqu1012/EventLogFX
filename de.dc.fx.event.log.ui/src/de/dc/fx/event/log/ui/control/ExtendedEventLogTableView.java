package de.dc.fx.event.log.ui.control;

import com.google.inject.Inject;

import de.dc.fx.event.log.ui.model.EventLog;
import de.dc.fx.event.log.ui.model.EventLogFX;
import de.dc.fx.event.log.ui.repository.EventLogRepository;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.input.MouseEvent;
import javafx.util.Pair;

public class ExtendedEventLogTableView extends EventLogTableView {

	@Inject
	public ExtendedEventLogTableView(EventLogFX context, EventLogRepository eventLogRepository) {
		super(context, eventLogRepository);
		
		setOnMouseClicked(this::openEventDetails);
	}

	private void openEventDetails(MouseEvent e) {
		EventLog selection = getSelectionModel().getSelectedItem();
		if (selection!=null) {
			Dialog<Pair<String, String>> dialog = new Dialog<>();
			dialog.setTitle("Event Details");
			dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK);
			dialog.getDialogPane().setContent(new EventDetails(selection));
			dialog.showAndWait();
		}
	}
}
