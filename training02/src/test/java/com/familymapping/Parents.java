package com.familymapping;

import javax.persistence.*;

@Entity
@Table(name = "parents")
public class Parents {

    @Id
    @Column(name = "parents_code")
    private int code;

    @Column(name = "parents_name")
    private String name;

    @ManyToOne
    @JoinTable(name = "Family_Mapping",
            joinColumns = @JoinColumn(name = "parents_code"), inverseJoinColumns = @JoinColumn(name = "child_code"))
    private Child child;
}
