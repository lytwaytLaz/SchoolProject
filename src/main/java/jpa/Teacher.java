package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-09-06
 */
@Entity
public class Teacher
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
