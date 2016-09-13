package ctr;

import ejb.PersonEjb;
import jpa.Role;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-07
 */
@Named
@SessionScoped
public class PersonBean implements Serializable
{
    private String firstName;
    private String lastName;
    private String email;
    private String passWord;
    private Role role;
    private Long role_id;
    private String fullName;

    @Inject
    private PersonEjb pers;

    public String submit()
    {
        pers.addPerson(new PersonCtr(getFirstName(), getLastName(), getEmail(), getPassWord(), getRole_id()));
        setFirstName("");
        setLastName("");
        setEmail("");
        setPassWord("");

        return "person?faces-redirect=true";
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
        fullName = getFirstName() + " " + getLastName();

        return fullName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassWord()
    {
        return passWord;
    }

    public void setPassWord(String passWord)
    {
        this.passWord = passWord;
    }


    public void setRole(Role role)
    {
        this.role = role;
    }


    public Role getRole()
    {

        return role;
    }

    public Long getRole_id()
    {
        return role_id;
    }

    public void setRole_id(Long role_id)
    {
        this.role_id = role_id;
    }


}