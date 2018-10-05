/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsl.gemarestapi.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author solofoniaina
 */
@Entity
@Table(name = "remise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Remise.findAll", query = "SELECT r FROM Remise r"),
    @NamedQuery(name = "Remise.findByIdremise", query = "SELECT r FROM Remise r WHERE r.idremise = :idremise"),
    @NamedQuery(name = "Remise.findByRemise", query = "SELECT r FROM Remise r WHERE r.remise = :remise")})
public class Remise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDREMISE")
    private Integer idremise;
    @Column(name = "REMISE")
    private BigInteger remise;
    @OneToMany(mappedBy = "idremise")
    private Collection<Product> productCollection;

    public Remise() {
    }

    public Remise(Integer idremise) {
        this.idremise = idremise;
    }

    public Integer getIdremise() {
        return idremise;
    }

    public void setIdremise(Integer idremise) {
        this.idremise = idremise;
    }

    public BigInteger getRemise() {
        return remise;
    }

    public void setRemise(BigInteger remise) {
        this.remise = remise;
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
        hash += (idremise != null ? idremise.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remise)) {
            return false;
        }
        Remise other = (Remise) object;
        if ((this.idremise == null && other.idremise != null) || (this.idremise != null && !this.idremise.equals(other.idremise))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rsl.gemarestapi.entity.Remise[ idremise=" + idremise + " ]";
    }
    
}
