package Modele;

import java.util.Date;

public class Compte {

    private long num_contrat;
    private String num_telephone;
    private String nom;
    private String prenom;
    private Date date_de_creation;

    public Compte(long num_contrat, String num_telephone, String nom, String prenom, Date date_de_creation) {
        this.num_contrat = num_contrat;
        this.num_telephone = num_telephone;
        this.nom = nom;
        this.prenom = prenom;
        this.date_de_creation = date_de_creation;
    }

    public long getNum_contrat() {
        return num_contrat;
    }

    public void setNum_contrat(long num_contrat) {
        this.num_contrat = num_contrat;
    }

    public String getNum_telephone() {
        return num_telephone;
    }

    public void setNum_telephone(String num_telephone) {
        this.num_telephone = num_telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDate_de_creation() {
        return date_de_creation;
    }

    public void setDate_de_creation(Date date_de_creation) {
        this.date_de_creation = date_de_creation;
    }
}
