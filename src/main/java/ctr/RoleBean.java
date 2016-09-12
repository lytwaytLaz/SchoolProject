package ctr;

import ejb.RoleEjb;
import jpa.Role;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-10
 */
@Named
@SessionScoped
public class RoleBean implements Serializable
{
    private Long role_id;
    private String type;
    private List<Role> roles;
    private Map<String, Object> roleMap;

    @Inject
    private RoleEjb roleEjb;

    public List<Role> getRoles()
    {
        roles = roleEjb.getRoles();
        System.out.println("Roles passed on: "+roles);
        return roles;
    }

    public Map<String, Object> getRoleMap()
    {

        for (Role role: roleEjb.getRoles())
        {
            roleMap.put(role.getType(), role);
        }
        return roleMap;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Long getRole_id()
    {
        return role_id;
    }

    public void setRole_id(Long role_id)
    {
        this.role_id = role_id;
    }

//    public Long getRoleId()
//    {
//        for (Role currentRole: getRoles())
//        {
//            if (currentRole.getRole_id().equals(role_id))
//                role = currentRole;
//        }
//        return role_id;
//    }
}
