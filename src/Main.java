import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String filepath="liczby.txt";
        ArrayList<String>liczby=Download(filepath);
        System.out.println("Więcej zer niż jedynek:");
        System.out.println(Zad1(liczby));
        for(String i:Zad2(liczby)){
            System.out.println(i);
        }
        for(String j:Zad3(liczby)){
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
    public static int Zad1 (ArrayList<String> liczby){
        int count=0;
        for(String i:liczby){
            int ones=0;
            int zeros=0;
            char[]cyfry=i.toCharArray();
            for(char j:cyfry){
                if(j=='1'){
                    ones++;
                }
                else if(j=='0') {
                    zeros++;
                }
            }
            if(zeros>ones){
                count++;
            }
        }
        return count;
    }
public static ArrayList<String> Zad2 (ArrayList<String>liczby){
        ArrayList<String>wynik=new ArrayList<>();
        int count2=0;
      int count8=0;
      for(String i:liczby){
        float num=Float.parseFloat(i);
        if(num%2==0){
            count2++;
        }
        if(num%8==0){
            count8++;
        }
      }
    wynik.add("Podzielne przez 2:");
     wynik.add(Integer.toString(count2));
     wynik.add("Podzielne przez 8:");
     wynik.add(Integer.toString(count8));
     return wynik;
}
public static  ArrayList<String> Zad3(ArrayList<String> liczby){
        ArrayList<String>wynik=new ArrayList<>();
        float min=Float.MAX_VALUE;
        int minindex=0;
        float max=0;
        int maxindex=0;
        for(int i=0;i<liczby.size();i++){
            String numstr=liczby.get(i);
            float num=Float.parseFloat(numstr);
            if(num>max){
                max=num;
                maxindex=i;
            }
            if(num<min){
                min=num;
                minindex=i;
            }
        }
        wynik.add("Index największej");
        wynik.add(Integer.toString(maxindex));
        wynik.add("Index najmniejszej");
        wynik.add(Integer.toString(minindex));
        return wynik;
    }
}