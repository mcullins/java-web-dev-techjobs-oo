package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;


public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertEquals(job1.getId()+1, job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job3 instanceof Job);
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job job4 = new Job ("Software Developer", new Employer("DST"), new Location ("Kansas City"),
                new PositionType("Programming"), new CoreCompetency("Efficiency"));
        Job job5 = new Job ("Software Developer", new Employer("DST"), new Location ("Kansas City"),
                new PositionType("Programming"), new CoreCompetency("Efficiency"));
        assertFalse(job4.equals(job5));
    }

    @Test
    public void testForToStringStartsEndsWithSpaces(){
        Job job6 = new Job();
        assertTrue(job6.toString().startsWith("\n"));
        assertTrue(job6.toString().endsWith("\n"));
    }

    @Test
    public void testForToStringData(){
        Job job7 = new Job("Software Developer", new Employer("DST"), new Location ("Kansas City"),
                new PositionType("Programming"), new CoreCompetency("Efficiency"));
        String str = "\n" + "ID: " + job7.getId() + "\n" + "Name: " + job7.getName() +
                "\n" + "Employer: " + job7.getEmployer() + "\n" + "Location: " +
                job7.getLocation() + "\n" + "Position Type: " + job7.getPositionType() +
                "\n" + "Core Competency: " + job7.getCoreCompetency() + "\n";
        assertEquals(str, job7.toString());
    }

    @Test
    public void testForEmptyFieldDefault(){
        Job job8 = new Job();
        assertTrue(job8.toString().contains("Data not available"));
    }
}
