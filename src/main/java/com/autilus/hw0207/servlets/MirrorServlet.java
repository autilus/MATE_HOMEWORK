package com.autilus.hw0207.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.autilus.hw0207.main.Main.RESPONCE_CONTENT_TYPE;

public class MirrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println(request.getParameter("key"));
        response.setContentType(RESPONCE_CONTENT_TYPE);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
