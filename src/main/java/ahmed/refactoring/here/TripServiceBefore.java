package ahmed.refactoring.here;

import java.util.ArrayList;
import java.util.List;

public class TripServiceBefore {
    public  List<Trip> getTripsByUSer(User us) throws UserNoLoggedInException {

        User loggedInUser = UserUtils.getLoggedInUser();
        boolean isFriend = false;
        if (loggedInUser != null) {
                for (User friend: us.getFriends()) {
                    if (friend.equals(loggedInUser)) {
                        isFriend = true;
                        break;
                    }
                }
                List<Trip> tripList = new ArrayList<Trip>();
                if (isFriend) {
                    tripList  = TripDao.getUserTrips(us);
                }
            return tripList;
        } else {
            throw new UserNoLoggedInException("user is not loggedIn");
        }


    }


}
