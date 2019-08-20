package io.khasang.gahelp.entity;

import javax.persistence.*;

@Entity
@Table(name = "mag_skills")
public class MagicalSkill{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String name;
    private String description;
    private int powerOfSkill;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPowerOfSkill() {
        return powerOfSkill;
    }

    public void setPowerOfSkill(int powerOfSkill) {
        this.powerOfSkill = powerOfSkill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
