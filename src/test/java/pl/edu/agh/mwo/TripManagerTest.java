package pl.edu.agh.mwo;
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
		List<Trip> results = tripManager.findTrip("awesome");
	    assertEquals(1, results.size());
	    assertEquals(trip1, results.get(0));
    }

    @Test
    public void testFindTripByDescription() throws TripAlreadyExistsException {
        Trip trip1 = new Trip("Awesome trip around the world",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        tripManager.add(trip);
        tripManager.add(trip1);
		List<Trip> results = tripManager.findTrip("opis");
		assertEquals(1, results.size());
		assertEquals(trip, results.get(0));
	}

    @Test
    public void testNoMatchingTrip() throws TripAlreadyExistsException {
	    tripManager.add(trip);
		Trip trip1 = new Trip("Awesome trip around the world",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
	    tripManager.add(trip1);
		List<Trip> results = tripManager.findTrip("ukulele");
		assertEquals(0, results.size());
    }
}
