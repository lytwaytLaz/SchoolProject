package jpa;

import javax.persistence.*;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-06
 */

@Entity
@Table(
        name = "Registration",
        uniqueConstraints = @UniqueConstraint(columnNames = {"course_course_id", "person_person_id"})
)
@NamedQueries({
        @NamedQuery(
                name = "selectAllRegistrations",
                query = "SELECT r from Registration r")
})

public class Registration
{
    @ManyToOne(cascade = CascadeType.MERGE)
    private Course course;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long registration_id;

    public Registration(Course course, Person person)
    {
        this.course = course;
        this.person = person;
    }

    public Registration()
    {
    }

    public Long getRegistration_id()
    {
        return registration_id;
    }

    public void setRegistration_id(Long id)
    {
        this.registration_id = id;
    }

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
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
