package com.autilus.hw0207.servlets;

import com.autilus.hw0207.service.AccountService;
import com.autilus.hw0207.templater.PageGenerator;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
public class SignInServlet extends HttpServlet {
    private AccountService accountService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = PageGenerator.instance().getPage("signin.html", accountService.getData());
        response.getWriter().println(page);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        @NonNull
        String login = request.getParameter("login");

        @NonNull
        String password = request.getParameter("password");
        response.setContentType("text/html;charset=utf-8");
        if (login.isEmpty() || password.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            if (accountService.getData().containsKey(login) && accountService.getData().containsValue(password)) {
                response.getWriter().println("Authorized: " + login);
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                response.getWriter().println("Unauthorized");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
    }
}
