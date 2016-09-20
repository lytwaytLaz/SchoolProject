package ctr;

import ejb.RegistrationEjb;
import jpa.Course;
import jpa.Person;
import jpa.Registration;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-13
 */
@Named
@SessionScoped
public class RegistrationBean implements Serializable
{
    private Long person_id;
    private Long course_id;
    private String courseName;

    @Inject
    private RegistrationEjb reg;


    //TODO Fix addRegistration, something needs to be done about the construtor for Course and Person
    public String submit()
    {
        reg.addRegistration(
                        new Registration(new Course(),
                        new Person()));

        return "registration?faces-redirect=true";
    }


    public Long getPerson_id()
    {
        return person_id;
    }

    public void setPerson_id(Long person_id)
    {
        this.person_id = person_id;
    }

    public Long getCourse_id()
    {
        return course_id;
    }

    public void setCourse_id(Long course_id)
    {
        this.course_id = course_id;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }
}
