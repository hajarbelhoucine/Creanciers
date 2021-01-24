package Modele;

import java.util.Date;

public class Facture {
    public  Facture(long id_creance){
        this.id_creance = id_creance;
    }
    public  Facture(){

    }




    long id_creance;

    public Facture(long id_creance, long id_facture, Date date_paiment, double total) {
        this.id_creance = id_creance;
        this.id_facture = id_facture;
        this.date_paiment = date_paiment;
        this.total = total;
    }

    public long getId_creance() {
        return id_creance;
    }

    public void setId_creance(long id_creance) {
        this.id_creance = id_creance;
    }

    public long getId_facture() {
        return id_facture;
    }

    public void setId_facture(long id_facture) {
        this.id_facture = id_facture;
    }

    public Date getDate_paiment() {
        return date_paiment;
    }

    public void setDate_paiment(Date date_paiment) {
        this.date_paiment = date_paiment;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    long id_facture;
    private Date date_paiment;
    private double total;



}
