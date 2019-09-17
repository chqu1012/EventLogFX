package de.dc.fx.event.log.ui.filter;

import org.apache.commons.lang.builder.ToStringBuilder;

public class EventLogSearchContent {

	private String name;
	private String value;
	private EventLogSearchType type;

	public EventLogSearchContent(String name, String value, EventLogSearchType type) {
		this.name = name;
		this.value = value;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public EventLogSearchType getType() {
		return type;
	}

	public void setType(EventLogSearchType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
