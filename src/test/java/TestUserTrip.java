import ahmed.refactoring.here.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;




@DisplayName("A user Trips test case")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestUserTrip {

    private static final User GUEST = null;
    private static final User ANY_USER = new User();
    private static final User REGISTERED_USERS = new User();
    private static final User ANOTHER_USER = new User();
    private static final Trip LONDON = new Trip();
    private static final Trip CAIRO = new Trip() ;
    private User loggedInUser;
    TripServiceTest tripServiceTest;


   @BeforeAll
   public  void initA(){
        this.tripServiceTest = new TripServiceTest();

   }

    @Test()
    @DisplayName("validate user is not logged in")
    public void validateNoLoggedInUser() throws UserNoLoggedInException {
        assertThrows(UserNoLoggedInException.class,
                ()->{

                    loggedInUser = GUEST ;
                    tripServiceTest.getTripsByUSer(loggedInUser);
                });

    }

    @Test()
    @DisplayName("validate user is logged in")
    public void validateLoggedInUser() throws UserNoLoggedInException {
        loggedInUser = ANY_USER ;
        tripServiceTest.getTripsByUSer(loggedInUser);
    }

    @Test()
    @DisplayName("returns No Trips When Users Not Friends")
    public void returnsNoTripsWhenUsersNotFriends() throws UserNoLoggedInException {
        loggedInUser = REGISTERED_USERS;
        User stranger = new User();
        stranger.addFriend(ANOTHER_USER);
        stranger.addTrip(LONDON);
        List<Trip> tripList = tripServiceTest.getTripsByUSer(stranger);
        assertTrue(tripList.isEmpty());
    }

    @Test()
    @DisplayName("returns  Trips list When Users Not Friends")
    public void returnsTripsWhenUsersNotFriends() throws UserNoLoggedInException {
        loggedInUser = REGISTERED_USERS;
        User friend  = UserBuilder.user()
                .friendWith(ANOTHER_USER, REGISTERED_USERS)
                .travelTo(CAIRO, LONDON).build();
//        User friend = new User();
//        friend.addFriend(ANOTHER_USER);
//        friend.addTrip(LONON);
//        friend.addFriend(REGISTRED_USERS);
//        friend.addTrip(CAIRO);
        List<Trip> tripList = tripServiceTest.getTripsByUSer(friend);
        assertTrue (tripList.contains(LONDON));
        assertTrue (tripList.contains(CAIRO));

    }

    class TripServiceTest extends TripService {
        @Override
        public User getLoggedInUser() {
            return loggedInUser;
        }
        @Override
        public List<Trip> getUserTrips(User us) {
            return us.getTrips();
        }
    }

}
