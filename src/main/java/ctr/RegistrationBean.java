package ctr;

import ejb.RegistrationEjb;

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
    private String firstName;
    private String lastName;

    @Inject
    private RegistrationEjb reg;

    public String submit()
    {
        reg.addRegistration(new RegistrationCtr(getCourse_id(), getPerson_id()));

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

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getFullName()
    {
        return getFirstName() + " " + getLastName();
    }
}
