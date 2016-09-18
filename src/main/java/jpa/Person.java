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
                name = "selectAllPersons",
                query = "SELECT p from Person p"),

        @NamedQuery(
                name = "selectAllPersonsByRoleId",
                query = "SELECT p FROM Person p WHERE NOT (p.role.role_id = 30) ORDER BY p.firstName"),

        @NamedQuery(
                name = "selectPerson",
                query = "SELECT p from Person p where locate(:filt, p.email) > 0")
}
)

public class Person
{
    @ManyToOne
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long person_id;

    private String firstName;
    private String lastName;
    private String email;
    private String passWord;

    public Long getPerson_id()
    {
        return person_id;
    }

    public void setPerson_id(Long id)
    {
        this.person_id = id;
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

}
