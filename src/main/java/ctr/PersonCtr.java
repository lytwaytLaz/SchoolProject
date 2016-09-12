package ctr;

import jpa.Role;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-06
 */
public class PersonCtr
{
    private Long person_id;
    private String firstName;
    private String lastName;
    private String email;
    private String passWord;
    private Role role;
    private Long role_id;

    public PersonCtr(String firstName, String lastName, String email, String passWord, Role role)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passWord = passWord;
        this.role = role;

    }

    public PersonCtr(String firstName, String lastName, String email, String passWord, Long role_id)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passWord = passWord;
        this.role_id = role_id;
    }

    public PersonCtr(Long person_id, String firstName, String lastName, String email, String passWord, Role role)
    {
        this.person_id = person_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passWord = passWord;
        this.role = role;
    }





    public Long getPerson_id()
    {
        return person_id;
    }

    public void setPerson_id(Long person_id)
    {
        this.person_id = person_id;
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

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
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
