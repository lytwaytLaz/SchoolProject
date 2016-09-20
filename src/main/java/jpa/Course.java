package jpa;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-06
 */

@Entity
@NamedQueries({
        @NamedQuery(
                name = "selectAllCourses",
                query = "SELECT c FROM Course c ORDER BY c.courseName"),
        @NamedQuery(
                name = "selectCourseName",
                query = "SELECT c FROM Course c WHERE c.courseName LIKE :courseName")})

public class Course
{
    @OneToMany(mappedBy = "course", orphanRemoval=true)
    private List<Registration> registration;

    @OneToMany(mappedBy = "course", orphanRemoval=true)
    private List<Lecture> lecture;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long course_id;

    @Column(unique = true, nullable = false)
    @Size(min = 3)
    private String courseName;

    public Course(String courseName)
    {
        this.courseName = courseName;
    }

    public Course()
    {
    }

    public Long getCourse_id()
    {
        return course_id;
    }

    public void setCourse_id(Long id)
    {
        this.course_id = id;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

}
