package models.jsonObject;

public class Clients {
    private String clientId;
    private String name;
    private String locationId;


    // Getter Methods

    public String getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getLocationId() {
        return locationId;
    }

    // Setter Methods

    public Clients setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public Clients setName(String name) {
        this.name = name;
        return this;
    }

    public Clients setLocationId(String locationId) {
        this.locationId = locationId;
        return this;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", name='" + name + '\'' +
                ", locationId='" + locationId + '\'' +
                '}';
    }

}
