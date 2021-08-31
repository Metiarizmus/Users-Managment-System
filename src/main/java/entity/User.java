package entity;
import annotation.DBTable;

import java.util.Date;
import java.util.Objects;

public class User {
    @DBTable(columnNameForSelect = "id")
    private int id;
    @DBTable(columnNameForSelect = "name")
    private String name;
    @DBTable(columnNameForSelect = "birthday")
    private Date birthday;
    @DBTable(columnNameForSelect = "last login")
    private Date lastLogin;
    @DBTable(columnNameForSelect = "registration date")
    private Date registrationDate;
    @DBTable(columnNameForSelect = "password")
    private String password;
    @DBTable(columnNameForSelect = "login")
    private String login;

    public User() {

    }

    public User(String name, int id, Date birthday, Date lastLogin, Date registrationDate, String password, String login) {
        this.name = name;
        this.id = id;
        this.birthday = birthday;
        this.lastLogin = lastLogin;
        this.registrationDate = registrationDate;
        this.password = password;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday) && Objects.equals(lastLogin, user.lastLogin) && Objects.equals(registrationDate, user.registrationDate) && Objects.equals(password, user.password) && Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, birthday, lastLogin, registrationDate, password, login);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", birthday=" + birthday +
                ", lastLogin=" + lastLogin +
                ", registrationDate=" + registrationDate +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}