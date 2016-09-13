package jpa;

import javax.persistence.*;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-06
 */

@Entity
public class Registration
{
    @ManyToOne
    private Course course;

    @ManyToOne
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long registration_id;

    public Long getRegistration_id()
    {
        return registration_id;
    }

    public void setRegistration_id(Long id)
    {
        this.registration_id = id;
    }


}
