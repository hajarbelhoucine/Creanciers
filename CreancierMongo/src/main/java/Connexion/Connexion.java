package Connexion;

import Service.CompteService;
import Service.CreanceService;
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

        CompteService compteService = new CompteService();

        CreanceService creanceService = new CreanceService();

       //   compteService.ajoutCompte();
        //creanceService.genererCreance();

    }
}
