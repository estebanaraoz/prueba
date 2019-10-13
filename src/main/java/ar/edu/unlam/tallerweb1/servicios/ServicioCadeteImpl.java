package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.CadeteDao;
import ar.edu.unlam.tallerweb1.modelo.Cadete;
import ar.edu.unlam.tallerweb1.modelo.Paquete;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service("servicioCadete")
@Transactional
public class ServicioCadeteImpl implements ServicioCadete {

    @Inject
    private CadeteDao servicioCadeteDao;

    @Override
    public void altaCadete(Cadete cadete) {
        servicioCadeteDao.altaCadete(cadete);
    }

    @Override
    public boolean existeCadete(String email) {
        return servicioCadeteDao.existeCadete(email);
    }

    @Override
    public List<Cadete> buscarPorTipoDeTransporte(String transporte) {
        return servicioCadeteDao.buscarPorTipoDeTransporte(transporte);
    }

    @Override
    public List<Cadete> buscarPorTiposDeTransportes(String a, String b) {
        return servicioCadeteDao.buscarPorTiposDeTransportes(a, b);
    }

    @Override
    public List<Paquete> buscarListaDePaquetes(Cadete cadete) {
        return servicioCadeteDao.buscarListaDePaquetesPorCadete(cadete);
    }
}
