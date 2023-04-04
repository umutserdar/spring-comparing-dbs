package com.spring.cassandra.model;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;


@Table(value = "person")
public class Person {
    @PrimaryKey
    @Column(value = "id")
    private UUID id;
    @Column(value = "name")
    private String name;
    @Column(value = "email")
    private String email;
    @Column(value = "age")
    private int age;


    public Person() {
        this.id = Uuids.timeBased();
    }

    public Person(UUID id, String name, String email, int age) {
        this.id = Uuids.timeBased();
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
