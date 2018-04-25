package laullobet.org;

import java.util.*;

public class FollowedRepository {
    private HashMap<String,ArrayList<String>> followedHash = new HashMap<>();

    public void add(String follower, String followed) {
        ArrayList<String> followerArray = followedHash.getOrDefault(follower, new ArrayList<>());
        followerArray.add(followed);
        followedHash.put(follower,followerArray);

    }

    public Set<String> getFollowedWithItself(String follower) {
        ArrayList<String> followed = new ArrayList<>(followedHash.get(follower));
        followed.add(follower);
        return new HashSet(followed);
    }
}
