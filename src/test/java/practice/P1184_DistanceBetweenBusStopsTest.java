package practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1184_DistanceBetweenBusStopsTest {

    @Test
    void distanceBetweenBusStops() {
        int[] distance = {1,2,3,4};
        int start = 0;
        int destination =1;
        int expected =1;
        P1184_DistanceBetweenBusStops test = new P1184_DistanceBetweenBusStops();
        int result = test.distanceBetweenBusStops(distance,start,destination);
        assertEquals(expected,result);
    }
}