/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.managedbean;

import com.tienda.entidades.Proveedor;
import com.tienda.session.ProveedorFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author erick
 */
@Named(value = "proveedorManagedBean")
@ViewScoped
public class ProveedorManagedBean implements Serializable, ManagedBeanInterface<Proveedor>{

    //PASO 1: INSTANCIAR SESSIONBEAN DE CARGO
    @EJB
    private ProveedorFacadeLocal proveedorFacadeLocal;
    
     //CONSTRUCTOR DE LA CLASE
    public ProveedorManagedBean() {
    }
    
     //VARIABLE DE TIPO LISTACARGOS
    private List<Proveedor> listaProveedores;
    
    //ESTO ES CUADNO QUIERO AGREGAR O EDITAR UN CARGO
    private Proveedor proveedor;
   
    @PostConstruct
    public void init(){
        
        //lista de los cargos que estan en la BDD
        //AQUI EL CARGO EN LA LISTA
        listaProveedores = proveedorFacadeLocal.findAll();
        
    }

    @Override
    public void nuevo() {
        proveedor = new Proveedor();
    }

    @Override
    public void grabar() {
        try{
           //CON ESTO COMPRUEBA SI ES PARA CREAR O ES PARA EDITAR
           if(proveedor.getCodigo() == null){
               proveedorFacadeLocal.create(proveedor);
           }else{
               proveedorFacadeLocal.edit(proveedor);
           }
           //SI YA SE GUARDO O SE EDITO
           //LA CLASE SE PONE EN NULL
           //LUEGO SE DEBE LISTAR
           proveedor = null;
           listaProveedores = proveedorFacadeLocal.findAll();
           //LUEGO UN MENSAJE
           mostrarMensajeTry("INFORMACIÓN EXITOSA", FacesMessage.SEVERITY_INFO);
       }catch(Exception e){
           mostrarMensajeTry("OCURRIO UN ERROR", FacesMessage.SEVERITY_ERROR);
       }
    }

    @Override
    public void seleccionar(Proveedor p) {
        proveedor = p;
    }

    @Override
    public void eliminar(Proveedor p) {
        try{
            //ELIMINO EL EMPLEADO
            proveedorFacadeLocal.remove(p);
            //LUEGO LISTO LOS EMPLEADOS
            listaProveedores = proveedorFacadeLocal.findAll();
            mostrarMensajeTry("ELIMINADO EXITOSAMENTE", FacesMessage.SEVERITY_INFO);
        }catch(Exception e){
            mostrarMensajeTry("OCURRIO UN ERROR", FacesMessage.SEVERITY_ERROR);
        }
    }

    @Override
    public void cancelar() {
        proveedor = null;
    }

    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(List<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
}
