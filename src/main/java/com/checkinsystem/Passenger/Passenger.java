/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.checkinsystem.Passenger;

import com.checkinsystem.Address.Address;
import com.checkinsystem.Reservation.Reservation;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AMILA
 */
@Entity
@Table(name = "passenger")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passenger.findAll", query = "SELECT p FROM Passenger p"),
    @NamedQuery(name = "Passenger.findById", query = "SELECT p FROM Passenger p WHERE p.id = :id"),
    @NamedQuery(name = "Passenger.findByDocument", query = "SELECT p FROM Passenger p WHERE p.document = :document"),
    @NamedQuery(name = "Passenger.findByName", query = "SELECT p FROM Passenger p WHERE p.name = :name"),
    @NamedQuery(name = "Passenger.findBySurname", query = "SELECT p FROM Passenger p WHERE p.surname = :surname")})
public class Passenger implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "document")
    private String document;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @JoinTable(name = "reservation_passenger", joinColumns = {
        @JoinColumn(name = "id_passenger", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_resevration", referencedColumnName = "id")})
    @ManyToMany
    private List<Reservation> reservationList;
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    @ManyToOne
    private Address idAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPassenger")
    private List<Reservation> reservationList1;

    public Passenger() {
    }

    public Passenger(Integer id) {
        this.id = id;
    }

    public Passenger(Integer id, String document, String name, String surname) {
        this.id = id;
        this.document = document;
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @XmlTransient
    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public Address getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Address idAddress) {
        this.idAddress = idAddress;
    }

    @XmlTransient
    public List<Reservation> getReservationList1() {
        return reservationList1;
    }

    public void setReservationList1(List<Reservation> reservationList1) {
        this.reservationList1 = reservationList1;
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
        if (!(object instanceof Passenger)) {
            return false;
        }
        Passenger other = (Passenger) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.checkinsystem.maven.business.entity.Passenger[ id=" + id + " ]";
    }
    
}
