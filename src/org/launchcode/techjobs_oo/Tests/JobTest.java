package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;


public class JobTest {

    Job job1;

    @Before
    public void createJob() {
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){
        Job job2 = new Job();
        assertEquals(job1.getId()+1, job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){

        assertTrue(job1 instanceof Job);
        assertTrue(job1.getName() instanceof String);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job1.getName());
        assertEquals("ACME", job1.getEmployer().getValue());
        assertEquals("Desert", job1.getLocation().getValue());
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertEquals("Persistence", job1.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job job2 = new Job ("Software Developer", new Employer("DST"), new Location ("Kansas City"),
                new PositionType("Programming"), new CoreCompetency("Efficiency"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testForToStringStartsEndsWithSpaces(){
        assertTrue(job1.toString().startsWith("\n"));
        assertTrue(job1.toString().endsWith("\n"));
    }

    @Test
    public void testForToStringData(){
       String str = "\n" + "ID: " + job1.getId() + "\n" + "Name: " + job1.getName() +
                "\n" + "Employer: " + job1.getEmployer() + "\n" + "Location: " +
                job1.getLocation() + "\n" + "Position Type: " + job1.getPositionType() +
                "\n" + "Core Competency: " + job1.getCoreCompetency() + "\n";
        assertEquals(str, job1.toString());
    }

    @Test
    public void testForEmptyFieldDefault(){
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType(""), new CoreCompetency("Persistence"));
        assertTrue(job2.toString().contains("Data not available"));
    }

    @Test
    public void testForNoDataResponse(){
        Job job2 = new Job();
        assertEquals("OOPS! This job does not seem to exist.", job2.toString());
    }
}
