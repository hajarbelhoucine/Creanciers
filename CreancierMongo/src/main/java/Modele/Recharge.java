package Modele;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Recharge {
    @XmlTransient
    private long num_contrat;

    private long id_recharge;

    public String getNum_telephone() {
        return num_telephone;
    }

    public void setNum_telephone(String num_telephone) {
        this.num_telephone = num_telephone;
    }

    private double montant;
    String num_telephone;

    public Recharge(long num_contrat, long id_recharge, double montant) {
        this.num_contrat = num_contrat;
        this.id_recharge = id_recharge;
        this.montant = montant;

    }
    public Recharge(String num_telephone, double montant) {
        this.num_telephone = num_telephone;
        this.montant = montant;

    }
    public Recharge(){
    }
    private double total;

    public long getNum_contrat() {
        return num_contrat;
    }

    public void setNum_contrat(long num_contrat) {
        this.num_contrat = num_contrat;
    }

    public long getId_recharge() {
        return id_recharge;
    }

    public void setId_recharge(long id_recharge) {
        this.id_recharge = id_recharge;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
