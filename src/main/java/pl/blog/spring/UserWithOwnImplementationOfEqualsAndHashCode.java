package pl.blog.spring;

import java.util.Objects;

public class UserWithOwnImplementationOfEqualsAndHashCode extends User {
    public UserWithOwnImplementationOfEqualsAndHashCode(int id, String login, int age) {
        super(id, login, age);
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserWithOwnImplementationOfEqualsAndHashCode that = (UserWithOwnImplementationOfEqualsAndHashCode) o;
        return id == that.id &&
                login.equals(that.login);
    }
}
