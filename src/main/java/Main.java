import java.util.*;

public class Main {


    public static String[] trafficLights(String road, int n) {

        char[] charRoad = road.toCharArray();
        String[] result = new String[n + 1];
        Map<Character, List<Integer>> lightsPos = getCharacterListMap(charRoad);

        int indexCar = road.indexOf('C');
        int lightCounter = 1;
        int counter = 0;

        while (counter <= n) {

            for (int j = 0; j < lightsPos.get('G').size(); j++) {
                if (lightCounter < 6) {
                    charRoad[lightsPos.get('G').get(j)] = 'G';
                }
                if (lightCounter == 6) {
                    charRoad[lightsPos.get('G').get(j)] = 'O';
                }
                if (lightCounter > 6 && lightCounter < 11) {
                    charRoad[lightsPos.get('G').get(j)] = 'R';
                }
                if (lightCounter == 11)
                    charRoad[lightsPos.get('G').get(j)] = 'R';
            }

            for (int z = 0; z < lightsPos.get('R').size(); z++) {
                if (lightCounter < 6) {
                    charRoad[lightsPos.get('R').get(z)] = 'R';
                }
                if (lightCounter < 6) {
                    charRoad[lightsPos.get('R').get(z)] = 'G';
                }
                if (lightCounter > 6 && lightCounter < 11) {
                    charRoad[lightsPos.get('R').get(z)] = 'G';
                }
                if (lightCounter == 11) {
                    charRoad[lightsPos.get('R').get(z)] = 'O';
                }
            }

            if (lightCounter == 11) lightCounter = 0;

            if (indexCar < charRoad.length) {
                if (charRoad[indexCar] == '.' || charRoad[indexCar] == 'G') {
                    charRoad[indexCar] = 'C';
                    if (lightsPos.get('R').contains(indexCar - 1) || lightsPos.get('G').contains(indexCar - 1)) {
                    } else if (indexCar > 0) {
                        charRoad[indexCar - 1] = '.';
                    }
                } else if (charRoad[indexCar] == 'R' || charRoad[indexCar] == 'O') {
                    indexCar--;
                }
            } else if (indexCar > charRoad.length - 1) {
                if (lightsPos.get('R').contains(charRoad.length - 1) || lightsPos.get('G').contains(charRoad.length - 1)) {
                } else {
                    charRoad[charRoad.length - 1] = '.';
                }
            }
            indexCar++;
            result[counter] = String.valueOf(charRoad);
            lightCounter++;
            counter++;
        }
        Arrays.stream(result).forEach(e -> System.out.println(e));
        return result;
    }

    private static Map<Character, List<Integer>> getCharacterListMap(char[] charRoad) {
        Map<Character, List<Integer>> lightsPos = new HashMap<>();
        lightsPos.put('G', new ArrayList<>());
        lightsPos.put('R', new ArrayList<>());

        for (int i = 0; i < charRoad.length; i++) {
            if (charRoad[i] == 'R') lightsPos.get('R').add(i);
            if (charRoad[i] == 'G') lightsPos.get('G').add(i);
        }
        return lightsPos;
    }


}
