package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Cadete;
import ar.edu.unlam.tallerweb1.modelo.Paquete;

import java.util.List;

public interface CadeteDao {

    void altaCadete(Cadete cadete);

    boolean existeCadete(String email);

    List<Cadete> buscarPorTipoDeTransporte(String transporte);

    // TODO: Cambiar nombres de variables cuando existan los transportes
    List<Cadete> buscarPorTiposDeTransportes(String a, String b);

    // TODO: Checkear si esta duplicado
    List<Paquete> buscarListaDePaquetesPorCadete(Cadete cadete);
}
