package com.tienda.entidades;

import com.tienda.entidades.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-16T03:27:12")
@StaticMetamodel(Cargo.class)
public class Cargo_ { 

    public static volatile SingularAttribute<Cargo, Integer> codigo;
    public static volatile ListAttribute<Cargo, Empleado> empleadoList;
    public static volatile SingularAttribute<Cargo, String> nombre;

}