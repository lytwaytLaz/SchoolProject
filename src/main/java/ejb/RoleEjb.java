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
        return roles;
    }

    public Long getRoleIdByType(List<Role> roles, String type)
    {
        for (Role role : roles) {
            if (type.equals(role.getType()))
                return role.getRole_id();
        }
        return 0L;
    }
}
