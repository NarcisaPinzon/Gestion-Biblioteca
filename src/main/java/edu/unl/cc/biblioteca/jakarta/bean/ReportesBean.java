package edu.unl.cc.biblioteca.jakarta.bean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Named("reportesBean")
@RequestScoped
public class ReportesBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, Long> datosReporte; // "Total Users": 100, "Active Loans": 50

    public ReportesBean() {
        this.datosReporte = new HashMap<>();
    }


    public String generarReporte() {
        System.out.println("Generando reporte de datos agregados...");


        long totalUsuarios = 150; // Ejemplo
        long prestamosActivos = 75; // Ejemplo
        long librosDisponibles = 500; // Ejemplo

        datosReporte.put("Total Usuarios", totalUsuarios);
        datosReporte.put("Préstamos Activos", prestamosActivos);
        datosReporte.put("Libros Disponibles", librosDisponibles);

        System.out.println("Reporte generado exitosamente.");
        return "mostrar_reporte.xhtml?faces-redirect=true";
    }

    public Map<String, Long> getDatosReporte() {
        return datosReporte;
    }


    // public void setDatosReporte(Map<String, Long> datosReporte) {
    //     this.datosReporte = datosReporte;
    // }
}

