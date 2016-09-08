package ejb;

import ctr.LectureCtr;
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
        Lecture lectureTbl = new Lecture();
        lectureTbl.setDate(l.getLectureCtrDate());
        lectureTbl.setCourse(l.getCourse());

        em.persist(lectureTbl);
    }




}
