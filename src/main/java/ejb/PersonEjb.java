package ejb;

import ctr.PersonCtr;
import jpa.Person;
import jpa.Role;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
        Role role = em.find(Role.class, p.getRole_id());
        personTbl.setRole(role);

        em.persist(personTbl);
    }

    public List<Person> getPerson(String email)
    {
        List<Person> persons;
        persons = em.createNamedQuery(
                "selectPerson")
                .setParameter("filt",email)
                .getResultList();
        return persons;
    }

    public List<Person> getPersonsNotAdmin ()
    {
        List<Person> persons;
        persons = em.createNamedQuery(
                "selectAllPersonsByRoleId")
//                .setParameter("filt",email)
                .getResultList();
        return persons;
    }

    public List<Person> getPersons()
    {
        List<Person> persons;
        persons = em.createNamedQuery(
                "selectAllPersons")
                .getResultList();
        return persons;
    }



//    public List<Person> getAll()
//    {
//        List<Person> person = em.createNamedQuery("selectPerson").getResultList();
//        return person.stream().map(m -> new PersonCtr(m.getPerson_id(), m.getFirstName(), m.getLastName(), m.getEmail(), m.getPassWord(), m.getRole())).collect(Collectors.toList());
//    }
}