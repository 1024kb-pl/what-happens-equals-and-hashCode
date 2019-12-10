package pl.blog.spring;

public class User {
    final int id;
    final String login;
    int age;

    public User(int id, String login, int age) {
        this.id = id;
        this.login = login;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
