package de.dc.fx.event.log.ui.init;

import java.io.*;
import java.net.URL;
import java.sql.*;

import org.h2.tools.RunScript;

import de.dc.fx.event.log.ui.repository.*;
public class EventLogTableInitializer{
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		Connection connection = DriverManager.getConnection(EventLogRepository.JDBC_URL,"SA", "SA");
		URL createUrl = EventLogTableInitializer.class.getResource("/de/dc/fx/event/log/ui/init/create.sql");
		RunScript.execute(connection, new FileReader(new File(createUrl.getFile())));
		
		System.out.println("EventLog table initialized!");
	}
}
