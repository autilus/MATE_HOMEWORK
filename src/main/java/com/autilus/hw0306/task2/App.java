package com.autilus.hw0306.task2;

import java.util.logging.*;

public class App {
    public static void main(String[] args) {
    }

    private static void configureLogging() {
        Logger.getLogger("org.stepic.java.logging.ClassA").setLevel(Level.ALL);
        Logger.getLogger("org.stepic.java.logging.ClassB").setLevel(Level.WARNING);
        Logger logger = Logger.getLogger("org.stepic.java");
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new XMLFormatter());
        logger.setUseParentHandlers(false);
        logger.addHandler(handler);
    }
}
