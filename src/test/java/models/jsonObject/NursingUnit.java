package models.jsonObject;

import com.google.gson.Gson;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class NursingUnit {

    private ObjectId id;

    //ClientObject
    Clients client;
    @BsonProperty(value = "unitName")
    private String unitName;
    @BsonProperty(value = "unitManager")
    private String unitManager;
    @BsonProperty(value = "unitType")
    private String unitType;

    private List internalIds;
    private String[] customerIds;

    //DepartmentObject
    Department department;
    //FacilityObject
    Facility facility;
    //RegionObject
    Region region;
    //NetworkObject
    NetworkSM network;

    public ObjectId getId() {
        return id;
    }

    public NursingUnit setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public Clients getClientObject() {
        return client;
    }

    public NursingUnit setClientObject(Clients clientObject) {
        client = clientObject;
        return this;
    }

    public String getUnitName() {
        return unitName;
    }

    public NursingUnit setUnitName(String unitName) {
        this.unitName = unitName;
        return this;
    }

    public String getUnitManager() {
        return unitManager;
    }

    public NursingUnit setUnitManager(String unitManager) {
        this.unitManager = unitManager;
        return this;
    }

    public String getUnitType() {
        return unitType;
    }

    public NursingUnit setUnitType(String unitType) {
        this.unitType = unitType;
        return this;
    }

    public List <InternalIds> getInternalIds() {
        return internalIds;
    }

    public NursingUnit setInternalIds(List<InternalIds> internalIds) {
        this.internalIds = internalIds;
        return this;
    }

    public String[] getCustomerIds() {
        return customerIds;
    }

    public NursingUnit setCustomerIds(String[] id) {
        this.customerIds = id;
        return this;
    }

    public Department getDepartmentObject() {
        return department;
    }

    public NursingUnit setDepartmentObject(Department departmentObject) {
        department = departmentObject;
        return this;
    }

    public Facility getFacilityObject() {
        return facility;
    }

    public NursingUnit setFacilityObject(Facility facilityObject) {
        facility = facilityObject;
        return this;
    }

    public Region getRegionObject() {
        return region;
    }

    public NursingUnit setRegionObject(Region regionObject) {
        region = regionObject;
        return this;
    }

    public NetworkSM getNetworkObject() {
        return network;
    }

    public NursingUnit setNetworkObject(NetworkSM networkObject) {
        network = networkObject;
        return this;
    }

    @Override
    public String toString() {
        return "NursingUnit{" +
                "id=" + id +
                ", client=" + client +
                ", unitName='" + unitName + '\'' +
                ", unitManager='" + unitManager + '\'' +
                ", unitType='" + unitType + '\'' +
                ", internalIds=" + internalIds +
                ", customerIds=" + customerIds +
                ", DepartmentObject=" + department +
                ", FacilityObject=" + facility +
                ", RegionObject=" + region +
                ", NetworkObject=" + network +
                '}';
    }

    public static void main(String[] args) throws IOException {

        Clients client = new Clients();
        client.setClientId("testing");
        client.setName("abc");
        client.setLocationId("123");

        InternalIds internalIds = new InternalIds();
        internalIds.setDomain("test");
        internalIds.setDomainId("testid");

        Department department = new Department();

        department.setName("testing");
        department.setDescription("abc");
        department.setCustomerId("123");
        department.setInternalIds(Arrays.asList(internalIds));
        department.setChargeCodes(new String[] {"999-9999"});

        Facility facility = new Facility();
        facility.setName("testing");
        facility.setType("tesing");
        facility.setCustomerId("testid");
        facility.setInternalIds(Arrays.asList(internalIds));

        Region region = new Region();
        region.setName("Default");
        region.setInternalIds(Arrays.asList(internalIds));

        NetworkSM network = new NetworkSM();
        network.setName("Default");
        network.setInternalIds(Arrays.asList(internalIds));


        NursingUnit nursingUnit = new NursingUnit();
        nursingUnit.setClientObject(client);
        nursingUnit.setInternalIds(Arrays.asList(internalIds));
        nursingUnit.setCustomerIds(new String[]{"abc"});
        nursingUnit.setDepartmentObject(department);
        nursingUnit.setFacilityObject(facility);
        nursingUnit.setRegionObject(region);
        nursingUnit.setNetworkObject(network);

        System.out.println(nursingUnit.toString());

        Gson gson = new Gson();
        System.out.println(System.getProperty("user.dir"));
        //gson.toJson(nursingUnit, new FileWriter(System.getProperty("user.dir") + "/data.json"));
        String jsonObj = gson.toJson(nursingUnit);
        System.out.println(jsonObj);


    }
}
