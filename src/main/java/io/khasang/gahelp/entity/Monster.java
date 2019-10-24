package io.khasang.gahelp.entity;
import javax.persistence.*;

@Entity
@Table(name = "monsters")
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //monster type (orc, ogr, goblin...)
    private String type;
    private int healthPoint;
    private int mana;
    private int strength;
    private int intelligence;
    private int agility;
    private int endurance;
    private int level;
    private int intuition;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getIntuition() {
        return intuition;
    }

    public void setIntuition(int intuition) {
        this.intuition = intuition;
    }
}
