package models.jsonObject;

import java.util.ArrayList;
import java.util.List;

public class Facility {
    private String name;
    private String type;
    private String customerId;
    List internalIds;


    // Getter Methods

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<InternalIds> getInternalIds() {
        return internalIds;
    }
    // Setter Methods

    public Facility setName(String name) {
        this.name = name;
        return this;
    }

    public Facility setType(String type) {
        this.type = type;
        return this;
    }

    public Facility setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public Facility setInternalIds(List<InternalIds> internalIds) {
        this.internalIds = internalIds;
        return this;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", customerId='" + customerId + '\'' +
                ", internalIds=" + internalIds +
                '}';
    }
}
