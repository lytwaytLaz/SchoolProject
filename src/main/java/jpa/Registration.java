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
                name = "selectAllCourses",
                query = "SELECT r from Course r"),
        @NamedQuery(
                name = "selectCourseName",
                query = "SELECT r FROM Course r WHERE r.courseName LIKE :courseName")})

public class Registration
{
    @ManyToOne
    private Course course;

    @ManyToOne
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long registration_id;

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
