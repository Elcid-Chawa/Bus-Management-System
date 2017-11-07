/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busmansystem;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author tseliso
 */
@Entity
@Table(name = "reserve", catalog = "bussystem", schema = "")
@NamedQueries({
    @NamedQuery(name = "Reserve.findAll", query = "SELECT r FROM Reserve r")
    , @NamedQuery(name = "Reserve.findByNames", query = "SELECT r FROM Reserve r WHERE r.names = :names")
    , @NamedQuery(name = "Reserve.findBySeat", query = "SELECT r FROM Reserve r WHERE r.seat = :seat")
    , @NamedQuery(name = "Reserve.findByCity", query = "SELECT r FROM Reserve r WHERE r.city = :city")
    , @NamedQuery(name = "Reserve.findById", query = "SELECT r FROM Reserve r WHERE r.id = :id")})
public class Reserve implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Names")
    private String names;
    @Column(name = "seat")
    private Integer seat;
    @Column(name = "city")
    private String city;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Reserve() {
    }

    public Reserve(Integer id) {
        this.id = id;
    }

    public Reserve(Integer id, String names) {
        this.id = id;
        this.names = names;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        String oldNames = this.names;
        this.names = names;
        changeSupport.firePropertyChange("names", oldNames, names);
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        Integer oldSeat = this.seat;
        this.seat = seat;
        changeSupport.firePropertyChange("seat", oldSeat, seat);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        String oldCity = this.city;
        this.city = city;
        changeSupport.firePropertyChange("city", oldCity, city);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
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
        if (!(object instanceof Reserve)) {
            return false;
        }
        Reserve other = (Reserve) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "busmansystem.Reserve[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
