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
    private List customerIds;

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

    public List getCustomerIds() {
        return customerIds;
    }

    public NursingUnit setCustomerIds(List<String> cusid) {
        this.customerIds = cusid;
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


}
