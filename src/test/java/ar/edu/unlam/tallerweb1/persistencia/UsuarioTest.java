package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


public class UsuarioTest extends SpringTest {

    @Test
    @Transactional
    @Rollback
    public void crearUsuarioYBuscarloPorId() {
        // TODO
        Usuario cristian = new Usuario();

        assertThat(cristian).isNotNull();
    }
}
