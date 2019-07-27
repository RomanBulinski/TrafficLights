import java.util.Arrays;

public class Main {


    public static String[] trafficLights(String road, int n) {

        String[] result = new String[n+1];

        int indexG = road.indexOf('G');
        int indexR = road.indexOf('R');
        int indexCar = road.indexOf('C');

        char[] charRoad = road.toCharArray();

        int lightCounter = 1;
        int counter = 0;

        while(counter<=n){

            if( lightCounter<6 ) {
                charRoad[indexG] = 'G';
                charRoad[indexR] = 'R';
            }
            if( lightCounter==6 ){
                charRoad[indexG] = 'O';
                charRoad[indexR] = 'G';
            }
            if( lightCounter>6 && lightCounter<11 ) {
                charRoad[indexG] = 'R';
                charRoad[indexR] = 'G';
            }
            if( lightCounter==11 ) {
                charRoad[indexG] = 'R';
                charRoad[indexR] = 'O';
            }

            if(lightCounter==11){
                lightCounter=0;
            }

            if(charRoad[indexCar]!='R'){
                charRoad[indexCar] = 'C';
                if((indexCar-1)==indexG || (indexCar-1)==indexR){
                    charRoad[indexCar-1] = 'G';
                }else if(indexCar>0){
                    charRoad[indexCar-1] = '.';
                }
            }else{
                indexCar--;
            }
            indexCar++;
            result[counter]=String.valueOf(charRoad);
            lightCounter++;
            counter++;
        }

        Arrays.asList(result).stream().forEach(e-> System.out.println(e));

        return result;
    }

}
