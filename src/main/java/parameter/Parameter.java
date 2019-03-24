package parameter;

public class Parameter {
    public static int ARGUMENTS_LENGTH = 3;
    SystemProvider systemProvider = new SystemProvider();
    String[] arguments;
    String category;
    int x;
    int y;

    public Parameter(String[] args) {
        arguments = args;
        check();
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void check() {
        if (arguments.length != ARGUMENTS_LENGTH) {
            System.out.println("引数を3個以上選択してください。");
            systemProvider.errorExit();
        }

        category = arguments[0];

        x = checkIntValue(arguments[1]);
        y = checkIntValue(arguments[2]);
    }

    private int checkIntValue(String arg) {
        int value = 0;

        try {
            value = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            System.out.println("引数に数字以外が入力されています。");
            e.printStackTrace();
            systemProvider.errorExit();
        }

        if (value <= 0) {
            System.out.println("引数には1以上の数字を入力してください。");
            systemProvider.errorExit();
        }

        return value;
    }


    public String getCategory() {
        return category;
    }
}
