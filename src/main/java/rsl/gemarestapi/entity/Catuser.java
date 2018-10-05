/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsl.gemarestapi.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author solofoniaina
 */
@Entity
@Table(name = "catuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catuser.findAll", query = "SELECT c FROM Catuser c"),
    @NamedQuery(name = "Catuser.findByIdcatuser", query = "SELECT c FROM Catuser c WHERE c.idcatuser = :idcatuser"),
    @NamedQuery(name = "Catuser.findByCatname", query = "SELECT c FROM Catuser c WHERE c.catname = :catname")})
public class Catuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCATUSER")
    private Integer idcatuser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CATNAME")
    private String catname;
    @OneToMany(mappedBy = "idcatuser")
    private Collection<User> userCollection;

    public Catuser() {
    }

    public Catuser(Integer idcatuser) {
        this.idcatuser = idcatuser;
    }

    public Catuser(Integer idcatuser, String catname) {
        this.idcatuser = idcatuser;
        this.catname = catname;
    }

    public Integer getIdcatuser() {
        return idcatuser;
    }

    public void setIdcatuser(Integer idcatuser) {
        this.idcatuser = idcatuser;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcatuser != null ? idcatuser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catuser)) {
            return false;
        }
        Catuser other = (Catuser) object;
        if ((this.idcatuser == null && other.idcatuser != null) || (this.idcatuser != null && !this.idcatuser.equals(other.idcatuser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rsl.gemarestapi.entity.Catuser[ idcatuser=" + idcatuser + " ]";
    }
    
}
