package ctr;

import ejb.LoginEjb;
import jpa.Person;
import util.SchoolUtil;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-10
 */
@Named
@SessionScoped
public class LoginBean implements Serializable
{
    private String email;
    private String passWord;

    @Inject
    private LoginEjb login;

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

    public String login() {
        if(getEmail().trim().length() <0){
            SchoolUtil.addErrorMessage("person_email","e-mail can't be empty!");
        }
        if(getPassWord().trim().length() <0){
            SchoolUtil.addErrorMessage("person_password","password can't be empty!");
        }
        List<Person> persons = login.getPerson(getEmail());
        if(!persons.isEmpty()){
            Person person = persons.get(0);
            if(person.getPassWord().equals(passWord) && person.getRole().getRole_id() == 30)
                return "person?faces-redirect=true";
            else if(person.getPassWord().equals(passWord) && person.getRole().getRole_id() == 20)
            return "course?faces-redirect=true";
            else if(person.getPassWord().equals(passWord) && person.getRole().getRole_id() == 10)
                return "lecture?faces-redirect=true";
        }
        return "login?faces-redirect=true";
    }

    public void restorePassword(ActionEvent actionEvent) {
    }
}
