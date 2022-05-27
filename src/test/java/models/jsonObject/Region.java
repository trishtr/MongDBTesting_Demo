package models.jsonObject;

import java.util.ArrayList;
import java.util.List;

public class Region {
    private String name;
    List internalIds;


    // Getter Methods

    public String getName() {
        return name;
    }

    public List<InternalIds> getInternalIds() {
        return internalIds;
    }

    // Setter Methods

    public Region setName(String name) {
        this.name = name;
        return this;
    }

    public Region setInternalIds(List<InternalIds> internalIds) {
        this.internalIds = internalIds;
        return this;
    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", internalIds=" + internalIds +
                '}';
    }
}
