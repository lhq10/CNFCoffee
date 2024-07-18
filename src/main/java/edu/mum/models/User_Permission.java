package edu.mum.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_permission")
public class User_Permission {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "licensed")
    private boolean licensed;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "permissionId",referencedColumnName = "id")
    private Permission permission;

    public User_Permission() {
        super();
    }

    public User_Permission(int id, boolean licensed, User user, Permission permission) {
        super();
        this.id = id;
        this.licensed = licensed;
        this.user = user;
        this.permission = permission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLicensed() {
        return licensed;
    }

    public void setLicensed(boolean licensed) {
        this.licensed = licensed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
