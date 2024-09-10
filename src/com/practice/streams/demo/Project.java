package com.practice.streams.demo;

import java.util.Comparator;

public class Project implements Comparator<Project> {

    private String name;
    private String team;
    private String projectManager;

    Project(){
    }

    public Project(String name, String team, String projectManager) {
        this.name = name;
        this.team = team;
        this.projectManager = projectManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }


    @Override
    public int compare(Project o1, Project o2) {

        return o1.getName().compareTo(o2.getName());
    }
}