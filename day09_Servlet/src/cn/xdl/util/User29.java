package cn.xdl.util;

import java.util.Objects;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project xdl_javaweb
 * @package cn.xdl.util
 * @created 2019-11-13 18:43
 * @function ""
 */
public class User29 {
    private int id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User29{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User29 user29 = (User29) o;
        return id == user29.id &&
                Objects.equals(username, user29.username) &&
                Objects.equals(password, user29.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
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

    public User29(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User29(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
