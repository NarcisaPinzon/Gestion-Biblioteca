package edu.unl.cc.biblioteca.jakarta.manejo_perfiles;

import java.util.HashMap;
import java.util.Map;

public class Configuracion {
    private Map<String, Perfil> perfiles;

    public Configuracion() {
        this.perfiles = new HashMap<>();
    }

    public void crear(Perfil perfil) {
        perfiles.put(perfil.id, perfil);
    }

    public void eliminar(String id) {
        perfiles.remove(id);
    }

    public void editar(Perfil perfil) {
        perfiles.put(perfil.id, perfil);
    }

    public Perfil obtener(String id) {
        return perfiles.get(id);
    }

    // Getter de perfiles si lo necesitas
}

