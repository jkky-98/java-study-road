package task.tomato;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class tomatoTower {

    private List<List<List<Integer>>> tower = new ArrayList<>();


    public void setTower(List<tomatoPlate> plates) {
        for (tomatoPlate plate : plates) {
            tower.add(plate.getPlate());
        }
    }

    public List<List<List<Integer>>> getTower() {
        return tower;
    }
}
