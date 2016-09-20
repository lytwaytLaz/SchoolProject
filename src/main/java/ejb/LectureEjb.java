package ejb;

import ctr.LectureCtr;
import jpa.Course;
import jpa.Lecture;

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
public class LectureEjb

{
    @PersistenceContext
    private EntityManager em;

    public void addLecture(LectureCtr l)
    {
        Lecture lectureTbl = new Lecture();

        lectureTbl.setDate(l.getLectureCtrDate());

        Course course = em.find(Course.class, l.getCourse_id());
        lectureTbl.setCourse(course);

        em.persist(lectureTbl);
    }

    public List<Lecture> getLectures()
    {
        List<Lecture> lectures;
        lectures = em.createNamedQuery(
                "selectAllLectures")
                .getResultList();
        return lectures;
    }




}
