public class Zad2 {
    public static void main(String[] args) {
        try {
            String[][] mass = {{"10","68","6","9"},
                               {"0","5","4","6"},
                               {"9","2","7","8"},
                               {"5","2","6","2"}};
            System.out.println(Massive.getMassive(mass));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException(String msg) {
        super(msg);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String msg) {
        super(msg);
    }
}


class Massive {

    public static int getMassive(String[][] s) throws MyArraySizeException, MyArrayDataException {
        if (s.length != 4) {
            throw new MyArraySizeException("Неверная размерность массива");
        }

        for (int i = 0; i < s.length; i++) {
            if (s[i].length != 4) throw new MyArraySizeException("Неверная размерность массива");

        }

        int[][] numbers = new int[4][4];
        int res = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(!checkString(s[i][j]))throw new MyArrayDataException("Строка "+ s[i][j] +" не является числом!");
                numbers[i][j] = Integer.parseInt(s[i][j]);
                res = res + numbers[i][j];
            }
        }
        return res;
    }

    public static boolean checkString(String string) {
        if (string == null || string.length() == 0) return false;

        int i = 0;
        if (string.charAt(0) == '-') {
            if (string.length() == 1) {
                return false;
            }
            i = 1;
        }

        char c;
        for (; i < string.length(); i++) {
            c = string.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }
}
