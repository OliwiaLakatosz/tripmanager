package pl.edu.agh.mwo;
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class TripManagerTest {

	TripManager tripManager;
	Trip trip;
	
	@Before
	public void setUp() {
		tripManager = new TripManager();
		trip = new Trip("nazwa", "opis");
	}
	
	@Test
	public void testAdd() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
	}

	@Test(expected = TripAlreadyExistsException.class)
	public void testAddTripTwice() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.add(trip);
	}

	@Test
	public void testRemoveTrip() throws Exception {
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.remove(trip.getName());
		assertEquals(0, tripManager.getTrips().size());
	}

	@Test
    public void testFindTripByTitle() throws TripAlreadyExistsException {
	    Trip trip1 = new Trip("Awesome trip around the world",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
	    tripManager.add(trip);
	    tripManager.add(trip1);
	    assertEquals(trip1, tripManager.findTrip("awesome"));
    }

    @Test
    public void testFindTripByDescription() throws TripAlreadyExistsException {
        Trip trip1 = new Trip("Awesome trip around the world",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        tripManager.add(trip);
        tripManager.add(trip1);
        assertEquals(trip1, tripManager.findTrip("ELIT"));
    }

    @Test
    public void testNoMatchingTrip() throws TripAlreadyExistsException {
	    tripManager.add(trip);
        assertNull(tripManager.findTrip("ukulele"));
    }
}
