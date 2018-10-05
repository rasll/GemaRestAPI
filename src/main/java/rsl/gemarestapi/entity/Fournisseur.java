/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsl.gemarestapi.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author solofoniaina
 */
@Entity
@Table(name = "fournisseur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f"),
    @NamedQuery(name = "Fournisseur.findByIdfournisseur", query = "SELECT f FROM Fournisseur f WHERE f.idfournisseur = :idfournisseur"),
    @NamedQuery(name = "Fournisseur.findByProvider", query = "SELECT f FROM Fournisseur f WHERE f.provider = :provider")})
public class Fournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFOURNISSEUR")
    private Integer idfournisseur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PROVIDER")
    private String provider;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfournisseur")
    private Collection<Product> productCollection;

    public Fournisseur() {
    }

    public Fournisseur(Integer idfournisseur) {
        this.idfournisseur = idfournisseur;
    }

    public Fournisseur(Integer idfournisseur, String provider) {
        this.idfournisseur = idfournisseur;
        this.provider = provider;
    }

    public Integer getIdfournisseur() {
        return idfournisseur;
    }

    public void setIdfournisseur(Integer idfournisseur) {
        this.idfournisseur = idfournisseur;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfournisseur != null ? idfournisseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.idfournisseur == null && other.idfournisseur != null) || (this.idfournisseur != null && !this.idfournisseur.equals(other.idfournisseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rsl.gemarestapi.entity.Fournisseur[ idfournisseur=" + idfournisseur + " ]";
    }
    
}
