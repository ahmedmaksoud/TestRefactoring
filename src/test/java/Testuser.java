import ahmed.refactoring.here.User;
import ahmed.refactoring.here.UserBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("A user Trips test case")
public class Testuser {
    public static  User  AHMED = new User();
    public static  User JOHAN = new User();
    @Test
    @DisplayName("test user is friend")
    public void testIsUserFriend (){
        JOHAN = UserBuilder.user().friendWith(AHMED).build();

//        JOHAN.addFriend(AHMED);
//        Boolean isFriend = JOHAN.isFriend(AHMED);
        assertTrue(JOHAN.isFriendWith(AHMED));
        assertFalse(AHMED.isFriendWith(JOHAN));
    }
}
