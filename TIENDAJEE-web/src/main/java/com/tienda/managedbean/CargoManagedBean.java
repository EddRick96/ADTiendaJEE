/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.managedbean;

import com.tienda.entidades.Cargo;
import com.tienda.session.CargoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

/**
 *
 * @author erick
 */
@Named(value = "cargoManagedBean")
@ViewScoped
public class CargoManagedBean implements Serializable, ManagedBeanInterface<Cargo>{

    //PASO 1: INSTANCIAR SESSIONBEAN DE CARGO
    @EJB
    private CargoFacadeLocal cargoFacadeLocal;
    
    //CONSTRUCTOR DE LA CLASE
    public CargoManagedBean() {
    }
    
    //VARIABLE DE TIPO LISTACARGOS
    private List<Cargo> listaCargos;
    
    //ESTO ES CUADNO QUIERO AGREGAR O EDITAR UN CARGO
    private Cargo cargo;
    
    //PASO 2: EL METODO ES PARA INICIALIZAR AL EmpleadoFacadeLocal
    @PostConstruct
    public void init(){
        
        //lista de los cargos que estan en la BDD
        //AQUI EL CARGO EN LA LISTA
        listaCargos = cargoFacadeLocal.findAll();
        
    }

    
    //LOS METODOS DE LA INTERFAZ GENERICA
    @Override
    public void nuevo() {
        cargo = new Cargo();
    }

    @Override
    public void grabar() {
       try{
           //CON ESTO COMPRUEBA SI ES PARA CREAR O ES PARA EDITAR
           if(cargo.getCodigo() == null){
               cargoFacadeLocal.create(cargo);
           }else{
               cargoFacadeLocal.edit(cargo);
           }
           //SI YA SE GUARDO O SE EDITO
           //LA CLASE SE PONE EN NULL
           //LUEGO SE DEBE LISTAR
           cargo = null;
           listaCargos = cargoFacadeLocal.findAll();
           //LUEGO UN MENSAJE
           mostrarMensajeTry("INFORMACIÓN EXITOSA", FacesMessage.SEVERITY_INFO);
       }catch(Exception e){
           mostrarMensajeTry("OCURRIO UN ERROR", FacesMessage.SEVERITY_ERROR);
       }
    }

    @Override
    public void seleccionar(Cargo c) {
        cargo = c;
    }

    @Override
    public void eliminar(Cargo c) {
        try{
            //ELIMINO EL EMPLEADO
            cargoFacadeLocal.remove(c);
            //LUEGO LISTO LOS EMPLEADOS
            listaCargos = cargoFacadeLocal.findAll();
            mostrarMensajeTry("ELIMINADO EXITOSAMENTE", FacesMessage.SEVERITY_INFO);
        }catch(Exception e){
            mostrarMensajeTry("OCURRIO UN ERROR", FacesMessage.SEVERITY_ERROR);
        }
    }

    @Override
    public void cancelar() {
        cargo = null;
    }

    public List<Cargo> getListaCargos() {
        return listaCargos;
    }

    public void setListaCargos(List<Cargo> listaCargos) {
        this.listaCargos = listaCargos;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
}
