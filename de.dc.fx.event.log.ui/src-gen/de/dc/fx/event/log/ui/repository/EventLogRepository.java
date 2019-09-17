package de.dc.fx.event.log.ui.repository;

import java.sql.*;
import de.dc.fx.event.log.ui.model.*;
import java.util.*;
import java.time.*;

public class EventLogRepository extends BaseRepository<EventLog>{

	@Override
	protected EventLog map(ResultSet resultSet) throws SQLException{
		EventLog eventLog = new EventLog();
		eventLog.setId(resultSet.getLong("ID"));
		eventLog.setEventId(resultSet.getLong("EVENT_ID"));
		eventLog.setClassName(resultSet.getString("CLASS_NAME"));
		eventLog.setSeverity(resultSet.getInt("SEVERITY"));
		eventLog.setDate(resultSet.getTimestamp("DATE").toLocalDateTime());
		eventLog.setMessage(resultSet.getString("MESSAGE"));
		eventLog.setStackTrace(resultSet.getString("STACK_TRACE"));
		eventLog.setSessionData(resultSet.getString("SESSION_DATA"));
		return eventLog;
	}
	
	public void updateEventId(long id, java.lang.Long eventId) {
		queryExecute("UPDATE EVENT_LOG SET EVENT_ID ='"+eventId+"' WHERE ID = "+id);
	}
	
	public void deleteByEventId(java.lang.Long eventId) {
		queryExecute("DELETE EVENT_LOG WHERE EVENT_ID = '"+eventId+"'");
	}
	
	public List<EventLog> findAllByEventId(Long eventId){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE EVENT_ID = '%s'", String.valueOf(eventId)));
	}

	public List<EventLog> findAllByEventIdOrderByAsc(Long eventId){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE EVENT_ID = '%s' ORDER BY EVENT_ID ASC", String.valueOf(eventId)));
	}

	public List<EventLog> findAllByEventIdOrderByDesc(Long eventId){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE EVENT_ID = '%s' ORDER BY EVENT_ID DESC", String.valueOf(eventId)));
	}

	public List<EventLog> findAllByEventIdLike(Long eventId){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE EVENT_ID like '%%s%'", String.valueOf(eventId)));
	}
	
	public List<EventLog> findAllByEventIdLikeOrderByAsc(Long eventId){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE EVENT_ID like '%%s%' ORDER BY EVENT_ID ASC", String.valueOf(eventId)));
	}
	
	public List<EventLog> findAllByEventIdLikeOrderByDesc(Long eventId){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE EVENT_ID like '%%s%' ORDER BY EVENT_ID DESC", String.valueOf(eventId)));
	}
	public void updateClassName(long id, java.lang.String className) {
		queryExecute("UPDATE EVENT_LOG SET CLASS_NAME ='"+className+"' WHERE ID = "+id);
	}
	
	public void deleteByClassName(java.lang.String className) {
		queryExecute("DELETE EVENT_LOG WHERE CLASS_NAME = '"+className+"'");
	}
	
	public List<EventLog> findAllByClassName(String className){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE CLASS_NAME = '%s'", String.valueOf(className)));
	}

	public List<EventLog> findAllByClassNameOrderByAsc(String className){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE CLASS_NAME = '%s' ORDER BY CLASS_NAME ASC", String.valueOf(className)));
	}

	public List<EventLog> findAllByClassNameOrderByDesc(String className){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE CLASS_NAME = '%s' ORDER BY CLASS_NAME DESC", String.valueOf(className)));
	}

	public List<EventLog> findAllByClassNameLike(String className){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE CLASS_NAME like '%%s%'", String.valueOf(className)));
	}
	
	public List<EventLog> findAllByClassNameLikeOrderByAsc(String className){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE CLASS_NAME like '%%s%' ORDER BY CLASS_NAME ASC", String.valueOf(className)));
	}
	
	public List<EventLog> findAllByClassNameLikeOrderByDesc(String className){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE CLASS_NAME like '%%s%' ORDER BY CLASS_NAME DESC", String.valueOf(className)));
	}
	public void updateSeverity(long id, java.lang.Integer severity) {
		queryExecute("UPDATE EVENT_LOG SET SEVERITY ='"+severity+"' WHERE ID = "+id);
	}
	
	public void deleteBySeverity(java.lang.Integer severity) {
		queryExecute("DELETE EVENT_LOG WHERE SEVERITY = '"+severity+"'");
	}
	
	public List<EventLog> findAllBySeverity(Integer severity){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE SEVERITY = '%s'", String.valueOf(severity)));
	}

	public List<EventLog> findAllBySeverityOrderByAsc(Integer severity){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE SEVERITY = '%s' ORDER BY SEVERITY ASC", String.valueOf(severity)));
	}

	public List<EventLog> findAllBySeverityOrderByDesc(Integer severity){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE SEVERITY = '%s' ORDER BY SEVERITY DESC", String.valueOf(severity)));
	}

	public List<EventLog> findAllBySeverityLike(Integer severity){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE SEVERITY like '%%s%'", String.valueOf(severity)));
	}
	
	public List<EventLog> findAllBySeverityLikeOrderByAsc(Integer severity){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE SEVERITY like '%%s%' ORDER BY SEVERITY ASC", String.valueOf(severity)));
	}
	
	public List<EventLog> findAllBySeverityLikeOrderByDesc(Integer severity){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE SEVERITY like '%%s%' ORDER BY SEVERITY DESC", String.valueOf(severity)));
	}
	public void updateDate(long id, java.time.LocalDateTime date) {
		queryExecute("UPDATE EVENT_LOG SET DATE ='"+date+"' WHERE ID = "+id);
	}
	
	public void deleteByDate(java.time.LocalDateTime date) {
		queryExecute("DELETE EVENT_LOG WHERE DATE = '"+date+"'");
	}
	
	public List<EventLog> findAllByDate(LocalDateTime date){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE DATE = '%s'", String.valueOf(date)));
	}

	public List<EventLog> findAllByDateOrderByAsc(LocalDateTime date){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE DATE = '%s' ORDER BY DATE ASC", String.valueOf(date)));
	}

	public List<EventLog> findAllByDateOrderByDesc(LocalDateTime date){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE DATE = '%s' ORDER BY DATE DESC", String.valueOf(date)));
	}

	public List<EventLog> findAllByDateLike(LocalDateTime date){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE DATE like '%%s%'", String.valueOf(date)));
	}
	
	public List<EventLog> findAllByDateLikeOrderByAsc(LocalDateTime date){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE DATE like '%%s%' ORDER BY DATE ASC", String.valueOf(date)));
	}
	
	public List<EventLog> findAllByDateLikeOrderByDesc(LocalDateTime date){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE DATE like '%%s%' ORDER BY DATE DESC", String.valueOf(date)));
	}
	public void updateMessage(long id, java.lang.String message) {
		queryExecute("UPDATE EVENT_LOG SET MESSAGE ='"+message+"' WHERE ID = "+id);
	}
	
	public void deleteByMessage(java.lang.String message) {
		queryExecute("DELETE EVENT_LOG WHERE MESSAGE = '"+message+"'");
	}
	
	public List<EventLog> findAllByMessage(String message){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE MESSAGE = '%s'", String.valueOf(message)));
	}

	public List<EventLog> findAllByMessageOrderByAsc(String message){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE MESSAGE = '%s' ORDER BY MESSAGE ASC", String.valueOf(message)));
	}

	public List<EventLog> findAllByMessageOrderByDesc(String message){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE MESSAGE = '%s' ORDER BY MESSAGE DESC", String.valueOf(message)));
	}

	public List<EventLog> findAllByMessageLike(String message){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE MESSAGE like '%%s%'", String.valueOf(message)));
	}
	
	public List<EventLog> findAllByMessageLikeOrderByAsc(String message){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE MESSAGE like '%%s%' ORDER BY MESSAGE ASC", String.valueOf(message)));
	}
	
	public List<EventLog> findAllByMessageLikeOrderByDesc(String message){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE MESSAGE like '%%s%' ORDER BY MESSAGE DESC", String.valueOf(message)));
	}
	public void updateStackTrace(long id, java.lang.String stackTrace) {
		queryExecute("UPDATE EVENT_LOG SET STACK_TRACE ='"+stackTrace+"' WHERE ID = "+id);
	}
	
	public void deleteByStackTrace(java.lang.String stackTrace) {
		queryExecute("DELETE EVENT_LOG WHERE STACK_TRACE = '"+stackTrace+"'");
	}
	
	public List<EventLog> findAllByStackTrace(String stackTrace){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE STACK_TRACE = '%s'", String.valueOf(stackTrace)));
	}

	public List<EventLog> findAllByStackTraceOrderByAsc(String stackTrace){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE STACK_TRACE = '%s' ORDER BY STACK_TRACE ASC", String.valueOf(stackTrace)));
	}

	public List<EventLog> findAllByStackTraceOrderByDesc(String stackTrace){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE STACK_TRACE = '%s' ORDER BY STACK_TRACE DESC", String.valueOf(stackTrace)));
	}

	public List<EventLog> findAllByStackTraceLike(String stackTrace){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE STACK_TRACE like '%%s%'", String.valueOf(stackTrace)));
	}
	
	public List<EventLog> findAllByStackTraceLikeOrderByAsc(String stackTrace){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE STACK_TRACE like '%%s%' ORDER BY STACK_TRACE ASC", String.valueOf(stackTrace)));
	}
	
	public List<EventLog> findAllByStackTraceLikeOrderByDesc(String stackTrace){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE STACK_TRACE like '%%s%' ORDER BY STACK_TRACE DESC", String.valueOf(stackTrace)));
	}
	public void updateSessionData(long id, java.lang.String sessionData) {
		queryExecute("UPDATE EVENT_LOG SET SESSION_DATA ='"+sessionData+"' WHERE ID = "+id);
	}
	
	public void deleteBySessionData(java.lang.String sessionData) {
		queryExecute("DELETE EVENT_LOG WHERE SESSION_DATA = '"+sessionData+"'");
	}
	
	public List<EventLog> findAllBySessionData(String sessionData){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE SESSION_DATA = '%s'", String.valueOf(sessionData)));
	}

	public List<EventLog> findAllBySessionDataOrderByAsc(String sessionData){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE SESSION_DATA = '%s' ORDER BY SESSION_DATA ASC", String.valueOf(sessionData)));
	}

	public List<EventLog> findAllBySessionDataOrderByDesc(String sessionData){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE SESSION_DATA = '%s' ORDER BY SESSION_DATA DESC", String.valueOf(sessionData)));
	}

	public List<EventLog> findAllBySessionDataLike(String sessionData){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE SESSION_DATA like '%%s%'", String.valueOf(sessionData)));
	}
	
	public List<EventLog> findAllBySessionDataLikeOrderByAsc(String sessionData){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE SESSION_DATA like '%%s%' ORDER BY SESSION_DATA ASC", String.valueOf(sessionData)));
	}
	
	public List<EventLog> findAllBySessionDataLikeOrderByDesc(String sessionData){
		return query(String.format("SELECT * FROM EVENT_LOG WHERE SESSION_DATA like '%%s%' ORDER BY SESSION_DATA DESC", String.valueOf(sessionData)));
	}
	
	@Override
	protected String findAllStatement() {
		return EventLogConstant.SQL_FIND_ALL;
	}
	
	@Override
	protected String findByIdStatement(long id) {
		return String.format(EventLogConstant.SQL_FIND_BY_ID, id);
	}

	@Override
	protected String saveStatement() {
		return EventLogConstant.SQL_INSERT;
	}

	@Override
	protected void prepareStatetmentForSave(EventLog t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getEventId());
		statement.setString(2, t.getClassName());
		statement.setInt(3, t.getSeverity());
		statement.setTimestamp(4, Timestamp.valueOf(t.getDate()));
		statement.setString(5, t.getMessage());
		statement.setString(6, t.getStackTrace());
		statement.setString(7, t.getSessionData());
	}

	@Override
	protected String updateStatement() {
		return EventLogConstant.SQL_MERGE;
	}

	@Override
	protected void prepareStatetmentForUpdate(EventLog t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
		statement.setLong(2, t.getEventId());
		statement.setString(3, t.getClassName());
		statement.setInt(4, t.getSeverity());
		statement.setTimestamp(5, Timestamp.valueOf(t.getDate()));
		statement.setString(6, t.getMessage());
		statement.setString(7, t.getStackTrace());
		statement.setString(8, t.getSessionData());
	}

	@Override
	protected String deleteStatement() {
		return EventLogConstant.SQL_DELETE_BY_ID;
	}
	
	@Override
	protected void prepapreStatementForDelete(EventLog t, PreparedStatement statement) throws SQLException {
		statement.setLong(1, t.getId());
	}
}
