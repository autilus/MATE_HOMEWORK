package com.autilus.hw0406.task1;

public class MoveRobot {
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean isSuccess = false;
        for (int i = 0; !isSuccess && (i < 3); i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
                isSuccess = true;
            } catch (RobotConnectionException e) {
            }
        }
        if (!isSuccess) {
            throw new RobotConnectionException("3 attempts failed. Close connection...");
        }
    }
}
