package com.klef.jfsd.exam;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "duration")
    private int duration;  // in months

    @Column(name = "budget")
    private double budget;

    @Column(name = "team_lead")
    private String teamLead;

    // Constructors, Getters, and Setters
    public Project() {}

    public Project(String projectName, int duration, double budget, String teamLead) {
        this.projectName = projectName;
        this.duration = duration;
        this.budget = budget;
        this.teamLead = teamLead;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(String teamLead) {
        this.teamLead = teamLead;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", duration=" + duration +
                ", budget=" + budget +
                ", teamLead='" + teamLead + '\'' +
                '}';
    }
}
