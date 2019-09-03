package com.challenge.srpago.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: gpucheta<br/>
 * Date: 9/1/19<br/>
 * Time: 11:48 PM<br/>
 * Generated to
 */
@Entity(name = "card_holder")
public class CardHolder {

    @Id
    private String id;
    private String name;
    @Column(name = "LAST_NAME")
    private String lastName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
