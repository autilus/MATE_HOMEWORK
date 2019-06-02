package com.autilus.hw0306.task1;

public class MoveRobot {
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean isSuccess = false;
        RobotConnection robotConnection = null;
        for (int i = 0; !isSuccess && (i < 3); i++) {
            try {
                robotConnection = robotConnectionManager.getConnection();
                robotConnection.moveRobotTo(toX, toY);
                isSuccess = true;
                try {
                    robotConnection.close();
                } catch (Exception e) {
                }
            } catch (RobotConnectionException e) {
                if (robotConnection != null) {
                    robotConnection.close();
                }
            } catch (Exception e) {
                if (robotConnection != null) {
                    robotConnection.close();
                }
                throw e;
            }
        }
        if (!isSuccess) {
            throw new RobotConnectionException("3 attempts failed. Close connection...");
        }
    }
}