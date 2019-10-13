package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl implements ServicioLogin {

    @Inject
    private UsuarioDao servicioLoginDao;

    @Override
    public Usuario consultarUsuario(Usuario usuario) {
        return servicioLoginDao.consultarUsuario(usuario);
    }

}
