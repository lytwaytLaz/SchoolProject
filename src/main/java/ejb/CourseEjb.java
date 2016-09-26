package ejb;

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

    public void addCourse(Course c)
    {
        em.persist(c);
    }

    public void removeCourse(Long course_id)
    {
        Course c = em.find(Course.class, course_id);
        em.remove(c);
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
