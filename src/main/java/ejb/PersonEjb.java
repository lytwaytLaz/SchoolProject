package ejb;

import ctr.PersonCtr;
import jpa.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}