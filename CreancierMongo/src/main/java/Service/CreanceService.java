package Service;

import Modele.Compte;
import Modele.Creance;
import com.mongodb.ErrorCategory;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.time.LocalDate;
import java.util.*;


@WebService
public class CreanceService {

    public Creance creance;
    public Collection<Compte> compte;

    @WebMethod
    public void genererCreance(){
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
            MongoCollection <Document> collectionCompte= database.getCollection("Compte");

            try (MongoCursor< Document > cur = collectionCompte.find().iterator()) {
                long i=1;
                while (cur.hasNext()) {

                    Document  doc = cur.next();
                    ArrayList list = new ArrayList< >(doc.values());
                    System.out.printf("%s: %s%n", list.get(1),list.get(2));

                    ArrayList<Document> docs = new ArrayList < Document > ();
                    MongoCollection <Document> collectionCreance = database.getCollection("Creance");

                    Document creance4 = new Document();

                    creance4.append("id_creance", i++)
                            .append("num_contrat", list.get(1))
                            .append("type", "Fixe")
                            .append("periode", LocalDate.of(2021, 1, 1))
                            .append("montant", 150)
                            .append("etat_creance", 0);
                    docs.add(creance4);

                    Document creance = new Document();

                     creance.append("id_creance", i++)
                            .append("num_contrat", list.get(1))
                            .append("type", "Fixe")
                            .append("periode", LocalDate.of(2020, 12, 1))
                             .append("montant", 150)
                            .append("etat_creance", 0);
                    docs.add(creance);

                    Document creance1 = new Document();

                    creance1.append("id_creance", i++)
                            .append("num_contrat", list.get(1))
                            .append("type", "Fixe")
                            .append("periode", LocalDate.of(2020, 11, 1))
                            .append("montant", 150)
                            .append("etat_creance", 0);
                    docs.add(creance1);

                    Document creance2 = new Document();

                    creance2.append("id_creance", i++)
                            .append("num_contrat", list.get(1))
                            .append("type", "Fixe")
                            .append("periode", LocalDate.of(2020, 10, 1))
                            .append("montant", 150)
                            .append("etat_creance", 0);
                    docs.add(creance2);

                    Document creance3 = new Document();

                    creance3.append("id_creance", i++)
                            .append("num_contrat", list.get(1))
                            .append("type", "Fixe")
                            .append("periode", LocalDate.of(2020, 9, 1))
                            .append("montant", 150)
                            .append("etat_creance", 0);
                    docs.add(creance3);

                    try {
                        collectionCreance.insertMany(docs);

                        System.out.println("Successfully inserted document. \n");
                    } catch (MongoWriteException mwe) {
                        if (mwe.getError().getCategory().equals(ErrorCategory.DUPLICATE_KEY)) {
                            System.out.println("Document with that id already exists");
                        }
                        // Lien very inteersr https://www.kenwalger.com/blog/nosql/mongodb-and-java/
                    }
                }
                }
            }
            @WebMethod
            public List<Creance> listerCreance(){


               List<Creance> listcreance = new ArrayList<>();

                ArrayList list=null;
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
                MongoCollection <Document> collectionCompte= database.getCollection("Creance");

                try (MongoCursor< Document > cur = collectionCompte.find().iterator()) {

                    while (cur.hasNext()) {

                        Document doc = cur.next();
                        list = new ArrayList<>(doc.values());
                        System.out.println(list);
                        System.out.printf("%s: %s%n", list.get(1), list.get(2));
                        creance=new Creance(Long.parseLong(list.get(2).toString()),list.get(3).toString(),(java.util.Date)list.get(4),Float.parseFloat(list.get(5).toString()),Integer.parseInt(list.get(6).toString()));
                        listcreance.add(creance);
                    }
                }

                return listcreance;
            }






}
