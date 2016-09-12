package jpa;

import javax.persistence.*;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-06
 */
@Entity
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
