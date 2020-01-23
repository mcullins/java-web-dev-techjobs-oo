package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job(){
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString(){
        //Why does "this.getName() == null" work but this.getName().equals(null)" does not?
        if(this.getName() == null && this.getEmployer() == null && this.getLocation() == null
        && this.positionType == null && this.getCoreCompetency() == null){
           return "OOPS! This job does not seem to exist.";
        }

        String idLine =  "\n" + "ID: " + this.id;
        String nameLine = "\n" + "Name: " + this.name;
        String employerLine = "\n" + "Employer: " + this.employer;
        String locationLine = "\n" + "Location: " + this.location;
        String positionTypeLine = "\n" + "Position Type: " + this.positionType;
        String coreCompLine =  "\n" + "Core Competency: " + this.coreCompetency;
        String endLine = "\n";
        if(this.name.equals("")){
            nameLine += "Data not available";
        }
        if(this.employer.getValue().equals("")){
           employerLine += "Data not available";
        }
        if(this.location.getValue().equals("")){
            locationLine += "Data not available";
        }
        if(this.positionType.getValue().equals("")){
            positionTypeLine += "Data not available";
        }
        if(this.coreCompetency.getValue().equals("")){
            coreCompLine += "Data not available";
        }
        return idLine + nameLine + employerLine + locationLine + positionTypeLine + coreCompLine + endLine;
    }
}
