package de.dc.fx.event.log.ui.di;

import com.google.inject.AbstractModule;

import de.dc.fx.event.log.ui.control.*;
import de.dc.fx.event.log.ui.model.*;
import de.dc.fx.event.log.ui.repository.*;

public class EventLogModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(EventLogFX.class).asEagerSingleton();
		
		bind(EventLogRepository.class).asEagerSingleton();
		
		bind(EventLogTableView.class).asEagerSingleton();
		bind(EventLogFormular.class).asEagerSingleton();
	}
}

