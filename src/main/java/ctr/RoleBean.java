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
    private List<Role> roles;

    @Inject
    private RoleEjb roleEjb;

    public List<Role> getRoles()
    {
        roles = roleEjb.getRoles();
        return roles;
    }
}
