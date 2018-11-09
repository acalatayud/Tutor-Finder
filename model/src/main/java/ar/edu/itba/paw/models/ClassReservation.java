package ar.edu.itba.paw.models;

import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_requests")
public class ClassReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_requests_id_seq")
    @SequenceGenerator(sequenceName = "course_requests_id_seq", name = "course_requests_id_seq",  allocationSize = 1)
    @Column(name = "id")
    private Long classRequestId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private User student;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Professor professor;


    @Column(nullable = false)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime startTime;

    @Column(nullable = false)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime endTime;

    //Status is 0 if approved, 1 if denied, 2 if yet undefined;
    @Column(name = "status", nullable = false)
    private Integer status;

    private String comment;

    ClassReservation(){}

    public ClassReservation(User student, Professor professor, LocalDateTime startTime,
                            LocalDateTime endTime, Integer status) {

        this.student    = student;
        this.professor  = professor;
        this.endTime    = endTime;
        this.startTime  = startTime;
        this.status     = status;
    }

    public ClassReservation confirm(String comment) {
        this.comment = comment;
        this.status = 0;
        return this;
    }

    public ClassReservation deny(String comment) {
        this.comment = comment;
        this.status = 2;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassReservation that = (ClassReservation) o;
        return Objects.equals(classRequestId, that.classRequestId) &&
                Objects.equals(student, that.student) &&
                Objects.equals(professor, that.professor) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(status, that.status) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classRequestId, student, professor, startTime, endTime, status, comment);
    }
}
