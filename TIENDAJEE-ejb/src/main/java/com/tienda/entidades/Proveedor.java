/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erick
 */
@Entity
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findByCodigo", query = "SELECT p FROM Proveedor p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Proveedor.findByNombre", query = "SELECT p FROM Proveedor p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proveedor.findByRuc", query = "SELECT p FROM Proveedor p WHERE p.ruc = :ruc")
    , @NamedQuery(name = "Proveedor.findByDireccion", query = "SELECT p FROM Proveedor p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Proveedor.findByEmail", query = "SELECT p FROM Proveedor p WHERE p.email = :email")
    , @NamedQuery(name = "Proveedor.findByCiudad", query = "SELECT p FROM Proveedor p WHERE p.ciudad = :ciudad")
    , @NamedQuery(name = "Proveedor.findBySitioweb", query = "SELECT p FROM Proveedor p WHERE p.sitioweb = :sitioweb")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "ruc")
    private String ruc;
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "ciudad")
    private String ciudad;
    @Size(max = 50)
    @Column(name = "sitioweb")
    private String sitioweb;

    public Proveedor() {
    }

    public Proveedor(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getSitioweb() {
        return sitioweb;
    }

    public void setSitioweb(String sitioweb) {
        this.sitioweb = sitioweb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tienda.entidades.Proveedor[ codigo=" + codigo + " ]";
    }
    
}
