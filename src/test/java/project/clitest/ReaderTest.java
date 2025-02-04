package project.clitest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import project.cli.InputReader;

public class ReaderTest {
    String test = "testeroni";

    /**
     * Test that reader correctly takes inputstream and outputs as a string
     */
    @Test
    public void CorrectReadOutput() throws UnsupportedEncodingException {
        InputStream in = new ByteArrayInputStream(test.getBytes());
        InputReader readInput = new InputReader();
        String out = readInput.Read(in);
        System.out.println(out);
        assertEquals(test, out);
    }    
}