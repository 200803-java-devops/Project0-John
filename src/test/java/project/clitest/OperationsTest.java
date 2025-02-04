package project.clitest;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import project.cli.ProgramOperations;

public class OperationsTest {
    
    @Test
    public void ProgramRunTest(){
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        ProgramOperations ops = new ProgramOperations();
        ops.RunApp(in);
        assertTrue(ProgramOperations.exitStatus);
    }
}