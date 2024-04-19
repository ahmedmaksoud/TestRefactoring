package ahmed.refactoring.here;

import java.util.Arrays;

public class UserBuilder {
    private User[] friends = new User[]{};
    private Trip[] trips = new Trip[]{};

    public static UserBuilder user() {
        return new UserBuilder();
    }

    public UserBuilder friendWith(User... friends) {
        this.friends = friends;
        return this;
    }

    public UserBuilder travelTo(Trip... trips) {
        this.trips = trips;
        return this;
    }

    public User build() {
        User us = new User();
        addFriends(us);
        addTrips(us);

        return us;
    }

    private void addTrips(User us) {
        us.getTrips().addAll(Arrays.asList(this.trips));
    }

    private void addFriends(User us) {
        us.getFriends().addAll(Arrays.asList(this.friends));
    }

}
