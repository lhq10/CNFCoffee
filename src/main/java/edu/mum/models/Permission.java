package edu.mum.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "permission")
public class Permission {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "permission")
    private Set<Permission_Action> permission_action ;

    @OneToMany(mappedBy = "permission")
    private Set<User_Permission> permission_user ;

    public Permission() {
        super();
    }

    public Permission(int id, String name, Set<Permission_Action> permission_action, Set<User_Permission> permission_user) {
        super();
        this.id = id;
        this.name = name;
        this.permission_action = permission_action;
        this.permission_user = permission_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Permission_Action> getPermission_action() {
        return permission_action;
    }

    public void setPermission_action(Set<Permission_Action> permission_action) {
        this.permission_action = permission_action;
    }

    public Set<User_Permission> getPermission_user() {
        return permission_user;
    }

    public void setPermission_user(Set<User_Permission> permission_user) {
        this.permission_user = permission_user;
    }
}
