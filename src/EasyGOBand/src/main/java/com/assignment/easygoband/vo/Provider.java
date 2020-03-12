package com.assignment.easygoband.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Provider {

	@JsonProperty("access_group_name")
	private String accessGroupName;

	@JsonProperty("access_group_id")
    private int accessGroupId;

	@JsonProperty("total_uses")
	private int totalUses;

    private List<Session> sessions;

    @JsonProperty("event_id")
    private String eventId;

    @JsonProperty("structure_decode")
    private boolean structureDecode;

    private String name;

    private String modified;

    private String id;

    @JsonProperty("basic_product_id")
    private String basicProductId;

	public String getAccessGroupName() {
		return accessGroupName;
	}

	public void setAccessGroupName(String accessGroupName) {
		this.accessGroupName = accessGroupName;
	}

	public int getAccessGroupId() {
		return accessGroupId;
	}

	public void setAccessGroupId(int accessGroupId) {
		this.accessGroupId = accessGroupId;
	}

	public int getTotalUses() {
		return totalUses;
	}

	public void setTotalUses(int totalUses) {
		this.totalUses = totalUses;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public boolean isStructureDecode() {
		return structureDecode;
	}

	public void setStructureDecode(boolean structureDecode) {
		this.structureDecode = structureDecode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBasicProductId() {
		return basicProductId;
	}

	public void setBasicProductId(String basicProductId) {
		this.basicProductId = basicProductId;
	}
    
    
    
}
