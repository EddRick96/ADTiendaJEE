package com.tienda.entidades;

import com.tienda.entidades.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-16T16:07:21")
@StaticMetamodel(EstadoCivil.class)
public class EstadoCivil_ { 

    public static volatile SingularAttribute<EstadoCivil, Integer> codigo;
    public static volatile ListAttribute<EstadoCivil, Empleado> empleadoList;
    public static volatile SingularAttribute<EstadoCivil, String> nombre;

}