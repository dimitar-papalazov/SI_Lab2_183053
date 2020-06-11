import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    SILab2 siLab2 = new SILab2();
    List<Angle> angles = new ArrayList<Angle>();
    Angle angle1 = new Angle(1, -1, 2);
    Angle angle2 = new Angle(1, 2, -3);
    Angle angle3 = new Angle(361, 59, 59);
    Angle angle4 = new Angle(360, 0, 1);
    Angle angle5 = new Angle(0, 0, 1);
    Angle angle6 = new Angle(360, 0, 0);
    Angle angle7 = new Angle(-1, -2, -3);
    Angle angle8 = new Angle(0, 60, 0);
    Angle angle9 = new Angle(1, 2, 62);
    Angle angle10 = new Angle(360, 1, 0);


    @Test
    void testEveryPath() {
        RuntimeException re;

        //1,2, 3.1, 3.2, 4,5,6, 7, 8, 9, 24
        angles.add(angle1);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The minutes of the angle are " +
                "not valid!"));

        //1,2, 3.1, 3.2, 4,5,6, 7, 8, 10,11, 12, 24
        angles.clear();
        angles.add(angle2);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The seconds of the angle " +
                "are not valid"));

        //1,2, 3.1, 3.2, 4,5,6, 7, 15, 20,21, 24
        angles.clear();
        angles.add(angle3);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The angle is smaller or greater " +
                "then the minimum"));

        //1,2, 3.1, 3.2, 4,5,6, 7, 15, 16, 18,19, 24
        angles.clear();
        angles.add(angle4);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The angle is greater then the" +
                " maximum"));

        //1,2, 3.1, (3.2, 4,5,6, 7, 8, 10,11, 13, 14, 22, 3.3, 3.2), 23, 24
        angles.clear();
        angles.add(angle5);
        assertEquals(1, SILab2.function(angles).get(0));

        //1,2, 3.1, (3.2, 4,5,6, 7, 8, 10,11, 13, 14, 22, 3.3, 3.2), 4,5,6, 7, 8, 9, 24
        angles.clear();
        angles.add(angle5);
        angles.add(angle1);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The minutes of the angle are " +
                "not valid!"));

        //1,2, 3.1, (3.2, 4,5,6, 7, 8, 10,11, 13, 14, 22, 3.3, 3.2), 4,5,6, 7, 8, 10,11, 12, 24
        angles.clear();
        angles.add(angle5);
        angles.add(angle2);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The seconds of the angle " +
                "are not valid"));

        //1,2, 3.1, (3.2, 4,5,6, 7, 8, 10,11, 13, 14, 22, 3.3, 3.2), 4,5,6, 7, 15, 20,21, 24
        angles.clear();
        angles.add(angle5);
        angles.add(angle3);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The angle is smaller or greater " +
                "then the minimum"));

        //1,2, 3.1, (3.2, 4,5,6, 7, 8, 10,11, 13, 14, 22, 3.3, 3.2), 4,5,6, 7, 15, 16, 18,19, 24
        angles.clear();
        angles.add(angle5);
        angles.add(angle4);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The angle is greater then the" +
                " maximum"));

        //1,2, 3.1, (3.2, 4,5,6, 7, 15, 16, 17, 22, 3.3, 3.2), 23, 24
        angles.clear();
        angles.add(angle6);
        assertEquals(1296000, SILab2.function(angles).get(0));

        //1,2, 3.1, (3.2, 4,5,6, 7, 15, 16, 17, 22, 3.3, 3.2), 4,5,6, 7, 8, 9, 24
        angles.clear();
        angles.add(angle6);
        angles.add(angle1);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The minutes of the angle are " +
                "not valid!"));

        //1,2, 3.1, (3.2, 4,5,6, 7, 15, 16, 17, 22, 3.3, 3.2), 4,5,6, 7, 8, 10,11, 12, 24
        angles.clear();
        angles.add(angle6);
        angles.add(angle2);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The seconds of the angle " +
                "are not valid"));

        //1,2, 3.1, (3.2, 4,5,6, 7, 15, 16, 17, 22, 3.3, 3.2), 4,5,6, 7, 15, 20,21, 24
        angles.clear();
        angles.add(angle6);
        angles.add(angle3);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The angle is smaller or greater " +
                "then the minimum"));

        //1,2, 3.1, (3.2, 4,5,6, 7, 15, 16, 17, 22, 3.3, 3.2), 4,5,6, 7, 15, 16, 18,19, 24
        angles.clear();
        angles.add(angle6);
        angles.add(angle4);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The angle is greater then the" +
                " maximum"));

        //1,2, 3.1, (3.2, 4,5,6, 7, 15, 16, 17, 22, 3.3, 3.2), (3.2, 4,5,6, 7, 8, 10,11, 13, 14, 22, 3.3, 3.2), 23, 24
        angles.clear();
        angles.add(angle6);
        angles.add(angle5);
        assertEquals(1296001,
                SILab2.function(angles).get(0) + SILab2.function(angles).get(1));

        //mixed = (3.2, 4,5,6, 7, 15, 16, 17, 22, 3.3, 3.2), (3.2, 4,5,6, 7, 8, 10,11, 13, 14, 22, 3.3, 3.2)
        //1,2, 3.1, mixed, 4,5,6, 7, 8, 9, 24
        angles.clear();
        angles.add(angle6);
        angles.add(angle5);
        angles.add(angle1);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The minutes of the angle are " +
                "not valid!"));

        //1,2, 3.1, mixed, 4,5,6, 7, 8, 10,11, 12, 24
        angles.clear();
        angles.add(angle5);
        angles.add(angle6);
        angles.add(angle2);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The seconds of the angle " +
                "are not valid"));

        //1,2, 3.1, mixed, 4,5,6, 7, 15, 20,21, 24
        angles.clear();
        angles.add(angle6);
        angles.add(angle5);
        angles.add(angle3);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The angle is smaller or greater " +
                "then the minimum"));

        //1,2, 3.1, mixed, 4,5,6, 7, 15, 16, 18,19, 24
        angles.clear();
        angles.add(angle5);
        angles.add(angle6);
        angles.add(angle4);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The angle is greater then the" +
                " maximum"));

        angles.clear();
    }

    @Test
    void testMultipleCondition() {
        RuntimeException re;

        //(deg >= 0 && deg < 360)
        //T && T
        angles.add(angle1);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The minutes of the angle are " +
                "not valid!"));

        //F && T
        angles.clear();
        angles.add(angle7);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The angle is smaller or greater " +
                "then the minimum"));

        //T && F
        //F && F same for both
        angles.clear();
        angles.add(angle3);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The angle is smaller or greater " +
                "then the minimum"));

        //(min < 0 || min > 59)
        //T || T not possible

        //T || F
        angles.clear();
        angles.add(angle1);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The minutes of the angle are " +
                "not valid!"));

        //F || T
        angles.clear();
        angles.add(angle8);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The minutes of the angle are " +
                "not valid!"));

        //F || F same as the upper 2 cases, will use the 2nd
        angles.clear();
        angles.add(angle8);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The minutes of the angle are " +
                "not valid!"));

        //(sec < 0 || sec > 59)
        //T || T not possible

        //T || F
        angles.clear();
        angles.add(angle2);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The seconds of the angle " +
                "are not valid"));

        //F || T
        angles.clear();
        angles.add(angle9);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The seconds of the angle " +
                "are not valid"));

        //F || F same as the upper 2 cases, will use the 2nd
        angles.clear();
        angles.add(angle9);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The seconds of the angle " +
                "are not valid"));

        //(deg == 360)
        //T
        angles.clear();
        angles.add(angle5);
        assertEquals(1, SILab2.function(angles).get(0));

        //F
        angles.clear();
        angles.add(angle3);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The angle is smaller or greater " +
                "then the minimum"));

        //(min == 0 && sec == 0)
        //T && T
        angles.clear();
        angles.add(angle6);
        assertEquals(1296000, SILab2.function(angles).get(0));

        //T && F
        angles.clear();
        angles.add(angle4);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The angle is greater then the" +
                " maximum"));

        //F && T
        angles.clear();
        angles.add(angle10);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The angle is greater then the" +
                " maximum"));

        //F && F same as the upper 2 cases, will use the 2nd
        angles.clear();
        angles.add(angle4);
        re = assertThrows(RuntimeException.class,
                () -> SILab2.function(angles));
        assertTrue(re.getMessage().contains("The angle is greater then the" +
                " maximum"));

        angles.clear();
    }
}