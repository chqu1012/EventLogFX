package de.dc.fx.event.log.ui.control;

import java.time.LocalDateTime;
import java.util.Arrays;

import com.google.inject.Inject;

import de.dc.fx.event.log.ui.model.EventLogFX;
import de.dc.fx.event.log.ui.repository.EventLogRepository;
import javafx.scene.input.MouseEvent;

public class ExtendedEventLogFormular extends EventLogFormular{

	@Inject
	public ExtendedEventLogFormular(EventLogFX context, EventLogRepository eventLogRepository) {
		super(context, eventLogRepository);
	}
	
	@Override
	public void onButtonSubmit(MouseEvent e) {
		try {
			Double.parseDouble("Hallo");
		} catch (Exception e2) {
			context.getClassNameProperty().set(getClass().getName());
			context.getDateProperty().set(LocalDateTime.now());
			context.getMessageProperty().set(e2.getMessage());
			context.getSeverityProperty().set(1);
			context.getStackTraceProperty().set(Arrays.toString(e2.getStackTrace()));
			eventLogRepository.save(context.getEventLog());
		}
		
	}
	
}
