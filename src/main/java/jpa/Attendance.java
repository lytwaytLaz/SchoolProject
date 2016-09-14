package jpa;

import javax.persistence.*;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-06
 */
@Entity
@NamedQueries({
        @NamedQuery(
                name = "selectAllAttendance",
                query = "SELECT a from Attendance a"),
        @NamedQuery(
                name = "selectAllPersonsByRoleId",
                query = "SELECT p FROM Person p JOIN Registration r ON p.person_id=r.person.person_id WHERE p.role.role_id = ?1")
})
public class Attendance
{
    @ManyToOne
    private Person person;

    @ManyToOne
    private Lecture lecture;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attendence_id;

    private Boolean present;

    public Long getAttendence_id()
    {
        return attendence_id;
    }

    public void setAttendence_id(Long id)
    {
        this.attendence_id = id;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }
}
