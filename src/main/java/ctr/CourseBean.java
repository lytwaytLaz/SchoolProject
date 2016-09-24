package ctr;

import com.sun.istack.internal.NotNull;
import ejb.CourseEjb;
import jpa.Course;

import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-08
 */

@Named
@SessionScoped
public class CourseBean implements Serializable

{
    private Long courseBeanId;

    @NotNull
    private String courseBeanName;
    private List<Course> courses;

    @Inject
    private CourseEjb courseEjb;


    public String submit()
    {
        try {
            System.out.println("Course submit");
            courseEjb.addCourse(new Course(getCourseBeanName()));

        } catch (EJBException ejbe) {
            return "course?faces-redirect=true";
        }
        setCourseBeanName("");

        return "course?faces-redirect=true";
    }


    public String getCourseBeanName()
    {
        return courseBeanName;
    }

    public void setCourseBeanName(String courseBeanName)
    {
        this.courseBeanName = courseBeanName;
    }

    public void setCourseBeanId(Long courseBeanId)
    {
        this.courseBeanId = courseBeanId;
    }

    public Long getCourseBeanId()
    {
        return courseBeanId;
    }

    public List<Course> getCourses()
    {
        courses = courseEjb.getCourses();
//        System.out.println("Roles passed on: " + roles);
        return courses;
    }
}
