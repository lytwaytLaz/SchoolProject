package ejb;

import ctr.PersonCtr;
import jpa.Person;
import jpa.Role;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-07
 */
@Stateless
public class PersonEjb
{
    @PersistenceContext
    private EntityManager em;




    public void addPerson(PersonCtr p)
    {
        Person personTbl = new Person();
        personTbl.setFirstName(p.getFirstName());
        personTbl.setLastName(p.getLastName());
        personTbl.setEmail(p.getEmail());
        personTbl.setPassWord(p.getPassWord());
        personTbl.setRole(p.getRole());

        em.persist(personTbl);
    }

    public List<Role> getRoles()
    {
        List<Role> roles;
        roles = em.createNamedQuery("selectAll").getResultList();
        return roles;
    }


    public List<Person> getPerson(String email)
    {
        List<Person> persons;
        persons = em.createNamedQuery("selectPerson").setParameter("filt",email).getResultList();
        return persons;
    }



    public void initializeRoles(){

        Role adminRole = new Role();
        adminRole.setRole("Admin");
        em.persist(adminRole);

        Role teacherRole = new Role();
        teacherRole.setRole("Teacher");
        em.persist(teacherRole);

        Role studentRole = new Role();
        studentRole.setRole("Student");
        em.persist(studentRole);





    }
}