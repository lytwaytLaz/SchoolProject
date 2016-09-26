package ejb;

import com.sun.org.apache.regexp.internal.RE;
import jpa.Course;
import jpa.Person;
import jpa.Registration;
import net.bootsfaces.render.R;

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
//TODO fix EJBException index out of range when registration does not exist
    public void removeRegistration(Long person_id, Long course_id)
    {
        Registration r = getRegistration(course_id, person_id);
        em.remove(r);
    }


    public Registration getRegistration(Long course_id, Long person_id)
    {
        List<Registration> registrations;
        registrations = em.createNamedQuery(
                "selectRegistration", Registration.class)
                .setParameter(1, course_id)
                .setParameter(2, person_id)
                .getResultList();
        return registrations.get(0);

    }

}
