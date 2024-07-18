package edu.mum.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Set;


@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @Transient
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "is_super")
    private boolean isSuper;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "permission")
    private String permission;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "user")
    private Set<Cart> user_cart;

    @OneToMany(mappedBy = "user")
    private Set<Staff_Salary_Shift> user_staff_salary_shift;

    @OneToMany(mappedBy = "user")
    private Set<User_Permission> user_permission;

    @OneToMany(mappedBy = "user")
    private Set<Order> user_order;

    public User() {
        super();
    }

    public User(String firstName, Date birthday, String email, String password, String avatar) {
        this.firstName = firstName;
        this.birthday = birthday;
        this.password = password;
        this.avatar = avatar;
        this.email = email;
    }

    public User(int id, String username, String password, String firstName, String lastName, Date birthday, String email, boolean gender, String phone, boolean isSuper, String permission, boolean isActive, String avatar, Date createdAt, Date updatedAt, Set<Cart> user_cart, Set<Staff_Salary_Shift> user_staff_salary_shift, Set<User_Permission> user_permission, Set<Order> user_order) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.isSuper = isSuper;
        this.permission = permission;
        this.isActive = isActive;
        this.avatar = avatar;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user_cart = user_cart;
        this.user_staff_salary_shift = user_staff_salary_shift;
        this.user_permission = user_permission;
        this.user_order = user_order;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isSuper() {
        return isSuper;
    }

    public void setSuper(boolean aSuper) {
        isSuper = aSuper;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Cart> getUser_cart() {
        return user_cart;
    }

    public void setUser_cart(Set<Cart> user_cart) {
        this.user_cart = user_cart;
    }

    public Set<Staff_Salary_Shift> getUser_staff_salary_shift() {
        return user_staff_salary_shift;
    }

    public void setUser_staff_salary_shift(Set<Staff_Salary_Shift> user_staff_salary_shift) {
        this.user_staff_salary_shift = user_staff_salary_shift;
    }

    public Set<User_Permission> getUser_permission() {
        return user_permission;
    }

    public void setUser_permission(Set<User_Permission> user_permission) {
        this.user_permission = user_permission;
    }

    public Set<Order> getUser_order() {
        return user_order;
    }

    public void setUser_order(Set<Order> user_order) {
        this.user_order = user_order;
    }


}
