package pl.blog.spring;

import java.util.Objects;

public class UserWithGeneratedEqualsAndHashCode extends User {
    public UserWithGeneratedEqualsAndHashCode(int id, String login, int age) {
        super(id, login, age);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserWithGeneratedEqualsAndHashCode that = (UserWithGeneratedEqualsAndHashCode) o;
        return this.id == that.id &&
                age == that.age &&
                Objects.equals(login, that.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, age);
    }
}
