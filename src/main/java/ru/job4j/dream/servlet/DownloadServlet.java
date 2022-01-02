package ru.job4j.dream.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        File users = null;
        for (File file : Objects.requireNonNull(new File(Config.getProperty("images")).listFiles())) {
            if (name.equals(file.getName().split("\\.")[0])) {
                users = file;
                break;
            }
        }
        resp.setContentType("application/octet-stream");
        assert users != null;
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + users.getName() + "\"");
        try (FileInputStream stream = new FileInputStream(users)) {
            resp.getOutputStream().write(stream.readAllBytes());
        }
    }
}