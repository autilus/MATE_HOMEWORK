package com.autilus.hw0207.main;

import com.autilus.hw0207.service.AccountService;
import com.autilus.hw0207.servlets.MirrorServlet;
import com.autilus.hw0207.servlets.SignInServlet;
import com.autilus.hw0207.servlets.SignUpServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static final String RESPONCE_CONTENT_TYPE="text/html;charset=utf-8";
    public static void main(String[] args) throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        AccountService accountService=new AccountService();
        context.addServlet(new ServletHolder(new MirrorServlet()), "/mirror");
        context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");
        context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");
        Server server = new Server(8081);
        server.setHandler(context);
        server.start();
        server.join();
    }
}
