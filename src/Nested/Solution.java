import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.security.*;

public class Solution {

    public static void main(String[] args) throws Exception {


        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());


            Object o = new Inner().new Private();


            Method m = o.getClass().getDeclaredMethod("powerof2", int.class);
            m.setAccessible(true);
            String result = (String) m.invoke(o, num);

            System.out.println(num + " is " + result);
            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

        } catch (Exception e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }

    static class Inner {
        private class Private {
            private String powerof2(int num) {
                return ((num & (num - 1)) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }
}
