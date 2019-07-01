package com.autilus.hw0207.servlets;

import com.autilus.hw0207.service.AccountService;
import com.autilus.hw0207.templater.PageGenerator;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
public class SignUpServlet extends HttpServlet {

    private AccountService accountService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println(PageGenerator.instance().getPage("signup.html", accountService.getData()));
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        @NonNull
        String login = request.getParameter("login");

        @NonNull
        String password = request.getParameter("password");
        accountService.getData().put(login, password);
        response.getWriter().println("Account created");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
