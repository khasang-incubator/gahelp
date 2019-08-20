package io.khasang.gahelp.dto;

public class PhysicalSkillDto{
    private long Id;
    private String name;
    private int timeToUse;
    private String description;
    private int duration;
    private int distance;

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

    public int getTimeToUse() {
        return timeToUse;
    }

    public void setTimeToUse(int timeToUse) {
        this.timeToUse = timeToUse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
