package com.tienda.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public interface ManagedBeanInterface <T>{
    
    //DEFINIR LOS METODOS
    
    public void nuevo();
    
    public void grabar();
    
    public void seleccionar(T t);
    
    public void eliminar(T t);
    
    public void cancelar();
    
    
    default void mostrarMensajeTry(String mensaje, FacesMessage.Severity tipo){
        FacesMessage msg = new FacesMessage(tipo, mensaje, "");
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, msg);
    }
    
}
