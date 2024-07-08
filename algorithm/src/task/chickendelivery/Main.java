package task.chickendelivery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String SizeAndM = br.readLine();
        String[] sizeAndMSplit = SizeAndM.split(" ");
        int size = Integer.parseInt(sizeAndMSplit[0]);
        int M = Integer.parseInt(sizeAndMSplit[1]);

        Deque<Integer> process = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            String[] rowItems = br.readLine().split(" ");
            for (String colItem : rowItems) {
                process.offer(Integer.parseInt(colItem));
            }
        }
        int count = 0;

        Solution solution = new Solution(size, M);
        solution.initMap(process);
        solution.setCHandHS();
        System.out.println(solution.houses);
        System.out.println(solution.chickenStores);
        solution.restructuring();
        System.out.println(solution.SurvivedChickenStores);
        int result = solution.allDistanceChicken();
        System.out.println("result = " + result);

    }

    public static class ChickenStore {
        int r;
        int c;
        int selected;

        public ChickenStore(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getSelected() {
            return selected;
        }
    }

    public static class House {
        int r;
        int c;
        int minD = Integer.MAX_VALUE;
        ChickenStore minStore;


        public House(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }

    public static class Solution {
        int size;
        int M;
        List<List<Integer>> map = new ArrayList<>();
        List<ChickenStore> chickenStores = new ArrayList<>();
        List<House> houses = new ArrayList<>();
        List<ChickenStore> SurvivedChickenStores = new ArrayList<>();

        public Solution(int size, int m) {
            this.size = size;
            M = m;
        }

        public void initMap(Deque<Integer> mapitems) {
            for (int i = 0; i < size; i++) {
                map.add(new ArrayList<>());
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map.get(i).add(mapitems.poll());
                }
            }
        }

        public void setCHandHS() {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    Integer building = map.get(i).get(j);
                    if (building.equals(2)) {
                        chickenStores.add(new ChickenStore(i,j));
                    } else if (building.equals(1)) {
                        houses.add(new House(i,j));
                    }
                }
            }
        }

        public void restructuring() {
            for (int i = 0; i < houses.size(); i++) {
                if (houses.get(i).minD == 1) {
                    break;
                } else {
                    for (ChickenStore chickenStore : chickenStores) {
                        Integer distance = getDistance(chickenStore, houses.get(i));
                        if (distance < houses.get(i).minD) {
                            houses.get(i).minD = distance;
                            houses.get(i).minSto  re = chickenStore;
                        }
                    }
                }
            }

            for (House house : houses) {
                house.minStore.selected += 1;
            }

            chickenStores.sort(new Comparator<ChickenStore>() {
                @Override
                public int compare(ChickenStore s1, ChickenStore s2) {
                    return Integer.compare(s2.getSelected(), s1.getSelected());
                }
            });

            for (int i = 0; i < M; i++) {
                SurvivedChickenStores.add(chickenStores.get(i));
            }

            // 초기화
            for (House house : houses) {
                house.minD = Integer.MAX_VALUE;
            }
        }

        public int allDistanceChicken() {
            for (int i = 0; i < houses.size(); i++) {
                if (houses.get(i).minD == 1) {
                    break;
                } else {
                    for (ChickenStore chickenStore : SurvivedChickenStores) {
                        Integer distance = getDistance(chickenStore, houses.get(i));
                        if (distance < houses.get(i).minD) {
                            houses.get(i).minD = distance;
                        }
                    }
                }
            }

            int sum = 0;
            for (House house : houses) {
                sum += house.minD;
            }

            return sum;
        }

        private Integer getDistance(ChickenStore ch, House hs) {
            int disC = Math.abs(ch.c - hs.c);
            int disR = Math.abs(ch.r - hs.r);

            return disC + disR;
        }


    }
}
