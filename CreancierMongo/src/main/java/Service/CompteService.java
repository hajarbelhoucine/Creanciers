package Service;

import Connexion.Connexion;
import com.mongodb.ErrorCategory;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Date;

public class CompteService {




        public Connexion cnx;

        public void ajoutCompte(MongoDatabase database) {


            //Insert a document into the "characters" collection.
            MongoCollection collection = database.getCollection("Compte");
            System.out.println("get collection");
            // insert a document
            Document compte = new Document();

            compte.append("num_contrat", 1553458)
                    .append("num_telephone", "0688993322")
                    .append("nom", "Lemghari")
                    .append("prenom", "Mariem")
                    .append("date_de_creation", new Date());


            try {
                collection.insertOne(compte);

                System.out.println("Successfully inserted document. \n");
            } catch (MongoWriteException mwe) {
                if (mwe.getError().getCategory().equals(ErrorCategory.DUPLICATE_KEY)) {
                    System.out.println("Document with that id already exists");
                }
                // Lien very inteersr https://www.kenwalger.com/blog/nosql/mongodb-and-java/
            }
        }




}


