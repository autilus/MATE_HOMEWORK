package com.autilus.hw1706.task1;

public class App {
    public static void main(String[] args) {
        App app = new App();
        System.out.println(getCallerClassAndMethodName());
        app.test();
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = new Exception().getStackTrace();
        if (stackTraceElements.length < 3) {
            return null;
        } else {
            return stackTraceElements[2].getClassName() + "#" + stackTraceElements[2].getMethodName();
        }
    }

    public void test() {
        System.out.println(getCallerClassAndMethodName());
    }
}
