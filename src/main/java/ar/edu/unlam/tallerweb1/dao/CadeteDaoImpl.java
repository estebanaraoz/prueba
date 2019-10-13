package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Cadete;
import ar.edu.unlam.tallerweb1.modelo.Paquete;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository("cadeteDao")
public class CadeteDaoImpl implements CadeteDao {

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public void altaCadete(Cadete cadete) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(cadete);
    }

    @Override
    public boolean existeCadete(String email) {
        final Session session = sessionFactory.getCurrentSession();
        boolean cadeteExiste = false;
        Cadete cadete = (Cadete) session.createCriteria(Cadete.class)
                .add(Restrictions.eq("email", email))
                .uniqueResult();

        if (cadete != null) {
            cadeteExiste = true;
        }

        return cadeteExiste;
    }

    public List<Cadete> buscarPorTipoDeTransporte(String transporte) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Cadete>) session.createCriteria(Cadete.class)
                .add(Restrictions.eq("tipoDeTransporte", transporte))
                .list();
    }

    @Override
    public List<Cadete> buscarPorTiposDeTransportes(String a, String b) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Cadete>) session.createCriteria(Cadete.class)
                .add(Restrictions.disjunction()
                        .add(Restrictions.eq("tipoDeTransporte", a))
                        .add(Restrictions.eq("tipoDeTransporte", b)))
                .list();
    }

    @Override
    public List<Paquete> buscarListaDePaquetesPorCadete(Cadete cadete) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Paquete>) session.createCriteria(Paquete.class)
                .add(Restrictions.eq("cadete", cadete))
                .list();
    }
}
