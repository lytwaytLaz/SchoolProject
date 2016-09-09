package ctr;

import jpa.Teacher;

/**
 * Created by Yukie on 2016-09-07.
 */
public class CourseCtr {

    private Long id;
    private String courseCtrName;
    private Teacher teacher;

    public CourseCtr(String courseCtrName) {
        this.courseCtrName = courseCtrName;
    }

    public CourseCtr(Long id, String courseCtrName) {
        this.id = id;
        this.courseCtrName = courseCtrName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseCtrName() {
        return courseCtrName;
    }

    public void setCourseCtrName(String courseCtrName) {
        this.courseCtrName = courseCtrName;
    }

    public Teacher getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }
}
