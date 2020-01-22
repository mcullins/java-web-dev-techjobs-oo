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

}
