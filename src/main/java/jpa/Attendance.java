package jpa;

import javax.persistence.*;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-06
 */
@Entity
@Table(
        name="Attendance",
        uniqueConstraints = @UniqueConstraint(columnNames ={ "LECTURE_LECTURE_ID", "PERSON_PERSON_ID"})
)
@NamedQueries({
        @NamedQuery(
                name = "selectAllAttendance",
                query = "SELECT a from Attendance a"),
        @NamedQuery(
                name = "selectAllStudents",
                query = "SELECT p FROM Person p JOIN Registration r ON p.person_id=r.person.person_id WHERE p.role.role_id = ?1"),
        @NamedQuery(
                name = "selectAllStudentsByCourse",
                query = "SELECT p FROM Person p JOIN Registration r ON p.person_id=r.person.person_id WHERE p.role.role_id = ?1 AND r.course.course_id = ?2"),
//        @NamedQuery(
//                name = "selectAllStudentsByCourseAndLecture",
//                query = "SELECT p FROM Person p JOIN Lecture lec ON (SELECT p FROM Person p JOIN Registration r ON p.person_id=r.person.person_id WHERE p.role.role_id = ?1 AND r.course.course_id = ?2)=lec.course.course_id WHERE lec.lecture_id "),
        @NamedQuery(
                name = "selectAllStudentsByCourseAndLecture",
                query = "SELECT p FROM Person p JOIN Registration r ON p.person_id=r.person.person_id " +
                        "JOIN Lecture lec ON r.course.course_id = lec.course.course_id " +
                        "WHERE p.role.role_id = ?1 AND r.course.course_id = ?2  AND lec.lecture_id = ?3")
})

public class Attendance
{
    @ManyToOne(cascade = CascadeType.MERGE)
    private Person person;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Lecture lecture;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attendence_id;

    private Boolean present;

    public Attendance()
    {
    }

    public Attendance(Person person, Lecture lecture, Boolean present)
    {
        this.person = person;
        this.lecture = lecture;
        this.present = present;
    }

    public Long getAttendence_id()
    {
        return attendence_id;
    }

    public void setAttendence_id(Long id)
    {
        this.attendence_id = id;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }
}
