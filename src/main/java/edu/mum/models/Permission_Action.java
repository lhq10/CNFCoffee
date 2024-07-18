package edu.mum.models;

import jakarta.persistence.*;

@Entity
@Table(name="permission_action")
public class Permission_Action {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="licensed")
    private boolean licensed;

    @ManyToOne
    @JoinColumn(name = "permissionId",referencedColumnName = "id")
    private Permission permission;
    @ManyToOne
    @JoinColumn(name = "actionId",referencedColumnName = "id")
    private Action action;

    public Permission_Action() {
        super();
    }

    public Permission_Action(int id, boolean licensed, Permission permission, Action action) {
        super();
        this.id = id;
        this.licensed = licensed;
        this.permission = permission;
        this.action = action;
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

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
