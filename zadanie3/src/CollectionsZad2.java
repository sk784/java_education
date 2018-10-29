import java.util.*;
public class CollectionsZad2 {
    public static void main(String[] args) {
        PhoneDirectory.add(11111,"Кузнецов");
        PhoneDirectory.add(22222,"Иванов");
        PhoneDirectory.add(33333,"Петров");
        PhoneDirectory.add(44444,"Петров");
        System.out.println(PhoneDirectory.pd);
        PhoneDirectory.get("Петров");

    }
}


class PhoneDirectory {
static Map<Integer, String> pd = new HashMap<>();
    static void add(int phone, String surname) {
        pd.put(phone, surname);

    }


    static void get(String surname) {
        Set<Map.Entry<Integer, String>> set = pd.entrySet();
        for(Map.Entry<Integer, String> me: set) {
            if(surname.equals(me.getValue()))
            System.out.println("Телефон этого абонента: " + me.getKey());
        }
    }
}
