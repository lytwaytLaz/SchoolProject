package ctr;

/**
 * Created by Yukie on 2016-09-07.
 */
public class CourseCtr {

    private Long id;
    private String courseName;

    public CourseCtr(String courseName) {
        this.courseName = courseName;
    }

    public CourseCtr(Long id, String courseName) {
        this.id = id;
        this.courseName = courseName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
