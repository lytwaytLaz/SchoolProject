package ctr;

import ejb.PersonEjb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-07
 */
@Named
@RequestScoped
public class PersonBean
{
    private String firstName;
    private String lastName;
    private String email;
    private String passWord;
    private int role;

    @Inject
    private PersonEjb pers;

    public String submit()
    {
        System.out.println("submit");
        pers.addPerson(new PersonCtr(getFirstName(), getLastName(), getEmail(), getPassWord(), getRole()));
        setFirstName("");
        setLastName("");
        setEmail("");
        setPassWord("");
        setRole(0);

        return "login?faces-redirect=true";
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

    public int getRole()
    {
        return role;
    }

    public void setRole(int role)
    {
        this.role = role;
    }
}