package laullobet.org;

import java.util.*;

public class FollowedRepository {
    private HashMap<String,ArrayList<String>> followedHash = new HashMap<>();

    public void add(String follower, String followed) {
        ArrayList<String> followerArray = Optional
                .ofNullable( followedHash.get(follower))
                .orElseGet(()->{
                    followedHash.put(follower,new ArrayList<>());
                    return followedHash.get(follower);
                });
        followerArray.add(followed);

    }

    public Set<String> getFollowedWithItself(String follower) {
        ArrayList<String> followed = new ArrayList<>(followedHash.get(follower));
        followed.add(follower);
        return new HashSet(followed);
    }
}
