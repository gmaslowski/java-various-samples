package com.gmaslowski.sample.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

import static javax.persistence.GenerationType.AUTO;

@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> {

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = AUTO)
    protected ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

}