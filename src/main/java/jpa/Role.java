package jpa;

import javax.persistence.*;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-07
 */
@Entity
@NamedQueries({
        @NamedQuery(
                name = "selectAll",
                query = "SELECT r from Role r"),
        @NamedQuery(
                name = "selectRoleId",
                query = "SELECT r FROM Role r WHERE r.type LIKE :type")

})
public class Role
{
    @Id
    private Long role_id;

    @Column(unique = true)
    private String type;

    public Long getRole_id()
    {
        return role_id;
    }

    public void setRole_id(Long id)
    {
        this.role_id = id;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String role)
    {
        this.type = role;
    }


}
