package Service;


import Modele.Compte;
import Modele.Creance;
import Modele.Recharge;
import com.mongodb.ErrorCategory;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RechargeService {

    public Recharge recharge;

    public Collection<Compte> compte;
    private static Random intGenerator = new Random();
    private int assignRechargeID() {
        return Math.abs(intGenerator.nextInt());
    }


    public void effectuerRecharge(double montant) {
       // Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
      //  mongoLogger.setLevel(Level.SEVERE);

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
        MongoCollection<Document> collectionCompte = database.getCollection("Compte");

        try (MongoCursor<Document> cursor = collectionCompte.find().iterator()) {



            while (cursor.hasNext()) {

                Document doc = cursor.next();
                ArrayList list = new ArrayList<>(doc.values());
                // System.out.printf("%s: %s%n", list.get(1), list.get(2));
               // ArrayList<Document> docs = new ArrayList<Document>();
                MongoCollection<Document> collectionRecharge = database.getCollection("Recharge");
                if (montant == 5.0 || montant == 10.0 || montant == 20.0 || montant == 30.0 || montant == 50.0 || montant == 100.0 || montant == 200) {


                    // if (recharge.getMontant() == 10.0) {
//                    recharge.setMontant(montant);
                  //  recharge.setTotal(montant);
//                    System.out.println(recharge.getTotal());
                  //  System.out.println("recharge de " + recharge.getMontant() + "est effectue");


                    Document recharge1 = new Document();



                   recharge1.append("_id", assignRechargeID())
       .append("num_contrat", list.get(1))


                            .append("montant", montant)
                            .append("total", montant);


                    try {
                        collectionRecharge.insertOne(recharge1);
                        System.out.println("insert succes");

                        } catch (MongoWriteException mwe) {
                            if (mwe.getError().getCategory().equals(ErrorCategory.DUPLICATE_KEY)) {
                                System.out.println("Document with that id already exists");
                            }
                            // Lien very inteersr https://www.kenwalger.com/blog/nosql/mongodb-and-java/
                        }




                }
                else {
                    System.out.println("recharge invalid");
                }
            }
            }




        }






        }


            //










