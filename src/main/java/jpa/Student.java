package jpa;

import javax.persistence.*;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-06
 */
@Entity
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Person person;

    @ManyToOne
    private Attendance attendance;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    public Attendance getAttendance()
    {
        return attendance;
    }

    public void setAttendance(Attendance attendance)
    {
        this.attendance = attendance;
    }
}
