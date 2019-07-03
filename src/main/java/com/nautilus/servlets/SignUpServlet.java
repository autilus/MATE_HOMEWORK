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


public class SignUpServlet extends HttpServlet {

    private UserServiceImpl userService;
    private User user;

    public SignUpServlet(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println(PageGenerator.instance().getPage("/static/signup.html", null));
        response.setContentType(RESPONCE_CONTENT_TYPE);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        @NonNull
        String login = request.getParameter("login");

        @NonNull
        String password = request.getParameter("password");
        user = new User();
        user.setLogin(login);
        user.setPassword(password);
        userService.save(user);
        response.getWriter().println("Account created");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
