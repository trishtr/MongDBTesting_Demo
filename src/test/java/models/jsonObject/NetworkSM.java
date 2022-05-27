package models.jsonObject;

import java.util.ArrayList;
import java.util.List;

public class NetworkSM {
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

    public NetworkSM setName( String name ) {
        this.name = name;
        return this;
    }

    public NetworkSM setInternalIds(List<InternalIds> internalIds) {
        this.internalIds = internalIds;
        return this;
    }

    @Override
    public String toString() {
        return "NetworkSM{" +
                "name='" + name + '\'' +
                ", internalIds=" + internalIds +
                '}';
    }
}
