package ejb;

import jpa.Attendance;
import jpa.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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

    public void addAttendance(Attendance a)
    {

        em.persist(a);
    }

    public void markAttendance(Long attendance_id)
    {
        Attendance a = em.find(Attendance.class, attendance_id);
        a.setPresent(!a.isPresent());
        em.merge(a);
    }

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

    public List<Attendance> getStudentsByAttendance(Long role_id, Long lecture_id)
    {
        List<Attendance> attListBylecture;
        attListBylecture = em.createNamedQuery(
                "selectStudentsByAttendance")
                .getResultList();
        return attListBylecture;
    }

    public List<Person> getStudentsByLecture(Long role_id, Long course_id, Long lecture_id)
    {
        List<Person> persons;
        persons = em.createNamedQuery(
                "selectAllStudentsByLecture", Person.class)
                .setParameter(1, role_id)
                .setParameter(2, course_id)
                .setParameter(3, lecture_id)
                .getResultList();
        return persons;

    }

}
