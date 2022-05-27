package tests;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;
import org.testng.annotations.Test;
import models.connection.DatabaseList;
import setup.ConnectionSetup;
import utils.Log;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ConnectionTest {

    @Test
    public void testConnection() {

        String connectionString = ConnectionSetup.getConnectionString();
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            List<Document> database = mongoClient.listDatabases().into(new ArrayList<>());

            Log.info("Verify the connection is successfully made");
            assertFalse(database.isEmpty());

            Log.info("verify the database exists and not empty");
            for (Document db : database) {
                String dbToJson = db.toJson();
                System.out.println(dbToJson);

                Gson gson = new Gson();
                DatabaseList list = gson.fromJson(dbToJson, DatabaseList.class);

                String databaseName = list.getName();
                Boolean empty = list.getEmpty();
                System.out.println(databaseName);
                if(databaseName.equals("sample_SMC")&& !empty){
                    assertTrue(true);
                    break;

                }

            }

        }

    }
}

