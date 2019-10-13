package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.PaqueteDao;
import ar.edu.unlam.tallerweb1.modelo.Cadete;
import ar.edu.unlam.tallerweb1.modelo.Paquete;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service("servicioPaquete")
@Transactional
public class ServicioPaqueteImpl implements ServicioPaquete {

    @Inject
    private PaqueteDao servicioPaqueteDao;


    @Override
    public void guardar(Paquete paquete) {
        servicioPaqueteDao.guardar(paquete);
    }

    @Override
    public void eliminar(Paquete paquete) {
        servicioPaqueteDao.eliminar(paquete);
    }

    @Override
    public List<Paquete> buscarPorDireccion(String string) {
        return servicioPaqueteDao.buscarPorDireccion(string);
    }

    @Override
    public List<Paquete> buscarPorCadete(Cadete cadete) {
        return servicioPaqueteDao.buscarPorCadete(cadete);
    }

    @Override
    public List<Paquete> buscarPaquetesPorCadeteYRemitenteDeterminados(Cadete cadete, Integer integer) {
        return servicioPaqueteDao.buscarPaquetesPorCadeteYRemitenteDeterminados(cadete, integer);
    }

    @Override
    public List<Paquete> retornarListaDePaquetes() {
        return servicioPaqueteDao.retornarListaDePaquetes();
    }
}
