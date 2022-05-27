package setup;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ConnectionSetup {

    public static String getDatabaseName() {
        String databaseName = "sample_SMC";
        return databaseName;
    }

    public static String getCollectionName() {
        String collectionName = "nursingUnit";
        return collectionName;
    }

    public static String getConnectionString() {
        String connectionString = "mongodb+srv://trangtr:giadinh1@cluster0.y6rdz.mongodb.net/?retryWrites=true&w=majority" +
                "&connectTimeoutMS=30000&socketTimeoutMS=30000";
        return connectionString;
    }


    public static MongoCollection<Document> connectToDatabase(String connectionString, String databaseName, String collectionName){

        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase sampleTrainingDb = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> testingCollection = sampleTrainingDb.getCollection(collectionName);
        return testingCollection;

    }
}
