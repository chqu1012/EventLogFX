package de.dc.fx.event.log.ui.di;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class EventLogPlatform{
	
	private static final Logger LOG = Logger.getLogger(EventLogPlatform.class.getSimpleName());
	private static List<Module> modules = new ArrayList<>();
	private static Injector injector;
	
	static {
		synchronized (EventLogPlatform.class) {
			add(new EventLogModule());
		}
	}

	private EventLogPlatform() {
	}

	/**
	 * This step should be done first, before the {@link #init()} method is called.
	 * @param module
	 */
	
	public static void add(Module module) {
		modules.add(module);
	}
	
	public static void inject(Object obj) {
		injector.injectMembers(obj);
	}
	
	public static void init() {
		injector = Guice.createInjector(modules);
		LOG.log(Level.ALL, "Initialize Guice for ApplicationContext with SelectionServiceModul!");
	}

	public static <T> T getInstance(Class<T> type) {
		T instance = null;
		try {
			instance = injector.getInstance(type);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Failed to get the instance via guice "+e.getLocalizedMessage());
		}
		return instance;
	}
}
