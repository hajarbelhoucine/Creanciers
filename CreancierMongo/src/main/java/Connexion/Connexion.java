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

import javax.xml.ws.Endpoint;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connexion {



   public static void main(String[] args) {
       String url="http://localhost:8586/MarocTelecom";

       Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
       mongoLogger.setLevel(Level.SEVERE);


       //Endpoint.publish(url,new CreanceService());
       RechargeService rechargeService  = new RechargeService();
       CompteService compteService = new CompteService();
       CreanceService creanceService = new CreanceService();
       Endpoint.publish(url,rechargeService);




     //  RechargeService rechargeService = new RechargeService();
     //  FactureService factureService = new FactureService();
      // rechargeService.effectuerRecharge(30.0);
     //  rechargeService.effectuerRecharge(1087.0);

       //  compteService.ajoutCompte(database);
       // creanceService.genererCreance();
       // creanceService.listerCreance();
   //   factureService.generateFacture(1);


    }
}
