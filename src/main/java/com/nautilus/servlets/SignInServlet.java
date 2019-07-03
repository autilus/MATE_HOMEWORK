package com.nautilus.servlets;

import com.nautilus.model.User;
import com.nautilus.service.UserServiceImpl;
import com.nautilus.templater.PageGenerator;
import lombok.NonNull;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.nautilus.App.RESPONCE_CONTENT_TYPE;

public class SignInServlet extends HttpServlet {
    private UserServiceImpl userService;

    public SignInServlet(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = PageGenerator.instance().getPage("static/signin.html", null);
        response.getWriter().println(page);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        @NonNull
        String login = request.getParameter("login");

        @NonNull
        String password = request.getParameter("password");
        response.setContentType(RESPONCE_CONTENT_TYPE);
        if (login.isEmpty() || password.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            boolean status = false;
            try {
                status = userService.findIdByLogin(login).equals(userService.findIdByPassword(password));
            } catch (Exception e) {
                response.getWriter().println("Unauthorized");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
            if (status) {
                response.getWriter().println("Authorized: " + login);
                response.setStatus(HttpServletResponse.SC_OK);
            }
        }
    }
}
