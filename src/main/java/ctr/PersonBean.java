package ctr;

import ejb.PersonEjb;
import jpa.Person;
import jpa.Role;
import util.SchoolUtil;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

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
    private Role role;

    private String roleName;
    private Long roleId;



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
//        setRole("");

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



    public void setRole(Role role)
    {
        this.role = role;
    }

    public String login() {
        if(getEmail().trim().length() <0){
            SchoolUtil.addErrorMessage("person_email","e-mail can't be empty!");
        }
        if(getPassWord().trim().length() <0){
            SchoolUtil.addErrorMessage("person_password","password can't be empty!");
        }
        List<Person> persons = pers.getPerson(getEmail());
        if(!persons.isEmpty()){
            Person person = persons.get(0);
            if(person.getPassWord().equals(passWord) && person.getRole().getRole().equalsIgnoreCase("admin"))
                return "register?faces-redirect=true";
        }
        return "login?faces-redirect=true";
    }

    public void restorePassword(ActionEvent actionEvent) {
    }

    public List<Role> getRoles(){

        List<Role> roles = new ArrayList<>();
        roles = pers.getRoles();
        return roles;
    }



    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    public Role getRole()
    {
        for (Role currentRole: getRoles())
        {
            if (currentRole.getId().equals(roleId))
                role = currentRole;
        }
        return role;
    }

//    public Long getRoleId()
//    {
//        return roleId;
//    }
//
//    public void setRoleId(Long roleId)
//    {
//        this.roleId = roleId;
//    }
}