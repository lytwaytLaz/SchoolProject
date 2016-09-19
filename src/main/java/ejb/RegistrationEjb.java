package ejb;

import ctr.RegistrationCtr;
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

    public void addRegistration(RegistrationCtr r)
    {
        Registration registrationTbl;
        if (r.getRegistration_id() == null)
            registrationTbl = new Registration();
        else
            registrationTbl = em.find(Registration.class, r.getRegistration_id());

        Course course = em.find(Course.class, r.getCourse_id());
        Person person = em.find(Person.class, r.getPerson_id());
        registrationTbl.setCourse(course);
        registrationTbl.setPerson(person);


        em.merge(registrationTbl);
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
