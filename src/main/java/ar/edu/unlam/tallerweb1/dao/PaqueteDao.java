package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Cadete;
import ar.edu.unlam.tallerweb1.modelo.Paquete;

import java.util.List;

public interface PaqueteDao {

    void guardar(Paquete paquete);

    void eliminar(Paquete paquete);

    List<Paquete> buscarPorDireccion(String direccion);

    // TODO: Checkear si esta duplicado
    List<Paquete> buscarPorCadete(Cadete cadete);

    List<Paquete> buscarPaquetesPorCadeteYRemitenteDeterminados(Cadete cadete, Integer remitente);

    List<Paquete> retornarListaDePaquetes();
}
