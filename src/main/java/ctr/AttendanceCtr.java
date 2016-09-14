package ctr;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-14
 */
public class AttendanceCtr
{
    private Long attendance_id;
    private Long person_id;
    private Long lecture_id;
    private Boolean present;

    public AttendanceCtr(Long person_id, Long lecture_id, Boolean present)
    {
        this.person_id = person_id;
        this.lecture_id = lecture_id;
        this.present = present;
    }

    public AttendanceCtr(Long attendance_id, Long person_id, Long lecture_id, Boolean present)
    {
        this.attendance_id = attendance_id;
        this.person_id = person_id;
        this.lecture_id = lecture_id;
        this.present = present;
    }

    public Long getAttendance_id()
    {
        return attendance_id;
    }

    public void setAttendance_id(Long attendance_id)
    {
        this.attendance_id = attendance_id;
    }

    public Long getPerson_id()
    {
        return person_id;
    }

    public void setPerson_id(Long person_id)
    {
        this.person_id = person_id;
    }

    public Long getLecture_id()
    {
        return lecture_id;
    }

    public void setLecture_id(Long lecture_id)
    {
        this.lecture_id = lecture_id;
    }

    public Boolean getPresent()
    {
        return present;
    }

    public void setPresent(Boolean present)
    {
        this.present = present;
    }
}
