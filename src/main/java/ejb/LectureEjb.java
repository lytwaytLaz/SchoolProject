package ejb;

import ctr.LectureCtr;
import jpa.Course;
import jpa.Lecture;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        System.out.println("add lecture");
        Lecture lectureTbl = new Lecture();
        System.out.println("Test 1: "+l.getLectureCtrDate());

        lectureTbl.setDate(l.getLectureCtrDate());
        System.out.println("Test 1:1: "+l.getCourse_id());

        Course course = em.find(Course.class, l.getCourse_id());
        System.out.println("Test 2: "+course.getCourse_id());
        lectureTbl.setCourse(course);

        em.persist(lectureTbl);
    }




}
