/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsl.gemarestapi.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author solofoniaina
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByIdproduct", query = "SELECT p FROM Product p WHERE p.idproduct = :idproduct"),
    @NamedQuery(name = "Product.findByProductref", query = "SELECT p FROM Product p WHERE p.productref = :productref"),
    @NamedQuery(name = "Product.findByProductname", query = "SELECT p FROM Product p WHERE p.productname = :productname"),
    @NamedQuery(name = "Product.findByProductdescription", query = "SELECT p FROM Product p WHERE p.productdescription = :productdescription"),
    @NamedQuery(name = "Product.findByProductpriceu", query = "SELECT p FROM Product p WHERE p.productpriceu = :productpriceu"),
    @NamedQuery(name = "Product.findByQtemin", query = "SELECT p FROM Product p WHERE p.qtemin = :qtemin"),
    @NamedQuery(name = "Product.findByQtemax", query = "SELECT p FROM Product p WHERE p.qtemax = :qtemax"),
    @NamedQuery(name = "Product.findByDateperemption", query = "SELECT p FROM Product p WHERE p.dateperemption = :dateperemption")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPRODUCT")
    private Integer idproduct;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PRODUCTREF")
    private String productref;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRODUCTNAME")
    private String productname;
    @Size(max = 100)
    @Column(name = "PRODUCTDESCRIPTION")
    private String productdescription;
    @Column(name = "PRODUCTPRICEU")
    private BigInteger productpriceu;
    @Column(name = "QTEMIN")
    private Integer qtemin;
    @Column(name = "QTEMAX")
    private Integer qtemax;
    @Column(name = "DATEPEREMPTION")
    @Temporal(TemporalType.DATE)
    private Date dateperemption;
    @JoinColumn(name = "IDCATPRODUCT", referencedColumnName = "IDCATPRODUCT")
    @ManyToOne(optional = false)
    private Catproduct idcatproduct;
    @JoinColumn(name = "IDFOURNISSEUR", referencedColumnName = "IDFOURNISSEUR")
    @ManyToOne(optional = false)
    private Fournisseur idfournisseur;
    @JoinColumn(name = "IDREMISE", referencedColumnName = "IDREMISE")
    @ManyToOne
    private Remise idremise;

    public Product() {
    }

    public Product(Integer idproduct) {
        this.idproduct = idproduct;
    }

    public Product(Integer idproduct, String productref, String productname) {
        this.idproduct = idproduct;
        this.productref = productref;
        this.productname = productname;
    }

    public Integer getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
    }

    public String getProductref() {
        return productref;
    }

    public void setProductref(String productref) {
        this.productref = productref;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    public BigInteger getProductpriceu() {
        return productpriceu;
    }

    public void setProductpriceu(BigInteger productpriceu) {
        this.productpriceu = productpriceu;
    }

    public Integer getQtemin() {
        return qtemin;
    }

    public void setQtemin(Integer qtemin) {
        this.qtemin = qtemin;
    }

    public Integer getQtemax() {
        return qtemax;
    }

    public void setQtemax(Integer qtemax) {
        this.qtemax = qtemax;
    }

    public Date getDateperemption() {
        return dateperemption;
    }

    public void setDateperemption(Date dateperemption) {
        this.dateperemption = dateperemption;
    }

    public Catproduct getIdcatproduct() {
        return idcatproduct;
    }

    public void setIdcatproduct(Catproduct idcatproduct) {
        this.idcatproduct = idcatproduct;
    }

    public Fournisseur getIdfournisseur() {
        return idfournisseur;
    }

    public void setIdfournisseur(Fournisseur idfournisseur) {
        this.idfournisseur = idfournisseur;
    }

    public Remise getIdremise() {
        return idremise;
    }

    public void setIdremise(Remise idremise) {
        this.idremise = idremise;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduct != null ? idproduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.idproduct == null && other.idproduct != null) || (this.idproduct != null && !this.idproduct.equals(other.idproduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rsl.gemarestapi.entity.Product[ idproduct=" + idproduct + " ]";
    }
    
}
