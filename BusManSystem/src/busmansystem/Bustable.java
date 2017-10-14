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
@Table(name = "bustable", catalog = "bussystem", schema = "")
@NamedQueries({
    @NamedQuery(name = "Bustable.findAll", query = "SELECT b FROM Bustable b")
    , @NamedQuery(name = "Bustable.findByBusID", query = "SELECT b FROM Bustable b WHERE b.busID = :busID")
    , @NamedQuery(name = "Bustable.findBySeatcap", query = "SELECT b FROM Bustable b WHERE b.seatcap = :seatcap")
    , @NamedQuery(name = "Bustable.findByBusType", query = "SELECT b FROM Bustable b WHERE b.busType = :busType")})
public class Bustable implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "busID")
    private String busID;
    @Basic(optional = false)
    @Column(name = "seatcap")
    private int seatcap;
    @Column(name = "busType")
    private String busType;

    public Bustable() {
    }

    public Bustable(String busID) {
        this.busID = busID;
    }

    public Bustable(String busID, int seatcap) {
        this.busID = busID;
        this.seatcap = seatcap;
    }

    public String getBusID() {
        return busID;
    }

    public void setBusID(String busID) {
        String oldBusID = this.busID;
        this.busID = busID;
        changeSupport.firePropertyChange("busID", oldBusID, busID);
    }

    public int getSeatcap() {
        return seatcap;
    }

    public void setSeatcap(int seatcap) {
        int oldSeatcap = this.seatcap;
        this.seatcap = seatcap;
        changeSupport.firePropertyChange("seatcap", oldSeatcap, seatcap);
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        String oldBusType = this.busType;
        this.busType = busType;
        changeSupport.firePropertyChange("busType", oldBusType, busType);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (busID != null ? busID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bustable)) {
            return false;
        }
        Bustable other = (Bustable) object;
        if ((this.busID == null && other.busID != null) || (this.busID != null && !this.busID.equals(other.busID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "busmansystem.Bustable[ busID=" + busID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
