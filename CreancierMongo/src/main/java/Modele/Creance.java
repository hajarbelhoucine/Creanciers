package Modele;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Creance implements Serializable {


    @XmlTransient
    private long id_creance;
    private long num_contrat;
    private String type ;      //  Fixe ou INTERNET
    private Date periode;
    private float montant;
    private int etat_creance;  // 0 non payé , 1 payé




    public Creance() {

    }

    public Creance(long num_contrat, String type, Date periode, float montant, int etat_creance) {
        this.num_contrat = num_contrat;
        this.type = type;
        this.periode = periode;
        this.montant = montant;
        this.etat_creance = etat_creance;
    }

    public Creance(long id_creance, long num_contrat, String type, Date periode, float montant, int etat_creance) {
        this.id_creance = id_creance;
        this.num_contrat = num_contrat;
        this.type = type;
        this.periode = periode;
        this.montant = montant;
        this.etat_creance = etat_creance;
    }


    public long getId_creance() {
        return id_creance;
    }

    public void setId_creance(long id_creance) {
        this.id_creance = id_creance;
    }

    public long getNum_contrat() {
        return num_contrat;
    }

    public void setNum_contrat(long num_contrat) {
        this.num_contrat = num_contrat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getPeriode() {
        return periode;
    }

    public void setPeriode(Date periode) {
        this.periode = periode;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public int getEtat_creance() {
        return etat_creance;
    }

    public void setEtat_creance(int etat_creance) {
        this.etat_creance = etat_creance;
    }
}
