package com.acme;

import java.util.Objects;

public final class Usuario {

    private final String name;
    private final int age;

    // Construtor
    public Usuario(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    // equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario user = (Usuario) o;
        return age == user.age &&
               Objects.equals(name, user.name);
    }

    // hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    // toString()
    @Override
    public String toString() {
        return "User[name=" + name + ", age=" + age + "]";
    }
}