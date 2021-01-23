import com.mongodb.ErrorCategory;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import com.mongodb.ErrorCategory;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Connexion {

    public static void main(String[] args) {

        // pour dak le prob de log
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        MongoDatabase database = null;
        try {
            // Connect to MongoDB Server on localhost, port 27017 (default)
            final MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            // Connect to Database
            database = mongoClient.getDatabase("CreancierMarocTelecom");
            System.out.println("Successful database connection established. \n");

        } catch (Exception exception) {
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
        }

        //Insert a document into the "characters" collection.
        MongoCollection collection = database.getCollection("hajarita");
        System.out.println("get collection");
// insert a document
        Document mickeyMouse = new Document();

        mickeyMouse.append("_id", 15555558)

                .append("title", "Mickey Mouse")
                .append("genres", "Mickey Mouse");


        try {
            collection.insertOne(mickeyMouse);

            System.out.println("Successfully inserted document. \n");
        } catch (MongoWriteException mwe) {
            if (mwe.getError().getCategory().equals(ErrorCategory.DUPLICATE_KEY)) {
                System.out.println("Document with that id already exists");
            }
            // Lien very inteersr https://www.kenwalger.com/blog/nosql/mongodb-and-java/
        }


    }
}
