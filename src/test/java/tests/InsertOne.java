package tests;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import models.jsonObject.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.ConnectionSetup;
import utils.Log;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;

public class InsertOne {

    ConnectionSetup setup = new ConnectionSetup();
    private MongoCollection<Document> testingCollection = setup.connectToDatabase
            (ConnectionSetup.getConnectionString(), "sampleSMC", "nursingUnit");
/*
    @Test
    public void insertOneSimple() {
        Log.info("Verify system successfully create Document with simple content");
        testingCollection.insertOne(new Document("testingId", "testing"));
        Document testingDoc = testingCollection.find(new Document("testingId", "testing")).first();
        Log.info("Print created document in Json format");
        String testingDocJson= testingDoc.toJson();
        System.out.println(testingDocJson);
        Assert.assertTrue(testingDocJson.contains("testing"));

    }
*/
    @Test
    public void insertOneComplex(){
        Log.info("Verify system successfully create Document with complex content");
        Log.info("create complex document inside testing collection");
        //testingCollection.insertOne(createNewDocument());
        Document nursingUnitDocTest2 = testingCollection.find(new Document("unitName", "Testing Unit_101")).first();

        String nursingUnitDocTest2Json = nursingUnitDocTest2.toJson();
        System.out.println(nursingUnitDocTest2Json);
        Log.info("verify the document contains Testing Unit_101");
        //Assert.assertTrue(nursingUnitDocTest2Json.contains("Testing Unit_101"));


        Gson gson = new Gson();
        NursingUnit nursingUnitOb = gson.fromJson(nursingUnitDocTest2Json, NursingUnit.class);
        Assert.assertTrue(nursingUnitOb.equals("Testing Manager101"));

    }
    public static Document createNewDocument() {
        Document client = new Document("clientId", "Testing_APP_002")
                .append("name", "APP")
                .append("locationId", "APP");

        Document internalId1 = new Document("domain","SW")
                .append("domainId", "10");
        Document internalId2 = new Document("domain", "SW")
                .append("domainId", "4");
        Document internalId3 = new Document("domain", "SW")
                .append("domainId", null);


        Document department = new Document("name", "BHU")
                .append("description", "IP")
                .append("customerId", "BHU")
                .append("internalIds", Arrays.asList(internalId1))
                .append("chargeCodes", Arrays.asList("999-9999"));

        Document facility = new Document("name", "CMH")
                .append("type", "Hospital")
                .append("customerId", "CMH")
                .append("internalIds", Arrays.asList(internalId2));

        Document region = new Document("name", "Default")
                .append("internalIds", Arrays.asList(internalId3));

        Document network = new Document("name", "APP")
                .append("internalIds", Arrays.asList(internalId3));


        return new Document("models.jsonObject._id", new ObjectId()).append("client", client)
                .append("unitName", "Testing Unit_101")
                .append("unitManager", "Testing Manager101")
                .append("unitType", "Inpatient")
                .append("internalIds", internalId1)
                .append("customerIds", Arrays.asList("2Testing"))
                .append("department", department)
                .append("facility", facility)
                .append("region", region)
                .append("network", network);

    }

}
