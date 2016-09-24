package ejb;

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

    public Long getCourse_id(Long lecture_id)
    {
        for(Lecture lecture: getLectures())
        {
            if(lecture.getLecture_id() == lecture_id)
                return lecture.getCourse().getCourse_id();
        }
        return null;
    }

    public void addLecture(Lecture l)
    {

        l.setCourse(em.find(Course.class, l.getCourse().getCourse_id()));

        em.persist(l);
    }

    public List<Lecture> getLectures()
    {
        List<Lecture> lectures;
        lectures = em.createNamedQuery(
                "selectAllLectures")
                .getResultList();
        return lectures;
    }

    public List<Lecture> getLecturesByCourse(Long course_id)
    {
        List<Lecture> lecturesByCourse;
        lecturesByCourse = em.createNamedQuery(
                "selectLecturesByCourse", Lecture.class)
                .setParameter(1, course_id)
                .getResultList();
        return lecturesByCourse;
    }




}
