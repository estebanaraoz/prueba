package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cadete;
import ar.edu.unlam.tallerweb1.modelo.Paquete;

import java.util.List;

public interface ServicioCadete {

    void altaCadete(Cadete cadete);

    boolean existeCadete(String email);

    List<Cadete> buscarPorTipoDeTransporte(String transporte);

    // TODO: Cambiar nombres de variables cuando existan los transportes
    List<Cadete> buscarPorTiposDeTransportes(String a, String b);

    // TODO: Checkear si esta duplicado
    List<Paquete> buscarListaDePaquetes(Cadete cadete);
}
