package Connexion;

import Service.CompteService;
import Service.CreanceService;
import Service.FactureService;
import Service.RechargeService;
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
       Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
       mongoLogger.setLevel(Level.SEVERE);

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


        CompteService compteService = new CompteService();

        CreanceService creanceService = new CreanceService();

       RechargeService rechargeService = new RechargeService();
       FactureService factureService = new FactureService();
       rechargeService.effectuerRecharge(10.0);
       rechargeService.effectuerRecharge(1087.0);

       //  compteService.ajoutCompte(database);
       // creanceService.genererCreance();
       // creanceService.listerCreance();
      factureService.generateFacture(1);


    }
}
