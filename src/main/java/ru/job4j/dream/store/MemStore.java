package ru.job4j.dream.store;

import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MemStore implements Store {

    private static final MemStore INST = new MemStore();
    private static final AtomicInteger POST_ID = new AtomicInteger(3);
    private static final AtomicInteger CANDIDATE_ID = new AtomicInteger(3);
    private static final AtomicInteger USER_ID = new AtomicInteger(4);
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();
    private final Map<Integer, User> users = new ConcurrentHashMap<>();
    private final List<City> citylist  = new CopyOnWriteArrayList<>();

    private MemStore() {
        posts.put(1, new Post(1, "1. Junior Java Job"));
        posts.put(2, new Post(2, "2. Middle Java Job"));
        posts.put(3, new Post(3, "3. Senior Java Job"));

        candidates.put(1, new Candidate(1, "Junior Java", 1));
        candidates.put(2, new Candidate(2, "Middle Java", 2));
        candidates.put(3, new Candidate(3, "Senior Java", 3));
        users.put(1, new User(1, "Tom", "tom@mail.com", ""));
        users.put(2, new User(2, "Anna", "anna@mail.com", ""));
        users.put(3, new User(3, "Julia", "julia@mail.com", ""));
        citylist.add(0, new City(1, "NOVOSIBIRSK"));
        citylist.add(1, new City(2, "MOSCOW"));
        citylist.add(2, new City(3, "OMSK"));
        citylist.add(3, new City(4, "BELGOROD"));
    }

    public static MemStore instOf() {
        return INST;
    }

    @Override
    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    @Override
    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    @Override
    public Collection<Post> findLastPosts() {
        return null;
    }

    @Override
    public Collection<Candidate> findLastCandidates() {
        return null;
    }

    @Override
    public void savePost(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    @Override
    public void saveCandidate(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(CANDIDATE_ID.incrementAndGet());
        }
        candidates.put(candidate.getId(), candidate);
    }

    @Override
    public Post findPostById(int id) {
        return posts.get(id);
    }

    @Override
    public Candidate findCandidateById(int id) {
        return candidates.get(id);
    }

    @Override
    public void deleteCandidate(int id) {
        candidates.remove(id);
    }

    @Override
    public Collection<User> findAllUsers() {
        return users.values();
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() == 0) {
            user.setId(USER_ID.incrementAndGet());
        }
        users.put(user.getId(), user);
    }

    @Override
    public User findUserById(int id) {
        return users.get(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return users.values().stream()
                .filter(user -> email.equals(user.getEmail()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteUser(int id) {
        users.remove(id);
    }

    @Override
    public Collection<City> findAllCities() {
        return citylist;
    }

    @Override
    public City findCityById(int id) {
        City result = null;
        for (City city : citylist) {
            if (id == city.getId()) {
                result = city;
                break;
            }
        }
        return result;
    }
}
