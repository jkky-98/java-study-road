package task.gold.tomato;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ripeTomato {
    private List<List<List<Integer>>> tower;
    private int x;
    private int y;
    private int z;
    private Deque<List<Integer>> deque = new ArrayDeque<>();
    private int day;

    public int getDay() {
        return day;
    }

    public ripeTomato(List<List<List<Integer>>> tower, int x, int y, int z) {
        this.tower = tower;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setProcess() {
        for (int i=0; i < z; i++) {
            for (int j=0; j < y; j++) {
                for (int k=0; k < x; k++) {
                    if (tower.get(i).get(j).get(k).equals(1)) {
                        deque.offer(List.of(i,j,k));
                    }
                }
            }
        }
    }

    public boolean checkAll() {
        for (int i=0; i < z; i++) {
            for (int j=0; j < y; j++) {
                for (int k=0; k < x; k++) {
                    if (tower.get(i).get(j).get(k).equals(0)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int runProcess() {
        return 1;
    }

    private void riping(Integer Z, Integer Y, Integer X) {
        int z = Z;
        int x = X;
        int y = Y;

        if (z + 1 <= this.z-1) {
            if (tower.get(z+1).get(y).get(x) == 0)
            {
                tower.get(z+1).get(y).set(x, 1);
                deque.offer(List.of(z+1,y,x));
            }
        }
        if (z - 1 >= 0) {
            if (tower.get(z-1).get(y).get(x) == 0)
            {
                tower.get(z-1).get(y).set(x, 1);
                deque.offer(List.of(z-1,y,x));
            }
        }
        if (y + 1 <= this.y-1) {
            if (tower.get(z).get(y+1).get(x) == 0)
            {
                tower.get(z).get(y+1).set(x, 1);
                deque.offer(List.of(z,y+1,x));
            }
        }
        if (y - 1 >= 0) {
            if (tower.get(z).get(y-1).get(x) == 0)
            {
                tower.get(z).get(y-1).set(x, 1);
                deque.offer(List.of(z,y-1,x));
            }
        }
        if (x + 1 <= this.x-1) {
            if (tower.get(z).get(y).get(x+1) == 0)
            {
                tower.get(z).get(y).set(x+1, 1);
                deque.offer(List.of(z,y,x+1));
            }
        }
        if (x - 1 >= 0) {
            if (tower.get(z).get(y).get(x-1) == 0)
            {
                tower.get(z).get(y).set(x-1, 1);
                deque.offer(List.of(z,y,x-1));
            }
        }
    }
}
