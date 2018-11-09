import java.util.*;
public class CollectionsZad1 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();

        arr.add("A");
        arr.add("B");
        arr.add("A");
        arr.add("B");
        arr.add("C");
        arr.add("C");
        arr.add("A");
        arr.add("B");
        arr.add("B");
        arr.add("A");
        arr.add("A");
        arr.add("C");

        List<String> unique = new ArrayList<>();
        for (String x : arr) {
            if (!unique.contains(x))
                unique.add(x);
        }

        int[]res=new int[unique.size()];


        for (int i=0;i<unique.size();i++) {
            for (int j=0;j<arr.size();j++){
                if (unique.get(i).equals(arr.get(j)))
                    res[i]=res[i]+1;
            }
        }

        System.out.println(arr);
        System.out.println(unique);

        for (int i = 0; i < res. length; i++)
            System.out.println (unique.get(i)+" = " + res[i]);

    }
}
