package de.dc.fx.event.log.ui.model;

import java.util.*;
import java.time.*;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EventLog{

	private Long id;
	private Long eventId;
	private String className;
	private Integer severity;
	private LocalDateTime date;
	private String message;
	private String stackTrace;
	private String sessionData;
	
	public EventLog() {
	}
		
	public EventLog(Long eventId, String className, Integer severity, LocalDateTime date, String message, String stackTrace, String sessionData) {
		this.eventId = eventId;
		this.className = className;
		this.severity = severity;
		this.date = date;
		this.message = message;
		this.stackTrace = stackTrace;
		this.sessionData = sessionData;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id=id;
	}
	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
	public String getSessionData() {
		return sessionData;
	}

	public void setSessionData(String sessionData) {
		this.sessionData = sessionData;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
