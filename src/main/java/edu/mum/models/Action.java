package edu.mum.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "action")

public class Action {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titile")
    private String titile;

    @Column(name = "code")
    private String code;

    @Column(name = "feature")
    private String feature;

    @OneToMany(mappedBy = "action")
    private Set<Permission_Action> action_permission;

    public Action() {
        super();
    }

    public Action(int id, String titile, String code, String feature, Set<Permission_Action> action_permission) {
        super();
        this.id = id;
        this.titile = titile;
        this.code = code;
        this.feature = feature;
        this.action_permission = action_permission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Set<Permission_Action> getAction_permission() {
        return action_permission;
    }

    public void setAction_permission(Set<Permission_Action> action_permission) {
        this.action_permission = action_permission;
    }
}
