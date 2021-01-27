import java.util.*;
import java.io.*;

public class Insult {
    private static ArrayList<String> adjectives = new ArrayList<String>();
    private static ArrayList<String> nouns = new ArrayList<String>();
    public static void main(String[] args) throws FileNotFoundException {
        initialize();
        boolean cont = true;
        Scanner reader = new Scanner(System.in);

        while(cont) {
            System.out.println("How many adjectives? (0 to end session)");
            int numAdjs = reader.nextInt();
            if(numAdjs == 0) {
                cont = false;
            } else {
                System.out.println(generateInsult(numAdjs));
            }
        }
    }

    public static String generateInsult(int adj) {
        String insult = "";
        for(int i = 0; i < adj; i++) {
            insult += getAdj() + " ";
        }
        insult += getNoun();
        return insult;
    }

    public static void initialize() throws FileNotFoundException {
        readAdjectives();
        readNouns();
    }

    public static void readAdjectives() throws FileNotFoundException {
        Scanner readAdj = new Scanner(new File("C:\\Users\\Remote\\Documents\\Insult Generator\\adjectives.txt"));
        while(readAdj.hasNextLine()) {
            adjectives.add(readAdj.nextLine());
        }
    }

    public static void readNouns() throws FileNotFoundException {
        Scanner readNoun = new Scanner(new File("C:\\Users\\Remote\\Documents\\Insult Generator\\nouns.txt"));
        while(readNoun.hasNextLine()) {
            nouns.add(readNoun.nextLine());
        }
    }

    public static String getAdj() {
        int ind = (int) (Math.random() * adjectives.size());
        String ret = adjectives.get(ind);
        adjectives.remove(ind);
        return ret;
    }

    public static String getNoun() {
        int ind = (int) (Math.random() * nouns.size());
        String ret = nouns.get(ind);
        nouns.remove(ind);
        return ret;
    }
}