package ctr;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-06
 */
public class PersonCtr
{
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String passWord;
    private int role;

    public PersonCtr(String firstName, String lastName, String email, String passWord, int role)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passWord = passWord;
        this.role = role;
    }

    public PersonCtr(Long id, String firstName, String lastName, String email, String passWord, int role)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passWord = passWord;
        this.role = role;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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
