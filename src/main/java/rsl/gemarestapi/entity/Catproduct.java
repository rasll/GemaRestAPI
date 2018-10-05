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
@Table(name = "catproduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catproduct.findAll", query = "SELECT c FROM Catproduct c"),
    @NamedQuery(name = "Catproduct.findByIdcatproduct", query = "SELECT c FROM Catproduct c WHERE c.idcatproduct = :idcatproduct"),
    @NamedQuery(name = "Catproduct.findByCatprductname", query = "SELECT c FROM Catproduct c WHERE c.catprductname = :catprductname")})
public class Catproduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCATPRODUCT")
    private Integer idcatproduct;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CATPRDUCTNAME")
    private String catprductname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcatproduct")
    private Collection<Product> productCollection;

    public Catproduct() {
    }

    public Catproduct(Integer idcatproduct) {
        this.idcatproduct = idcatproduct;
    }

    public Catproduct(Integer idcatproduct, String catprductname) {
        this.idcatproduct = idcatproduct;
        this.catprductname = catprductname;
    }

    public Integer getIdcatproduct() {
        return idcatproduct;
    }

    public void setIdcatproduct(Integer idcatproduct) {
        this.idcatproduct = idcatproduct;
    }

    public String getCatprductname() {
        return catprductname;
    }

    public void setCatprductname(String catprductname) {
        this.catprductname = catprductname;
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
        hash += (idcatproduct != null ? idcatproduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catproduct)) {
            return false;
        }
        Catproduct other = (Catproduct) object;
        if ((this.idcatproduct == null && other.idcatproduct != null) || (this.idcatproduct != null && !this.idcatproduct.equals(other.idcatproduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rsl.gemarestapi.entity.Catproduct[ idcatproduct=" + idcatproduct + " ]";
    }
    
}
