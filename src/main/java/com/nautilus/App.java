package com.nautilus;

import com.nautilus.service.UserService;
import com.nautilus.servlets.SignInServlet;
import com.nautilus.servlets.SignUpServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class App {
    public static final String RESPONCE_CONTENT_TYPE = "text/html;charset=utf-8";

    public static void main(String[] args) throws Exception {
        UserService userService = new UserService();
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new SignInServlet(userService)), "/signin");
        context.addServlet(new ServletHolder(new SignUpServlet(userService)), "/signup");
        Server server = new Server(8081);
        server.setHandler(context);
        server.start();
        server.join();
    }
}