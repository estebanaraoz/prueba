package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.dao.CadeteDao;
import ar.edu.unlam.tallerweb1.dao.PaqueteDao;
import ar.edu.unlam.tallerweb1.modelo.Cadete;
import ar.edu.unlam.tallerweb1.modelo.Paquete;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PaqueteTest extends SpringTest {

    @Autowired
    private PaqueteDao dao;

    @Autowired
    private CadeteDao cdao;

    @Test
    @Transactional
    @Rollback
    public void testQueVerificaLaCreacionDelPaquete() {
        // Preparar
        Cadete cadeteA = new Cadete();

        cdao.altaCadete(cadeteA);

        Paquete paqueteA = new Paquete();
        paqueteA.setDireccion("Direccion A");
        paqueteA.setCodPostal(1234);
        paqueteA.setDestinatario("DestinatarioA");
        paqueteA.setRemitenteId(2);
        paqueteA.setCadete(cadeteA);
        paqueteA.setCodSeguimiento("123ABC");
        paqueteA.setCategoria("CategoriaA");
        paqueteA.setMedioDeTransporte("Bicicleta");

        // Actuar
        dao.guardar(paqueteA);

        // Assert
        assertThat(paqueteA).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    public void testQueBuscaPaquetesALaMismaDireccion() {
        // Preparar
        Paquete paqueteA = new Paquete();
        paqueteA.setDireccion("Direccion A");
        dao.guardar(paqueteA);

        Paquete paqueteB = new Paquete();
        paqueteB.setDireccion("Direccion B");
        dao.guardar(paqueteB);

        Paquete paqueteC = new Paquete();
        paqueteC.setDireccion("Direccion A");
        dao.guardar(paqueteC);

        // Assert
        List<Paquete> buscados = dao.buscarPorDireccion("Direccion A");

        // Actuar
        assertThat(buscados).hasSize(2);
    }

    @Test
    @Transactional
    @Rollback
    public void testQueBuscaTodosLosPaquetesHechosPorUnMismoCadete() {
        // Preparar
        Cadete cadeteA = new Cadete();
        cdao.altaCadete(cadeteA);
      
        Cadete cadeteB = new Cadete();
        cdao.altaCadete(cadeteB);

        Paquete paqueteA = new Paquete();
        paqueteA.setCadete(cadeteA);
        dao.guardar(paqueteA);

        Paquete paqueteB = new Paquete();
        paqueteB.setCadete(cadeteB);
        dao.guardar(paqueteB);

        Paquete paqueteC = new Paquete();
        paqueteC.setCadete(cadeteA);
        dao.guardar(paqueteC);

        // Actuar
        List<Paquete> buscados = dao.buscarPorCadete(cadeteA);

        // Assert
        assertThat(buscados).hasSize(2);
    }

    @Test
    @Transactional
    @Rollback
    public void testQueBuscaTodosLosPaquetesRealizadosPorDeterminadosCadeteYRemitente() {
        // Preparar
        Cadete cadeteA = new Cadete();
        cdao.altaCadete(cadeteA);

        Cadete cadeteB = new Cadete();
        cdao.altaCadete(cadeteB);

        Paquete paqueteA = new Paquete();
        paqueteA.setCadete(cadeteA);
        paqueteA.setRemitenteId(2);
        dao.guardar(paqueteA);

        Paquete paqueteB = new Paquete();
        paqueteB.setCadete(cadeteB);
        paqueteB.setRemitenteId(45);
        dao.guardar(paqueteB);

        Paquete paqueteC = new Paquete();
        paqueteC.setCadete(cadeteA);
        paqueteC.setRemitenteId(2);
        dao.guardar(paqueteC);

        // Act
        List<Paquete> buscados = dao.buscarPaquetesPorCadeteYRemitenteDeterminados(cadeteA, 2);

        // Assert
        assertThat(buscados).hasSize(2);
    }

    @Test
    @Transactional
    @Rollback
    public void testQueVerificaEliminacionDeUnPaquete() {
        // Preparar
        Paquete paqueteA = new Paquete();
        paqueteA.setDireccion("Direccion A");
        paqueteA.setCodPostal(1234);
        paqueteA.setDestinatario("DestinatarioA");
        paqueteA.setRemitenteId(2);
        paqueteA.setCodSeguimiento("123ABC");
        paqueteA.setCategoria("CategoriaA");
        paqueteA.setMedioDeTransporte("Bicicleta");

        // Actuar
        dao.guardar(paqueteA);
        dao.eliminar(paqueteA);

        // Assert
        List<Paquete> listaDePaquetes = dao.retornarListaDePaquetes();
        assertThat(listaDePaquetes).doesNotContain(paqueteA);
    }
}
