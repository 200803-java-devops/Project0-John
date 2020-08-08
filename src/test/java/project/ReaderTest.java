package project;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class ReaderTest {
    String test = "testeroni";

    @Test
    public void CorrectReadOutput() throws UnsupportedEncodingException {
        InputStream in = new ByteArrayInputStream(test.getBytes());
        InputReader readInput = new InputReader();
        String out = readInput.Read(in);
        System.out.println(out);
        assertEquals(test, out);
    }    
}