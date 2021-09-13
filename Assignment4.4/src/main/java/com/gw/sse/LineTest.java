package com.gw.sse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LineTest {
    Line lineHori1 = new Line(0, 1,5,1);
    Line lineHori2 = new Line(0,6,100,6);
    Line lineVert = new Line(0,0,0,10);
    Line line45_1 = new Line(1,1,5,5);
    Line line45_2 = new Line(0,0,7,7);
    Line lineLength5 = new Line(0,0,3,4);

    @Test
    public void testGetSlope(){
        assertEquals((double)0, lineHori1.getSlope());
        Exception exception = assertThrows(ArithmeticException.class, () ->{
           lineVert.getSlope();
        });
        assertEquals((double)4 / (double)3, lineLength5.getSlope());
    }

    @Test
    public void testGetDistance(){
        assertEquals((double)5, lineLength5.getDistance());
        assertEquals((double)100, lineHori2.getDistance());
        assertEquals((double)10, lineVert.getDistance());
    }

    @Test
    public void testParallelTo(){
        assertTrue(line45_1.parallelTo(line45_2));
        assertTrue(lineHori1.parallelTo(lineHori2));
        assertTrue(!lineLength5.parallelTo(line45_1));
    }
}
