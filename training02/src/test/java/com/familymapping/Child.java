package com.familymapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Child {

    @Id
    @Column(name = "child_code")
    private int code;

    @Column(name = "child_name")
    private String name;
}
