package io.khasang.gahelp.entity;

import javax.persistence.*;

@Entity
@Table(name = "logsheet")
public class LogSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String items;
    private Integer hitPoints;
    private Integer level;
    private Integer gold;
    private Integer parameters;
    private boolean isAlive;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(Integer hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Integer getParameters() {
        return parameters;
    }

    public void setParameters(Integer parameters) {
        this.parameters = parameters;
    }
}
