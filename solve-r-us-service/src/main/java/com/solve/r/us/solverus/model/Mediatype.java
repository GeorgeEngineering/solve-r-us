package com.solve.r.us.solverus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "mediatype")
public class Mediatype implements Serializable {
    private static final long serialVersionUID = 1009330051021837679L;
    @Id
    @Column(name = "mediatypeid", nullable = false)
    private Integer id;

    @Column(name = "name", length = 120)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}