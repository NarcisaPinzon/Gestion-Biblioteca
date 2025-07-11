package edu.unl.cc.biblioteca.jakarta.bean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("configuracionBean")
@ApplicationScoped
public class ConfiguracionBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String temaAplicacion;
    private int elementosPorPagina;
    private boolean notificacionesActivadas;

    public ConfiguracionBean() {
        cargarConfiguracion();
    }


    public void cargarConfiguracion() {
        System.out.println("Cargando configuración de la aplicación...");
        this.temaAplicacion = "default";
        this.elementosPorPagina = 10;
        this.notificacionesActivadas = true;
    }


    public String guardarConfiguracion() {
        System.out.println("Guardando configuración...");
        System.out.println("Configuración guardada: Tema=" + temaAplicacion + ", Elementos/Pagina=" + elementosPorPagina);
        return null;
    }


    public String resetearConfiguracion() {
        System.out.println("Reseteando configuración a valores predeterminados...");
        this.temaAplicacion = "default";
        this.elementosPorPagina = 10;
        this.notificacionesActivadas = true;
        return null;
    }

    public String getTemaAplicacion() {
        return temaAplicacion;
    }

    public void setTemaAplicacion(String temaAplicacion) {
        this.temaAplicacion = temaAplicacion;
    }

    public int getElementosPorPagina() {
        return elementosPorPagina;
    }

    public void setElementosPorPagina(int elementosPorPagina) {
        this.elementosPorPagina = elementosPorPagina;
    }

    public boolean isNotificacionesActivadas() {
        return notificacionesActivadas;
    }

    public void setNotificacionesActivadas(boolean notificacionesActivadas) {
        this.notificacionesActivadas = notificacionesActivadas;
    }
}
