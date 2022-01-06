package ru.job4j.dream.store;

import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.Candidate;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemStore implements Store {

    private static final MemStore INST = new MemStore();
    private static final AtomicInteger POST_ID = new AtomicInteger(3);
    private static final AtomicInteger CANDIDATE_ID = new AtomicInteger(3);
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private MemStore() {
        posts.put(1, new Post(1, "1. Junior Java Job", "Junior Java Job", "12.07.02"));
        posts.put(2, new Post(2, "2. Middle Java Job", "Middle Java Job", "20.05.10"));
        posts.put(3, new Post(3, "3. Senior Java Job", "Senior Java Job", "05.07.14"));
        candidates.put(1, new Candidate(1, "Junior Java"));
        candidates.put(2, new Candidate(2, "Middle Java"));
        candidates.put(3, new Candidate(3, "Senior Java"));
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
}
