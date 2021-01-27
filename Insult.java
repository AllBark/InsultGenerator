import java.util.*;
import java.io.*;

public class Insult {
    private static ArrayList<String> adjectives = new ArrayList<String>();
    private static ArrayList<String> nouns = new ArrayList<String>();
    private static ArrayList<String> sillyAdjectives = new ArrayList<String>();
    private static ArrayList<String> sillyNouns = new ArrayList<String>();
    private static ArrayList<String> weakAdjectives = new ArrayList<String>();
    private static ArrayList<String> weakNouns = new ArrayList<String>();
    private static ArrayList<String> meanAdjectives = new ArrayList<String>();
    private static ArrayList<String> meanNouns = new ArrayList<String>();
    private static ArrayList<String> previous = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException {
        initialize();
        boolean cont = true;
        Scanner reader = new Scanner(System.in);

        while(cont) {
            System.out.println("How many adjectives?\n(-1 to end session)\n(-2 to repeat previous)");
            System.out.println("(-3 to do all random)\n(-4 to do all silly)\n(-5 to do all weak)");
            System.out.println("(-6 to do all mean)");
            int numAdjs = reader.nextInt();
            if(numAdjs == -1) {
                cont = false;
            }
            else if (numAdjs == -3) {
                String finalInsult = getAdj("!random") + getNoun("!random");
                System.out.println(finalInsult);
            }
            else if (numAdjs == -4) {
                String finalInsult = getAdj("!silly") + getNoun("!silly");
                System.out.println(finalInsult);
            }
            else if (numAdjs == -5) {
                String finalInsult = getAdj("!weak") + getNoun("!weak");
                System.out.println(finalInsult);
            }
            else if (numAdjs == -6) {
                String finalInsult = getAdj("!mean") + getNoun("!mean");
                System.out.println(finalInsult);
            }
            else if (numAdjs == -2) {
                if(previous.isEmpty()) {
                    System.out.println("No previous preferences.");
                } else {
                    String finalInsult = "";
                    for(int i = 0; i < previous.size() - 1; i++) {
                        finalInsult += getAdj(previous.get(i));
                    }
                    finalInsult += getNoun(previous.get(previous.size() - 1));
                    System.out.println(finalInsult);
                }
            }
            else {
                previous = new ArrayList<String>();
                String finalInsult = "";
                for(int i = 0; i < numAdjs; i++) {
                    System.out.println("What type of adjective should Adjective " + i + " be?");
                    System.out.println("(r, s, w, m)");
                    String type = reader.next();
                    switch (type) {
                        case "r":
                        type = "!random";
                        break;
                        case "s":
                        type = "!silly";
                        break;
                        case "w":
                        type = "!weak";
                        break;
                        case "m":
                        type = "!mean";
                        break;
                        default:
                        System.out.println("Big no-no 2.0");
                        break;
                    }
                    finalInsult += getAdj(type);
                    previous.add(type);
                }
                System.out.println("What type of noun should your noun be?");
                System.out.println("(r, s, w, m)");
                String type = reader.next();
                switch (type) {
                    case "r":
                    type = "!random";
                    break;
                    case "s":
                    type = "!silly";
                    break;
                    case "w":
                    type = "!weak";
                    break;
                    case "m":
                    type = "!mean";
                    break;
                    default:
                    System.out.println("Big no-no 2.1");
                    break;
                }
                finalInsult += getNoun(type);
                previous.add(type);
                System.out.println(finalInsult);
            }
        }
    }

    public static void initialize() throws FileNotFoundException {
        readAdjectives();
        readNouns();
    }

    public static void readAdjectives() throws FileNotFoundException {
        String[] types = {"!silly", "!weak", "!mean", "!random"};
            for(String type : types) {
            Scanner readAdj = new Scanner(new File("C:\\Users\\Remote\\Documents\\Insult Generator\\adjectives.txt"));
            while(readAdj.hasNextLine()) {
                String n = readAdj.nextLine();
                switch (type) {
                    case "!random":
                    adjectives.add(n.replace("!silly", "").replace("!weak", "").replace("!mean", ""));
                    break;
                    case "!silly":
                    if(n.contains(type)) {
                        sillyAdjectives.add(n.replace(type, ""));
                    }
                    break;
                    case "!weak":
                    if(n.contains(type)) {
                        weakAdjectives.add(n.replace(type, ""));
                    }
                    break;
                    case "!mean":
                    if(n.contains(type)) {
                        meanAdjectives.add(n.replace(type, ""));
                    }
                    break;
                    default:
                    System.out.println("Big no-no 0.0");
                    break;
                }
            }
        }
    }

    public static void readNouns() throws FileNotFoundException {
        String[] types = {"!silly", "!weak", "!mean", "!random"};
            for(String type : types) {
            Scanner readNoun = new Scanner(new File("C:\\Users\\Remote\\Documents\\Insult Generator\\nouns.txt"));
            while(readNoun.hasNextLine()) {
                String n = readNoun.nextLine();
                switch (type) {
                    case "!random":
                    nouns.add(n.replace("!silly", "").replace("!weak", "").replace("!mean", ""));
                    break;
                    case "!silly":
                    if(n.contains(type)) {
                        sillyNouns.add(n.replace(type, ""));
                    }
                    break;
                    case "!weak":
                    if(n.contains(type)) {
                        weakNouns.add(n.replace(type, ""));
                    }
                    break;
                    case "!mean":
                    if(n.contains(type)) {
                        meanNouns.add(n.replace(type, ""));
                    }
                    break;
                    default:
                    System.out.println("Big no-no 0.1");
                    break;
                }
            }
        }
    }

    public static String getAdj(String type) {
        String ret;
        switch (type) {
            case "!random":
            int indA = (int) (Math.random() * adjectives.size());
            if(adjectives.size() == 0) {
                ret = "[Out of " + type + " adjectives]";
            }
            else {
                ret = adjectives.get(indA);
                adjectives.remove(indA);
            }
            break;
            case "!silly":
            int indB = (int) (Math.random() * sillyAdjectives.size());
            if(sillyAdjectives.size() == 0) {
                ret = "[Out of " + type + " adjectives]";
            }
            else {
                ret = sillyAdjectives.get(indB);
                sillyAdjectives.remove(indB);
            }
            break;
            case "!weak":
            int indC = (int) (Math.random() * weakAdjectives.size());
            if(weakAdjectives.size() == 0) {
                ret = "[Out of " + type + " adjectives]";
            }
            else {
                ret = weakAdjectives.get(indC);
                weakAdjectives.remove(indC);
            }
            break;
            case "!mean":
            int indD = (int) (Math.random() * meanAdjectives.size());
            if(meanAdjectives.size() == 0) {
                ret = "[Out of " + type + " adjectives]";
            }
            else {
                ret = meanAdjectives.get(indD);
                meanAdjectives.remove(indD);
            }
            break;
            default:
            System.out.println("Big no-no 1.0");
            ret = "Big no-no 1.0";
            break;
        }
        return ret;
    }

    public static String getNoun(String type) {
        String ret;
        switch (type) {
            case "!random":
            int indA = (int) (Math.random() * nouns.size());
            if(nouns.size() == 0) {
                ret = "[Out of " + type + " nouns]";
            }
            else {
                ret = nouns.get(indA);
                nouns.remove(indA);
            }
            break;
            case "!silly":
            int indB = (int) (Math.random() * sillyNouns.size());
            if(sillyNouns.size() == 0) {
                ret = "[Out of " + type + " nouns]";
            }
            else {
                ret = sillyNouns.get(indB);
                sillyNouns.remove(indB);
            }
            break;
            case "!weak":
            int indC = (int) (Math.random() * weakNouns.size());
            if(weakNouns.size() == 0) {
                ret = "[Out of " + type + " nouns]";
            }
            else {
                ret = weakNouns.get(indC);
                weakNouns.remove(indC);
            }
            break;
            case "!mean":
            int indD = (int) (Math.random() * meanNouns.size());
            if(meanNouns.size() == 0) {
                ret = "[Out of " + type + " nouns]";
            }
            else {
                ret = meanNouns.get(indD);
                meanNouns.remove(indD);
            }
            break;
            default:
            System.out.println("Big no-no 1.0");
            ret = "Big no-no 1.0";
            break;
        }
        return ret;
    }
}
