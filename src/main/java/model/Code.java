package model;

import java.util.Objects;

public class Code {
    private String code;
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Code code1 = (Code) o;
        return Objects.equals(code, code1.code) &&
                Objects.equals(user, code1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, user);
    }

    @Override
    public String toString() {
        return "Code{" +
                "code='" + code + '\'' +
                ", user=" + user +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Code(String code, User user) {
        this.code = code;
        this.user = user;
    }
}
