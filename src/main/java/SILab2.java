import java.util.ArrayList;
import java.util.List;

class Angle {
    int degrees;
    int minutes;
    int seconds;

    public Angle(int degrees, int minutes, int seconds) {
        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getDegrees() {
        return degrees;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
};

public class SILab2 {

    public static List<Integer> function(List<Angle> angleList) { //1
        List<Integer> result = new ArrayList<>(); //2

        for (int i = 0; i < angleList.size(); i++) { //3.1 3.2 3.3
            int deg = angleList.get(i).getDegrees(); //4
            int min = angleList.get(i).getMinutes(); //5
            int sec = angleList.get(i).getSeconds(); //6
            if (deg >= 0 && deg < 360) { //7
                if (min < 0 || min > 59) //8
                    throw new RuntimeException("The minutes of the angle are " +
                            "not valid!"); //9
                else { //10
                    if (sec < 0 || sec > 59) //11
                        throw new RuntimeException("The seconds of the angle " +
                                "are not valid"); //12
                    else //13
                        result.add(deg * 3600 + min * 60 + sec); //14
                }
            } else if (deg == 360) { //15
                if (min == 0 && sec == 0) //16
                    result.add(deg * 3600 + min * 60 + sec); //17
                else //18
                    throw new RuntimeException("The angle is greater then the" +
                            " maximum"); //19
            } else { //20
                throw new RuntimeException("The angle is smaller or greater " +
                        "then the minimum"); //21
            }
        } //22
        return result; //23
    } //24
}

