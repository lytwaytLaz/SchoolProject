package ejb;

import ctr.AttendanceCtr;
import jpa.Attendance;
import jpa.Course;
import jpa.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-14
 */
@Stateless
public class AttendanceEjb
{
    @PersistenceContext
    private EntityManager em;

    public List<Person> getStudents(Long role_id)
    {
        List<Person> persons;
        persons = em.createNamedQuery(
                "selectAllStudents", Person.class)
                .setParameter(1, role_id)
                .getResultList();
        return persons;

    }

    public List<Person> getStudentsByCourse(Long role_id, Long course_id)
    {
        List<Person> persons;
        persons = em.createNamedQuery(
                "selectAllStudentsByCourse", Person.class)
                .setParameter(1, role_id)
                .setParameter(2, course_id)
                .getResultList();
        return persons;

    }

}
