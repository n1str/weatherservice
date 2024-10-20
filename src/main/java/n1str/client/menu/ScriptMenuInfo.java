package n1str.client.menu;

public class ScriptMenuInfo {
    public static void script() {
        System.out.println("0 - Выход из программы");
        System.out.println("1 - Продолжить");
        System.out.println("____________________________________________________________");
    }

    public static void PeriodInfoMenu() {
        System.out.println("____________________________________________________________");
        System.out.println("Хотели ли бы Вы задать период?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
        System.out.println("____________________________________________________________");
    }

    public static void latInfoMenu() {
        System.out.println("Введите точку lat: ");
        System.out.println("____________________________________________________________");
    }

    public static void lonInfoMenu() {
        System.out.println("Введите точку lon: ");
        System.out.println("____________________________________________________________");
    }

    public static void visualSplitter() {
        System.out.println("____________________________________________________________");
    }

    public static void startInfo() {
        System.out.println("Введите свой api-ключ в config.java");
    }
}
