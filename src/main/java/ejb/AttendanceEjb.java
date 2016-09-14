package ejb;

import ctr.AttendanceCtr;
import jpa.Attendance;
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
//    public void addAttendance(AttendanceCtr a)
//    {
//        Attendance attendanceTbl = new Attendance();
//
//        attendanceTbl.
//    }

//    public List<Person> getPersonsByRole(int roleId)
//    {
//        List<Person> persons;
//        persons = em.createNamedQuery(
//                "selectAllPersonsByRoleId")
//                .setParameter("r_id", roleId)
//                .getResultList();
//        return persons;
//
//    }

    public List<Person> getPersonsByRole(Long role_id)
    {
        List<Person> persons;
        persons = em.createNamedQuery(
                "selectAllPersonsByRoleId", Person.class)
                .setParameter(1, role_id)
                .getResultList();
        return persons;

    }

}
