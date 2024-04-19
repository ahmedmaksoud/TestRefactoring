package ahmed.refactoring.here;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<User> friends = new ArrayList<User>();
    private List<Trip> trips = new ArrayList<Trip>();

    public void addFriend(User friend) {
        this.friends.add(friend);
    }

    public void addTrip(Trip trip) {
        this.trips.add(trip);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public Boolean isFriendWith(User friend) {
        return this.friends.contains(friend);
    }
}
