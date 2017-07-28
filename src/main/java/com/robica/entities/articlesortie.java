package com.robica.entities;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author user
 */
@Entity
public class articlesortie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private float valeurarticle;
    private float nbrsortie;
    private float totalvs;
    private float qtestock;
    private float totalvst;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getValeurarticle() {
        return valeurarticle;
    }

    public void setValeurarticle(float valeurarticle) {
        this.valeurarticle = valeurarticle;
    }

    public float getNbrsortie() {
        return nbrsortie;
    }

    public void setNbrsortie(float nbrsortie) {
        this.nbrsortie = nbrsortie;
    }

    public float getTotalvs() {
        return totalvs;
    }

    public void setTotalvs(float totalvs) {
        this.totalvs = totalvs;
    }

    public float getQtestock() {
        return qtestock;
    }

    public void setQtestock(float qtestock) {
        this.qtestock = qtestock;
    }

    public float getTotalvst() {
        return totalvst;
    }

    public void setTotalvst(float totalvst) {
        this.totalvst = totalvst;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof articlesortie)) {
            return false;
        }
        articlesortie other = (articlesortie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.articlesortie[ id=" + id + " ]";
    }
    
}

