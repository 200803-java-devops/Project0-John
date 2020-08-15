package project;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import project.cli.ProgramOperations;

public class OperationsTest {
    
    @Test
    public void ProgramRunTest(){
        String input = "exit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        ProgramOperations.RunApp(in);
        assertTrue(ProgramOperations.exitStatus);
    }
}