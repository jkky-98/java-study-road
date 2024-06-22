package task.tomato;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MainTime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long startTime = System.currentTimeMillis();

        String xyzinput = br.readLine();
        StringTokenizer st = new StringTokenizer(xyzinput, " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        long inputTime = System.currentTimeMillis();

        List<tomatoPlate> tomatoPlates = new ArrayList<>();
        for (int i = 0; i < z; i++) {
            tomatoPlate tomatoPlate = new tomatoPlate(x, y);
            for (int j = 0; j < y; j++) {
                String tomatoString = br.readLine();
                StringTokenizer stLine = new StringTokenizer(tomatoString, " ");
                List<Integer> tmp = new ArrayList<>();
                while (stLine.hasMoreTokens()) {
                    tmp.add(Integer.parseInt(stLine.nextToken()));
                }
                tomatoPlate.placeOf(tmp);
            }
            tomatoPlates.add(tomatoPlate);
        }

        long tomatoPlateTime = System.currentTimeMillis();

        // 타워 생성
        tomatoTower tomatoTower = new tomatoTower();
        // 토마토 층 넣기
        tomatoTower.setTower(tomatoPlates);
        ripeTomato ripeTomato = new ripeTomato(Main.tomatoTower.getTower(), x, y, z);

        long towerSetupTime = System.currentTimeMillis();

        while (true) {
            ripeTomato.setProcess();
            int result = ripeTomato.runProcess();
            if (result == -1) {
                break;
            }
        }

        long processingTime = System.currentTimeMillis();

        if (ripeTomato.checkAll()) {
            System.out.println((ripeTomato.getDay() - 1));
        } else {
            System.out.println(-1);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Time taken for input: " + (inputTime - startTime) + " ms");
        System.out.println("Time taken for tomatoPlate setup: " + (tomatoPlateTime - inputTime) + " ms");
        System.out.println("Time taken for tower setup: " + (towerSetupTime - tomatoPlateTime) + " ms");
        System.out.println("Time taken for processing: " + (processingTime - towerSetupTime) + " ms");
        System.out.println("Total time taken: " + (endTime - startTime) + " ms");
    }

    static class ripeTomato {
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
            for (int i = 0; i < z; i++) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < x; k++) {
                        if (tower.get(i).get(j).get(k).equals(1)) {
                            deque.offer(List.of(i, j, k));
                        }
                    }
                }
            }
        }

        public boolean checkAll() {
            for (int i = 0; i < z; i++) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < x; k++) {
                        if (tower.get(i).get(j).get(k).equals(0)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        public int runProcess() {
            if (deque.isEmpty()) {
                return -1;
            }
            while (!deque.isEmpty()) {
                List<Integer> tomato = deque.poll();
                tower.get(tomato.get(0)).get(tomato.get(1)).set(tomato.get(2), 9);
                ArrayList<List<Integer>> cans = canChangePosition(tomato.get(0), tomato.get(1), tomato.get(2));
                for (List<Integer> can : cans) {
                    if (tower.get(can.get(0)).get(can.get(1)).get(can.get(2)) == 0) {
                        tower.get(can.get(0)).get(can.get(1)).set(can.get(2), 1);
                    }
                }
            }
            day++;
            return 1;
        }

        private ArrayList<List<Integer>> canChangePosition(Integer Z, Integer Y, Integer X) {
            ArrayList<List<Integer>> cans = new ArrayList<>();
            int z = Z;
            int x = X;
            int y = Y;

            if (z + 1 <= this.z - 1) {
                cans.add(List.of(z + 1, y, x));
            }
            if (z - 1 >= 0) {
                cans.add(List.of(z - 1, y, x));
            }
            if (y + 1 <= this.y - 1) {
                cans.add(List.of(z, y + 1, x));
            }
            if (y - 1 >= 0) {
                cans.add(List.of(z, y - 1, x));
            }
            if (x + 1 <= this.x - 1) {
                cans.add(List.of(z, y, x + 1));
            }
            if (x - 1 >= 0) {
                cans.add(List.of(z, y, x - 1));
            }
            return cans;
        }
    }

    static class tomatoPlate {
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

    static class tomatoTower {

        private static List<List<List<Integer>>> tower = new ArrayList<>();

        public void setTower(List<tomatoPlate> plates) {
            for (tomatoPlate plate : plates) {
                tower.add(plate.getPlate());
            }
        }

        public static List<List<List<Integer>>> getTower() {
            return tower;
        }
    }

}
