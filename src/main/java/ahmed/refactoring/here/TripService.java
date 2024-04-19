package ahmed.refactoring.here;

import java.util.ArrayList;
import java.util.List;

public class TripService {
    public  List<Trip> getTripsByUSer(User us) throws UserNoLoggedInException {
        User loggedInUser = getLoggedInUser();
        if (loggedInUser == null) {
            throw new UserNoLoggedInException("user is not loggedIn");
        }
        return   us.isFriendWith(loggedInUser) ? getUserTrips(us) : new ArrayList<Trip>();
    }

      public List<Trip> getUserTrips(User user) {
        return TripDao.getUserTrips(user);
    }

      public User getLoggedInUser() {
        return UserUtils.getLoggedInUser();
    }
}
