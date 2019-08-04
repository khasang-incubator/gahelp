package io.khasang.gahelp.entity;

import javax.persistence.*;

@Entity
@Table(name = "phys_skills")
public class PhysicalSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String name;
    private int minLevelCharacter;
    private int powerOfSkill;
    private boolean isLearned;

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

    public int getMinLevelCharacter() {
        return minLevelCharacter;
    }

    public void setMinLevelCharacter(int minLevelCharacter) {
        this.minLevelCharacter = minLevelCharacter;
    }

    public int getPowerOfSkill() {
        return powerOfSkill;
    }

    public void setPowerOfSkill(int powerOfSkill) {
        this.powerOfSkill = powerOfSkill;
    }

    public boolean isLearned() {
        return isLearned;
    }

    public void setIsLearned(boolean learned) {
        this.isLearned = learned;
    }
}
