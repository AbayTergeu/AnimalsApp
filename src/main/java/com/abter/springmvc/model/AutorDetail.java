package com.abter.springmvc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "autoriz_detail", catalog = "test")
public class AutorDetail implements Serializable{
    private Integer autDetId;
    private Date dateStart;
    private Date dateEnd;
    private Integer cntAut;
    private Person person;

    public AutorDetail() {
    }

    public AutorDetail(Date dateStart, Date dateEnd, Integer cntAut, Person person) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.cntAut = cntAut;
        this.person = person;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aut_det_id", unique = true, nullable = false)
    public Integer getAutDetId() {
        return autDetId;
    }

    public void setAutDetId(Integer autDetId) {
        this.autDetId = autDetId;
    }
    @Temporal(TemporalType.DATE)
    @Column(name = "date_start", length = 10)
    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }
    @Temporal(TemporalType.DATE)
    @Column(name = "date_end", length = 10)
    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
    @Column(name = "cnt_aut")
    public Integer getCntAut() {
        return cntAut;
    }

    public void setCntAut(Integer cntAut) {
        this.cntAut = cntAut;
    }
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID", nullable = false)
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
