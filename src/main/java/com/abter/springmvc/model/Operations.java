package com.abter.springmvc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "operations", catalog = "test", uniqueConstraints = @UniqueConstraint(columnNames = "oper_code"))
public class Operations implements Serializable{
    private Integer operId;
    private String operCode;
    private String operName;

    public Operations() {
    }

    public Operations(String operCode, String operName) {
        this.operCode = operCode;
        this.operName = operName;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oper_id", unique = true, nullable = false)
    public Integer getOperId() {
        return operId;
    }

    public void setOperId(Integer operId) {
        this.operId = operId;
    }
    @Column(name = "oper_code", unique = true, nullable = false)
    public String getOperCode() {
        return operCode;
    }

    public void setOperCode(String operCode) {
        this.operCode = operCode;
    }
    @Column(name = "oper_name", nullable = false)
    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }
}
