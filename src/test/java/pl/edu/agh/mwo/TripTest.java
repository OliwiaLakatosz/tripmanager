package pl.edu.agh.mwo;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TripTest {

	@Test
	public void testConstructor() {
		Trip trip = new Trip("nazwa", "opis");
		assertEquals("nazwa", trip.getName());
		assertEquals("opis", trip.getDescription());
	}

	@Test
    public void testTripEditing() {
	    Trip trip = new Trip("Lorem", "Ipsum");
        assertEquals("Lorem", trip.getName());
        assertEquals("Ipsum", trip.getDescription());
	    trip.setName("name");
	    trip.setDescription("description");
	    assertEquals("name", trip.getName());
	    assertEquals("description", trip.getDescription());
    }

	@Test
    public void testAddPhoto() {
	    Photo photo = new Photo();
	    Trip trip = new Trip("nazwa", "opis");
	    trip.addPhoto(photo);
	    assertEquals(1, trip.getPhotos().size());
    }

}
