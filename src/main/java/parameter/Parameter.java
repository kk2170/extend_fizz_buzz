package parameter;

public class Parameter {
    public static int ARGUMENTS_LENGTH = 3;
    String[] arguments;
    String category;
    boolean isInvalid;
    int x;
    int y;

    public Parameter(String[] args) {
        arguments = args;
        isInvalid = false;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void checkAndSetValue() {
        if (arguments.length != ARGUMENTS_LENGTH) {
            System.out.println("引数を3個以上選択してください。");
            isInvalid = true;
            return;
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
            isInvalid = true;
        }

        if (value <= 0) {
            System.out.println("引数には1以上の数字を入力してください。");
            isInvalid = true;
        }

        return value;
    }

    public boolean isInvalid() {
        return isInvalid;
    }

    public String getCategory() {
        return category;
    }
}
