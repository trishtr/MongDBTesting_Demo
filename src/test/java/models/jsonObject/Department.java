package models.jsonObject;

import java.util.List;

public class Department {
    private String name;
    private String description;
    private String customerId;
    List internalIds;
    List chargeCodes;


    // Getter Methods

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<InternalIds> getInternalIds() {
        return internalIds;
    }

    public List getChargeCodes() {
        return chargeCodes;
    }

    // Setter Methods

    public Department setName(String name) {
        this.name = name;
        return this;
    }

    public Department setDescription(String description) {
        this.description = description;
        return this;
    }

    public Department setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public Department setInternalIds(List<InternalIds> internalIds) {
        this.internalIds = internalIds;
        return this;
    }

    public Department setChargeCodes(List chargeCodes) {
        this.chargeCodes = chargeCodes;
        return this;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", customerId='" + customerId + '\'' +
                ", internalIds=" + internalIds +
                ", chargeCodes=" + chargeCodes +
                '}';
    }
}
