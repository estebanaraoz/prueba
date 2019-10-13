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

public class CadeteTest extends SpringTest {

    @Autowired
    private CadeteDao dao;

    @Autowired
    private PaqueteDao pdao;

    @Test
    @Transactional
    @Rollback
    public void testQueVerificaLaCreacionDeCadete() {
        // Preparar
        Cadete cadeteA = new Cadete();
        cadeteA.setDni(12345678);
        cadeteA.setNombre("Nombre");
        cadeteA.setApellido("Apellido");
        cadeteA.setEmail("correo@correo.com");
        cadeteA.setDomicilio("Domicilio 123");
        cadeteA.setTipoDeTransporte("Moto");

        // Actuar
        dao.altaCadete(cadeteA);

        // Assert
        assertThat(cadeteA).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    public void testQueBuscaCadetePorTipoDeTransporte() {
        // Preparar
        Cadete cadeteA = new Cadete();
        cadeteA.setTipoDeTransporte("Moto");
        dao.altaCadete(cadeteA);

        Cadete cadeteB = new Cadete();
        cadeteB.setTipoDeTransporte("Auto");
        dao.altaCadete(cadeteB);

        Cadete cadeteC = new Cadete();
        cadeteC.setTipoDeTransporte("Moto");
        dao.altaCadete(cadeteC);

        // Actuar
        List<Cadete> buscados = dao.buscarPorTipoDeTransporte("Moto");

        // Assert
        assertThat(buscados).hasSize(2);
    }

    @Test
    @Transactional
    @Rollback
    public void testQueBuscaCadetesConDeterminadosTiposDeTransporte() {
        // Prepare
        Cadete cadeteA = new Cadete();
        cadeteA.setTipoDeTransporte("Bicicleta");
        dao.altaCadete(cadeteA);

        Cadete cadeteB = new Cadete();
        cadeteB.setTipoDeTransporte("Moto");
        dao.altaCadete(cadeteB);

        Cadete cadeteC = new Cadete();
        cadeteC.setTipoDeTransporte("Auto");
        dao.altaCadete(cadeteC);

        // Actuar
        List<Cadete> buscados = dao.buscarPorTiposDeTransportes("Auto", "Moto");

        // Assert
        assertThat(buscados).contains(cadeteB, cadeteC);
    }

    @Test
    @Transactional
    @Rollback
    public void testQueBuscaListaDePaquetesDeUnDeterminadoCadete() {
        // Preparar
        Cadete cadeteA = new Cadete();
        dao.altaCadete(cadeteA);

        Paquete paqueteA = new Paquete();
        paqueteA.setCadete(cadeteA);
        pdao.guardar(paqueteA);

        Paquete paqueteB = new Paquete();
        paqueteB.setCadete(cadeteA);
        pdao.guardar(paqueteB);

        Paquete paqueteC = new Paquete();
        paqueteC.setCadete(cadeteA);
        pdao.guardar(paqueteC);

        // Actuar
        List<Paquete> lista = dao.buscarListaDePaquetesPorCadete(cadeteA);

        // Assert
        assertThat(lista).hasSize(3);
    }
}
