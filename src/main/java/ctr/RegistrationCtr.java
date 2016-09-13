package ctr;

import jpa.Course;
import jpa.Person;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-13
 */
public class RegistrationCtr
{
    private Long registration_id;
    private Person person;
    private Long person_id;
    private Course course;
    private Long course_id;

    public RegistrationCtr(Long course_id, Long person_id)
    {
        this.person_id = person_id;
        this.course_id = course_id;
    }

    public RegistrationCtr(Long registration_id, Long person_id, Long course_id)
    {
        this.registration_id = registration_id;
        this.person_id = person_id;
        this.course_id = course_id;
    }

    public RegistrationCtr(Long registration_id, Person person, Long person_id, Course course, Long course_id)
    {
        this.registration_id = registration_id;
        this.person = person;
        this.person_id = person_id;
        this.course = course;
        this.course_id = course_id;
    }

    public Long getRegistration_id()
    {
        return registration_id;
    }

    public void setRegistration_id(Long registration_id)
    {
        this.registration_id = registration_id;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    public Long getPerson_id()
    {
        return person_id;
    }

    public void setPerson_id(Long person_id)
    {
        this.person_id = person_id;
    }

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }

    public Long getCourse_id()
    {
        return course_id;
    }

    public void setCourse_id(Long course_id)
    {
        this.course_id = course_id;
    }
}
