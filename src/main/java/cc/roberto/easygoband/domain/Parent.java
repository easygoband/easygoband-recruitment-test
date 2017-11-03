package cc.roberto.easygoband.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parent {

    private String accessGroupName;
    private long accessGroupId;
    private long totalUses;
    private List<Session> sessions;
    private long eventId;
    private boolean structureDecode;
    private String name;
    private String modified;
    private long id;
    private long basicProductId;
    
    @JsonProperty("access_group_name")
    public String getAccessGroupName() {
        return accessGroupName;
    }
    
    @JsonProperty("access_group_name")
    public void setAccessGroupName(String accessGroupName) {
        this.accessGroupName = accessGroupName;
    }
    
    @JsonProperty("access_group_id")
    public long getAccessGroupId() {
        return accessGroupId;
    }
    
    @JsonProperty("access_group_id")
    public void setAccessGroupId(long accessGroupId) {
        this.accessGroupId = accessGroupId;
    }
    
    @JsonProperty("total_uses")
    public long getTotalUses() {
        return totalUses;
    }
    
    @JsonProperty("total_uses")
    public void setTotalUses(long total_uses) {
        this.totalUses = total_uses;
    }
    
    @JsonProperty("sessions")
    public List<Session> getSessions() {
        return sessions;
    }
    
    @JsonProperty("sessions")
    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
    
    @JsonProperty("event_id")
    public long getEventId() {
        return eventId;
    }
    
    @JsonProperty("event_id")
    public void setEventId(long eventId) {
        this.eventId = eventId;
    }
    
    @JsonProperty("structure_decode")
    public boolean isStructureDecode() {
        return structureDecode;
    }
    
    @JsonProperty("structure_decode")
    public void setStructureDecode(boolean structure_decode) {
        this.structureDecode = structure_decode;
    }
    
    @JsonProperty("name")
    public String getName() {
        return name;
    }
    
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
    
    @JsonProperty("modified")
    public String getModified() {
        return modified;
    }
    
    @JsonProperty("modified")
    public void setModified(String modified) {
        this.modified = modified;
    }
    
    @JsonProperty("id")
    public long getId() {
        return id;
    }
    
    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
    }
    
    @JsonProperty("basic_product_id")
    public long getBasicProductId() {
        return basicProductId;
    }
    
    @JsonProperty("basic_product_id")
    public void setBasicProductId(long basicProductId) {
        this.basicProductId = basicProductId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (accessGroupId ^ (accessGroupId >>> 32));
        result = prime * result + ((accessGroupName == null) ? 0 : accessGroupName.hashCode());
        result = prime * result + (int) (basicProductId ^ (basicProductId >>> 32));
        result = prime * result + (int) (eventId ^ (eventId >>> 32));
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((modified == null) ? 0 : modified.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((sessions == null) ? 0 : sessions.hashCode());
        result = prime * result + (structureDecode ? 1231 : 1237);
        result = prime * result + (int) (totalUses ^ (totalUses >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Parent)) {
            return false;
        }
        Parent other = (Parent) obj;
        if (accessGroupId != other.accessGroupId) {
            return false;
        }
        if (accessGroupName == null) {
            if (other.accessGroupName != null) {
                return false;
            }
        }
        else if (!accessGroupName.equals(other.accessGroupName)) {
            return false;
        }
        if (basicProductId != other.basicProductId) {
            return false;
        }
        if (eventId != other.eventId) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (modified == null) {
            if (other.modified != null) {
                return false;
            }
        }
        else if (!modified.equals(other.modified)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        }
        else if (!name.equals(other.name)) {
            return false;
        }
        if (sessions == null) {
            if (other.sessions != null) {
                return false;
            }
        }
        else if (!sessions.equals(other.sessions)) {
            return false;
        }
        if (structureDecode != other.structureDecode) {
            return false;
        }
        if (totalUses != other.totalUses) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Parent [accessGroupName=");
        builder.append(accessGroupName);
        builder.append(", accessGroupId=");
        builder.append(accessGroupId);
        builder.append(", totalUses=");
        builder.append(totalUses);
        builder.append(", sessions=");
        builder.append(sessions);
        builder.append(", eventId=");
        builder.append(eventId);
        builder.append(", structureDecode=");
        builder.append(structureDecode);
        builder.append(", name=");
        builder.append(name);
        builder.append(", modified=");
        builder.append(modified);
        builder.append(", id=");
        builder.append(id);
        builder.append(", basicProductId=");
        builder.append(basicProductId);
        builder.append("]");
        return builder.toString();
    }
}
