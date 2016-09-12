package ejb;

import ctr.CourseCtr;
import jpa.Course;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-08
 */
@Stateless
public class CourseEjb
{
    @PersistenceContext
    private EntityManager em;

    public void addCourse(CourseCtr c)
    {
        Course courseTbl = new Course();
        courseTbl.setCourseName(c.getCourseCtrName());

        em.persist(courseTbl);
    }

    public List<Course> getCourses()
    {
        List<Course> courses;
        courses = em.createNamedQuery(
                "selectAllCourses")
                .getResultList();
        return courses;
    }
}
