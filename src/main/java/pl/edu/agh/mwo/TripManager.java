package pl.edu.agh.mwo;
import java.util.*;

public class TripManager {
	private HashMap<String,Trip> tripList;
	
	public TripManager() {
		tripList = new HashMap<String, Trip>();
	}
	
	public void add(Trip trip) throws TripAlreadyExistsException {
		if (tripList.get(trip.getName()) != null) {
			throw new TripAlreadyExistsException();
		}
		else {
			tripList.put(trip.getName(),trip);
		}
	}
	
	public HashMap<String,Trip> getTrips() {
		return tripList;
	}

	public void remove(String name) {
		tripList.remove(name);
	}

	public Trip findTrip(String keyword) {
        for (String tripName : tripList.keySet()) {
            if (tripName.toLowerCase().contains(keyword.toLowerCase()) ||
                    tripList.get(tripName).getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                return tripList.get(tripName);
            }
        }
        return null;
	}

}
