package com.pandawork.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_songs")
@Entity
public class song {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "beloinging")
    private String belonging;

    @Column(name = "singer")
    private String singer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBelonging() {
        return belonging;
    }

    public void setBelonging(String belonging) {
        this.belonging = belonging;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", belonging='" + belonging + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }
}
