package task.gold.tomato;

import java.util.ArrayList;
import java.util.List;

public class tomatoPlate {
    int x;
    int y;
    List<List<Integer>> plate = new ArrayList<>(new ArrayList<>());
    int count = 0;

    public tomatoPlate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void placeOf(List<Integer> inputList) {
        plate.add(inputList);
        count++;
    }

    public List<List<Integer>> getPlate() {
        return plate;
    }

}
