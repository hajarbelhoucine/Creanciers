package Service;

import Modele.Creance;
import Modele.Facture;
import com.mongodb.ErrorCategory;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class FactureService {
    CreanceService creanceService = new CreanceService();
    private static Random intGenerator = new Random();
    private int assignFactureID() {
        return Math.abs(intGenerator.nextInt());
    }



    public void generateFacture(int id_creance) {


        List<Creance> listcreance = new ArrayList<>();
        listcreance = creanceService.listerCreance();



        MongoDatabase database = null;

        try {
            // Connect to MongoDB Server on localhost, port 27017 (default)
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            // Connect to Database
            database = mongoClient.getDatabase("CreancierMarocTelecom");
            System.out.println("Successful database connection established. \n");

        } catch (Exception exception) {
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
        MongoCollection<Document> collectionFacture = database.getCollection("Facture");




                    Document facture = new Document();



                   facture.append("_id", assignFactureID())
                            .append("id_creance", id_creance)


                            .append("date_paiment",new Date())
                            .append("total", 199999);


                    try {
                        collectionFacture.insertOne(facture);
                        System.out.println("insert  facture succes");

                    } catch (MongoWriteException mwe) {
                        if (mwe.getError().getCategory().equals(ErrorCategory.DUPLICATE_KEY)) {
                            System.out.println("Document with that id already exists");
                        }
                        // Lien very inteersr https://www.kenwalger.com/blog/nosql/mongodb-and-java/
                    }




                }
                }







