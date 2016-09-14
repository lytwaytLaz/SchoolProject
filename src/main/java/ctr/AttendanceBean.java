package ctr;

import ejb.AttendanceEjb;
import ejb.RoleEjb;
import jpa.Attendance;
import jpa.Person;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-14
 */
@Named
@SessionScoped
public class AttendanceBean implements Serializable
{
    private Long person_id;
    private Long lecture_id;
    private Boolean present;
    private List<Person> studentsByCourse;
    private String type = "Student";

    @Inject
    private AttendanceEjb att;

    @Inject
    private RoleEjb roleEjb;

    public String check()
    {
        att.getPersonsByRole(roleEjb.getRoleIdByType(roleEjb.getRoles(), type));

        return "attendance?faces-redirect=true";
    }

}
