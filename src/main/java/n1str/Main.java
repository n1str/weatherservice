package n1str;

import n1str.client.menu.ScriptMenuInfo;
import n1str.client.menu.ScriptMenuLogic;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        if (Config.API_KEY == "") {
            ScriptMenuInfo.startInfo();
        } else {
            while (true) {
                ScriptMenuInfo.latInfoMenu();
                String getLat = scanner.nextLine();
                ScriptMenuInfo.lonInfoMenu();
                String getLon = scanner.nextLine();
                ScriptMenuInfo.PeriodInfoMenu();

                char choice = scanner.nextLine().charAt(0);

                if (choice == '1') {
                    ScriptMenuLogic.getAvgTemp(scanner, getLat, getLon);
                    char switchExit = scanner.nextLine().charAt(0);
                    if (switchExit == '0') {
                        break;
                    } else if (switchExit == '1') {
                        continue;
                    }
                } else {
                    ScriptMenuLogic.getFactTemp(scanner, getLat, getLon);
                    char switchExit = scanner.nextLine().charAt(0);
                    if (switchExit == '0') {
                        break;
                    } else if (switchExit == '1') {
                        continue;
                    }
                }
            }
        }
    }
}