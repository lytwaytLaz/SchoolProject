package ejb;

import jpa.Course;
import jpa.Person;
import jpa.Registration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-13
 */
@Stateless
public class RegistrationEjb
{
    @PersistenceContext
    private EntityManager em;

    public void addRegistration(Registration r)
    {

//        Course course = em.find(Course.class, r.getCourse().getCourse_id());
//        Person person = em.find(Person.class, r.getPerson().getPerson_id());
        r.setCourse(em.find(Course.class, r.getCourse().getCourse_id()));
        r.setPerson(em.find(Person.class, r.getPerson().getPerson_id()));

        em.persist(r);
    }



    public List<Registration> getRegistration()
    {
        List<Registration> registrations;
        registrations = em.createNamedQuery(
                "selectAllRegistrations")
                .getResultList();
        return registrations;

    }

}
