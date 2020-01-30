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

    public Job(String aName, Employer aEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency){
        this();
        name = aName;
        employer = aEmployer;
        location = aLocation;
        positionType = aPositionType;
        coreCompetency = aCoreCompetency;
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

    public void setEmployer(Employer aEmployer) {
        employer = aEmployer;
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

        if(name == null && employer == null && location == null
        && positionType == null && coreCompetency == null){
           return "OOPS! This job does not seem to exist.";
        }

        String idLine =  "\n" + "ID: " + id;
        String nameLine = "\n" + "Name: " + name;
        String employerLine = "\n" + "Employer: " + employer;
        String locationLine = "\n" + "Location: " + location;
        String positionTypeLine = "\n" + "Position Type: " + positionType;
        String coreCompLine =  "\n" + "Core Competency: " + coreCompetency;
        String endLine = "\n";
        if(name.equals("")){
            nameLine += "Data not available";
        }
        if(employer.getValue().equals("")){
           employerLine += "Data not available";
        }
        if(location.getValue().equals("")){
            locationLine += "Data not available";
        }
        if(positionType.getValue().equals("")){
            positionTypeLine += "Data not available";
        }
        if(coreCompetency.getValue().equals("")){
            coreCompLine += "Data not available";
        }
        return idLine + nameLine + employerLine + locationLine + positionTypeLine + coreCompLine + endLine;
    }
}
