package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cadete;
import ar.edu.unlam.tallerweb1.modelo.Paquete;

import java.util.List;

public interface ServicioPaquete {

    void guardar(Paquete paquete);

    void eliminar(Paquete paquete);

    List<Paquete> buscarPorDireccion(String string);

    List<Paquete> buscarPorCadete(Cadete cadete);

    List<Paquete> buscarPaquetesPorCadeteYRemitenteDeterminados(Cadete cadete, Integer integer);

    List<Paquete> retornarListaDePaquetes();
}
