package ctr;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-10
 */
public class RoleCtr
{
    private Long role_id;
    private String type;

    public RoleCtr(String type)
    {
        this.type = type;
    }

    public RoleCtr(Long role_id, String type)
    {
        this.role_id = role_id;
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
