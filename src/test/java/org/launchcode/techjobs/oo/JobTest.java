package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job webDeveloper = new Job();
        Job graphicsDesigner = new Job();
        assertNotEquals(webDeveloper.getId(), graphicsDesigner.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob instanceof Job);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testJob.getName(), "Product tester");
        assertEquals(testJob.getEmployer().getValue(), "ACME");
        assertEquals(testJob.getLocation().getValue(), "Desert");
        assertEquals(testJob.getPositionType().getValue(), "Quality control");
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");

    }

    @Test
    public void testJobsForEquality() {
        Job testJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(testJobOne, testJobTwo);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJobOne.toString().startsWith(System.lineSeparator()));
        assertTrue(testJobOne.toString().endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(testJobOne.toString(), System.lineSeparator() + "ID: " + testJobOne.getId() + System.lineSeparator() + "Name: Product tester" + System.lineSeparator() + "Employer: ACME" + System.lineSeparator() + "Location: Desert" + System.lineSeparator() + "Position Type: Quality control" + System.lineSeparator() + "Core Competency: Persistence" + System.lineSeparator());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job("", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency(""));
        assertEquals(testJob.toString(), System.lineSeparator() + "ID: " + testJob.getId() + System.lineSeparator() + "Name: Data not available" + System.lineSeparator() + "Employer: ACME" + System.lineSeparator() + "Location: Data not available" + System.lineSeparator() + "Position Type: Quality control" + System.lineSeparator() + "Core Competency: Data not available" + System.lineSeparator());
    }

    @Test
    public void testToStringHandlesNull() {
        Job testJob = new Job();
        assertEquals(testJob.toString(), "OOPS! This job does not seem to exist.");
    }
}