package de.dc.fx.event.log.ui.model;

public class EventLogConstant {
  public static final String SQL_FIND_ALL = "SELECT * FROM EVENT_LOG ORDER BY ID DESC";
  
  public static final String SQL_FIND_BY_ID = "SELECT * FROM EVENT_LOG WHERE ID = %s";
  public static final String SQL_INSERT = "INSERT INTO EVENT_LOG (EVENT_ID, CLASS_NAME, SEVERITY, DATE, MESSAGE, STACK_TRACE, SESSION_DATA) VALUES (?, ?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_MERGE = "MERGE INTO EVENT_LOG KEY (ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
  
  public static final String SQL_DELETE_BY_ID = "DELETE EVENT_LOG WHERE ID = ?";
  public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS EVENT_LOG(ID BIGINT AUTO_INCREMENT, EVENT_ID VARCHAR, CLASS_NAME VARCHAR, SEVERITY BIGINT, DATE TIMESTAMP, MESSAGE VARCHAR, STACK_TRACE VARCHAR, SESSION_DATA VARCHAR);";
}
