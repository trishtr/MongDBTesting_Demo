package tests;

import com.google.gson.Gson;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import models.jsonObject.*;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.ConnectionSetup;
import utils.Log;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class InsertOnePojo {

    @Test
    public static void insertOneTest() {
        ConnectionString connectionString = new ConnectionString(ConnectionSetup.getConnectionString());
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase("sampleSMC");
            MongoCollection<NursingUnit> nursingUnit = db.getCollection("nursingUnit", NursingUnit.class);

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
            department.setChargeCodes(Arrays.asList("999-9999"));

            Facility facility = new Facility();
            facility.setName("testing");
            facility.setType("testing");
            facility.setCustomerId("testid");
            facility.setInternalIds(Arrays.asList(internalIds));

            Region region = new Region();
            region.setName("Default");
            region.setInternalIds(Arrays.asList(internalIds));

            NetworkSM network = new NetworkSM();
            network.setName("Default");
            network.setInternalIds(Arrays.asList(internalIds));


            NursingUnit newNursingUnit = new NursingUnit().setClientObject(client)
                    .setUnitName("testing")
                    .setUnitManager("testing manager")
                    .setUnitType("testing type")
                    .setInternalIds(Arrays.asList(internalIds))
                    .setCustomerIds(Arrays.asList("abc"))
                    .setDepartmentObject(department)
                    .setFacilityObject(facility)
                    .setRegionObject(region)
                    .setNetworkObject(network);

            Gson gson = new Gson();
            //System.out.println(System.getProperty("user.dir"));
            //gson.toJson(nursingUnit, new FileWriter(System.getProperty("user.dir") + "/data.json"));
            String jsonObj = gson.toJson(newNursingUnit);
            System.out.println(jsonObj);

            //nursingUnit.insertOne(newNursingUnit);
            System.out.println("Document inserted.");

            NursingUnit nursingUnit1 = nursingUnit.find(eq("unitManager", "testing manager")).first();
            System.out.println(nursingUnit1);
            Log.info("verifying unitManager has value: testing manager");
            Assert.assertEquals(nursingUnit1.getUnitManager(), "testing manager");

            Log.info("verifying clientId has value : testing");
            Assert.assertEquals(nursingUnit1.getClientObject().getClientId(), "testing");



        }
    }
}