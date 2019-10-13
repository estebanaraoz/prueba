package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Cadete;
import ar.edu.unlam.tallerweb1.modelo.Paquete;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository("paqueteDao")
public class PaqueteDaoImpl implements PaqueteDao {

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public void guardar(Paquete paquete) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(paquete);
    }

    @Override
    public void eliminar(Paquete paquete) {
        final Session session = sessionFactory.getCurrentSession();
        session.delete(paquete);
    }

    @Override
    public List<Paquete> buscarPorDireccion(String direccion) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Paquete>) session.createCriteria(Paquete.class)
                .add(Restrictions.eq("direccion", direccion))
                .list();
    }

    @Override
    public List<Paquete> buscarPorCadete(Cadete cadete) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Paquete>) session.createCriteria(Paquete.class)
                .add(Restrictions.eq("cadete", cadete))
                .list();
    }

    @Override
    public List<Paquete> buscarPaquetesPorCadeteYRemitenteDeterminados(Cadete cadete, Integer remitente) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Paquete>) session.createCriteria(Paquete.class)
                .add(Restrictions.eq("cadete", cadete))
                .add(Restrictions.eq("remitenteId", remitente))
                .list();
    }

    @Override
    public List<Paquete> retornarListaDePaquetes() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Paquete>) session.createCriteria(Paquete.class)
                .list();
    }
}
