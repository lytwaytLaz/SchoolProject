package ejb;

import jpa.Role;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-10
 */
@Stateless
public class RoleEjb
{
    @PersistenceContext
    private EntityManager em;

    public List<Role> getRoles()
    {
        List<Role> roles;
        roles = em.createNamedQuery(
                "selectAll")
                .getResultList();
        System.out.println("Roles gotted: "+roles.toString());
        return roles;
//        for (Role role:roles)
//        {
//            if("admin".equals(role.getType()))
//                return role;
//        }
//        return null;
    }
}
