package ru.job4j.dream.servlet;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.DbStore;

public class CandidateServletTest {

    @Test
    public void whenCreateCandidate() throws IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("New Candidate");
        when(req.getParameter("city")).thenReturn("1");
        new CandidateServlet().doPost(req, res);
        Candidate candidate = DbStore.instOf().findCandidateById(1);
        assertNotNull(candidate);
    }

    @Test
    public void whenEditCandidate() throws IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        DbStore.instOf().saveCandidate(new Candidate(0, "New candidate", 1));
        when(req.getParameter("id")).thenReturn("1");
        when(req.getParameter("name")).thenReturn("Updated candidate");
        when(req.getParameter("city")).thenReturn("1");
        new CandidateServlet().doPost(req, res);
        Candidate candidate = DbStore.instOf().findCandidateById(1);
        assertEquals(candidate.getName(), "Updated candidate");
    }
}