package com.distributor.entities;

import com.distributor.models.MyRoleJsonHashSet;
import com.distributor.tools.MathsTool;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Type;
import javax.persistence.*;

//https://notes.kartashov.com/2016/01/29/adding-jsonb-support-to-hibernate/
@Entity
@Immutable
@NamedQueries({
        @NamedQuery(name="getMyUserByLogin",
        query="select m from MyUser m where m.login = :paramLogin"),
        @NamedQuery(name="getAllMyUsers",
        query="select m from MyUser m")
})
@NamedNativeQueries(value={
        @NamedNativeQuery(name="native.query.getMyUserByLogin",
        query="select * from myuser m where m.login = :paramLogin", resultClass = MyUser.class)
})
public class MyUser implements MathsTool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String login;

    @Transient
    private String password;

    @Column(unique = true)
    private String email;

    private String hashPassword;

    @Column
    @Type(type = "MyRoleJsonType")
    private MyRoleJsonHashSet myRoleJsonHashSet;

    public MyUser() {
        super();
    }

    public MyUser(String login, String password, String email) {
        this();
        this.login = login;
        this.password = password;
        this.email = email;
        hashPassword = getStringSha3(password);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        hashPassword = getStringSha3(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MyRoleJsonHashSet getMyRoleJsonHashSet() {
        return myRoleJsonHashSet;
    }

    public void setMyRoleJsonHashSet(MyRoleJsonHashSet myRoleJsonHashSet) {
        this.myRoleJsonHashSet = myRoleJsonHashSet;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }
}
