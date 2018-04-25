package laullobet.org;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class FollowedRepositoryShould {

    @Test
    public void
    provide_stored_followers_for_any_user() {
        ArrayList<String> followedPlusSelf = new ArrayList<String>(){{
            add("Ann");
            add("Bob");
        }};
        FollowedRepository followedRepository = new FollowedRepository();

        followedRepository.add("Ann","Bob");
        Set<String> retrivedFollowed = followedRepository.getFollowedWithItself("Ann");

        assertEquals(retrivedFollowed,followedPlusSelf);
    }
}
