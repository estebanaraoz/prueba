package ar.edu.unlam.tallerweb1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-applicationContext.xml"})
public abstract class SpringTest {

    @Inject
    private SessionFactory sessionFactory;

    protected Session session() {
        return this.sessionFactory.getCurrentSession();
    }
}
