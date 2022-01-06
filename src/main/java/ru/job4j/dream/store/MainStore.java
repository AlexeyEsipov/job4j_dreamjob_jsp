package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

public class MainStore {

    public void printDB(Store store) {
        System.out.println("Таблица кандидатов:");
        for (Candidate can: store.findAllCandidates()) {
            System.out.println(can);
        }
        System.out.println();
        System.out.println("Таблица постов:");
        for (Post post : store.findAllPosts()) {
            System.out.println(post);
        }
        System.out.println();
    }

    public void printRecord(Store store, int idPost, int idCandidate) {
        Post post = store.findPostById(idPost);
        Candidate candidate = store.findCandidateById(idCandidate);
        System.out.printf("Post %d :", idPost);
        System.out.printf(" %d  %s", post.getId(), post.getName());
        System.out.println();
        System.out.printf("Candidate %d :", idCandidate);
        System.out.printf(" %d  %s", candidate.getId(), candidate.getName());
        System.out.println();
    }

    public static void main(String[] args) {
        MainStore mainStore = new MainStore();
        Store store = DbStore.instOf();
        mainStore.printDB(store);
        System.out.println("   Добавляем  " + System.lineSeparator());
        store.savePost(new Post(0, "Java Job1"));
        store.savePost(new Post(0, "Java Job2"));
        store.savePost(new Post(0, "Java Job3"));
        store.savePost(new Post(0, "Java Job4"));
        store.savePost(new Post(0, "Java Job5"));
        store.savePost(new Post(0, "Java Job6"));
        store.savePost(new Post(5, "Java Job5-Edit"));

        store.saveCandidate(new Candidate(0, "Java Candidate1"));
        store.saveCandidate(new Candidate(0, "Java Candidate2"));
        store.saveCandidate(new Candidate(0, "Java Candidate3"));
        store.saveCandidate(new Candidate(0, "Java Candidate4"));
        store.saveCandidate(new Candidate(0, "Java Candidate5"));
        store.saveCandidate(new Candidate(0, "Java Candidate6"));
        store.saveCandidate(new Candidate(5, "Java Candidate5-Edit"));
        System.out.println("Проверяем" + System.lineSeparator());
        mainStore.printDB(store);
        System.out.println(" 5 запись" + System.lineSeparator());
        mainStore.printRecord(store, 5, 5);

//        Post post = new Post(0, "Java Job");
//        System.out.println(post.getId());
//        store.savePost(post);
        // Post postInDb = store.findPostById(post.getId());
//        Post postInDb = store.findPostById(1);
//        System.out.println(postInDb);


    }
}
