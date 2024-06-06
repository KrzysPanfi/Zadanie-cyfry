import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String filepath = "liczby.txt";
        ArrayList<String> liczby = Download(filepath);
        System.out.println("Więcej zer niż jedynek:");
        System.out.println(Zad1(liczby));
        for (String i : Zad2(liczby)) {
            System.out.println(i);
        }
        for (String j : Zad3(liczby)) {
            System.out.println(j);
        }
    }

    public static ArrayList<String> Download(String filepath) {
        ArrayList<String> Wynik = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                Wynik.add(line);
            }
            bufferedReader.close();
            return Wynik;

        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }

    public static int Zad1(ArrayList<String> liczby) {
        int count = 0;
        for (String i : liczby) {
            int ones = 0;
            int zeros = 0;
            char[] cyfry = i.toCharArray();
            for (char j : cyfry) {
                if (j == '1') {
                    ones++;
                } else if (j == '0') {
                    zeros++;
                }
            }
            if (zeros > ones) {
                count++;
            }
        }
        return count;
    }

    public static ArrayList<String> Zad2(ArrayList<String> liczby) {
        ArrayList<String> wynik = new ArrayList<>();
        int count2 = 0;
        int count8 = 0;
        for (String i : liczby) {
            char[] chars = i.toCharArray();
            if (chars[chars.length - 1] == '0') {
                count2++;
            }
            if (chars[chars.length - 1] == '0' && chars[chars.length - 2] == '0' && chars[chars.length - 3] == '0') {
                count8++;
            }
        }
        wynik.add("Podzielne przez 2:");
        wynik.add(Integer.toString(count2));
        wynik.add("Podzielne przez 8:");
        wynik.add(Integer.toString(count8));
        return wynik;
    }

    // 1011101
    //
    public static ArrayList<String> Zad3(ArrayList<String> liczby) {
        ArrayList<String> wynik = new ArrayList<>();
        BigInteger min = BigInteger.valueOf(Long.MAX_VALUE);
        int minindex = 0;
        BigInteger max = BigInteger.ZERO;
        int maxindex = 0;
        for (int i = 0; i < liczby.size(); i++) {
            String numstr = liczby.get(i);
            BigInteger bigint = new BigInteger(numstr, 2);
            if (bigint.compareTo(max) > 0) {
                max = bigint;
                maxindex = i;
            }
            if (bigint.compareTo(min) < 0) {
                min = bigint;
                minindex = i;
            }
        }
        wynik.add("Index największej:");
        wynik.add(Integer.toString(maxindex));
        wynik.add("Index najmniejszej:");
        wynik.add(Integer.toString(minindex));
        return wynik;
    }
}