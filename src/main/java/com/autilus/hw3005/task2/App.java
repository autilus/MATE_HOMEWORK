package com.autilus.hw3005.task2;

public class App {
    public static void main(String[] args) {
        String[] roles = {
                "Gorodnichij", "Ammos Fedorovich",
                "Artemij Filippovich",
                "Luka Lukich"
        };
        String[] textLines = {
                "Gorodnichij: Ja priglasil vas, gospoda, s tem, chtoby soobshhit' vam preneprijatnoe izvestie: k nam edet revizor.",
                "Ammos Fedorovich: Kak revizor?",
                "Artemij Filippovich: Kak revizor?",
                "Gorodnichij: Revizor iz Peterburga, inkognito. I eshhe s sekretnym predpisan'em.",
                "Ammos Fedorovich: Vot te na!",
                "Artemij Filippovich: Vot ne bylo zaboty, tak podaj!",
                "Luka Lukich: Gospodi bozhe! eshhe i s sekretnym predpisan'em!"
        };
        App app = new App();
        System.out.println(app.printTextPerRole(roles, textLines));
    }

    private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int rolesIndex = 0; rolesIndex < roles.length; rolesIndex++) {
            stringBuilder.append("\n").append(roles[rolesIndex]).append(": ");
            for (int textLinesIndex = 0; textLinesIndex < textLines.length; textLinesIndex++) {
                if (textLines[textLinesIndex].startsWith(roles[rolesIndex] + ": ")) {
                    stringBuilder.append("\n").append(textLinesIndex + 1).append(") ")
                            .append(textLines[textLinesIndex].substring(roles[rolesIndex].length() + 2));
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
