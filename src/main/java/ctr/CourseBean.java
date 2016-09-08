package ctr;

import ejb.CourseEjb;
import ejb.PersonEjb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-08
 */

@Named
@RequestScoped
public class CourseBean

{
    private Long courseBeanId;
    private String courseBeanName;

    @Inject
    private CourseEjb courseEjb;


    public String submit()
    {

        courseEjb.addCourse(new CourseCtr(getCourseBeanName()));
        setCourseBeanName("");

        return  "course?faces-redirect=true";
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
}
