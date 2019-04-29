package pl.edu.agh.mwo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PhotoTest {

    Photo photo;

    @Before
    public void setUp() {
        photo = new Photo();
        photo.setComment("random comment");
    }

    @Test
    public void testGetComment() {
        assertEquals("random comment", photo.getComment());
    }

}