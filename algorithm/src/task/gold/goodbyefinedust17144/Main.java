package task.gold.goodbyefinedust17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫째줄
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()); // row
        int C = Integer.parseInt(st.nextToken()); // col
        int T = Integer.parseInt(st.nextToken()); // T초후

        int[][] room = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        ArrayList<int[]> airCleanerDevice = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] == -1) {
                    airCleanerDevice.add(new int[] {i,j,-1});
                }
            }
        }

        for (int i = 0; i < T; i++) {
            diffusionDust(room, R, C);

            airCleaner(room, airCleanerDevice, R, C);

        }

        System.out.println(sum(R, C, room));


    }

    private static int sum(int R, int C, int[][] room) {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] != -1) {
                    sum += room[i][j];
                }
            }
        }
        return sum;
    }

    public static void airCleaner(int[][] room, List<int[]> device, int R, int C) {
        int[] upPosition = device.get(0);
        int[] downPosition = device.get(1);

        Deque<int[]> updeque = new ArrayDeque<>();
        Deque<int[]> downdeque = new ArrayDeque<>();

        //init

        updeque.offer(upPosition);
        downdeque.offer(downPosition);

        airSpin(room, R, C, updeque, true);
        airSpin(room, R, C, downdeque, false);
    }

    private static void airSpin(int[][] room, int R, int C, Deque<int[]> deque, boolean isUp) {
        int[] dx;
        int[] dy;
        if (isUp)  {
            dx = new int[] {0,-1,0,1};
        } else {
            dx = new int[] {0,1,0,-1};
        }
        dy = new int[] {1,0,-1,0};
        int count = 0;

        while(!deque.isEmpty()) {
            int[] current = deque.poll();

            if(current[0] + dx[count] < R
                    && current[0] + dx[count] >= 0
                    && current[1] + dy[count] < C
                    && current[1] + dy[count] >= 0) {
            } else {
                count++;
            }

            if(room[current[0] +dx[count]][current[1] + dy[count]] == -1) {
                break;
            }

            int nextR = current[0] + dx[count];
            int nextC = current[1] + dy[count];
            int nextDustValue = room[current[0] + dx[count]][current[1]+ dy[count]];

            if (current[2] == -1) {
                room[current[0] + dx[count]][current[1]+ dy[count]] = 0;
                deque.offer(new int[] {nextR, nextC, nextDustValue});
            } else {
                room[current[0] + dx[count]][current[1]+ dy[count]] = current[2];
                deque.offer(new int[] {nextR, nextC, nextDustValue});
            }

        }
    }

    public static void diffusionDust(int[][] room, int R, int C) {
        Deque<int[]> deque = new ArrayDeque<>();
        Deque<int[]> dequeTmp = new ArrayDeque<>();

        int [] dx = {-1, 1, 0, 0};
        int [] dy = {0, 0, 1, -1};

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] != 0 && room[i][j] != -1) {
                    deque.offer(new int[] {i, j, room[i][j]});
                }
            }
        }

        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            int count;
            int originDustValue = poll[2];

            for (int i = 0; i < 4; i++) {
                if (poll[0] + dx[i] < R
                && poll[0] + dx[i] >= 0
                && poll[1] + dy[i] < C
                && poll[1] + dy[i] >= 0) {
                    if (room[poll[0] + dx[i]][poll[1] + dy[i]] != -1) {
                        dequeTmp.add(new int[] {poll[0] + dx[i], poll[1] + dy[i]});
                    }
                }
            }

            count = dequeTmp.size();
            while (!dequeTmp.isEmpty()) {
                int[] spread = dequeTmp.poll();
                room[spread[0]][spread[1]] = room[spread[0]][spread[1]] + (int) Math.floor((double) originDustValue / 5);
            }
            room[poll[0]][poll[1]] = room[poll[0]][poll[1]] - (int) Math.floor((double) originDustValue / 5) * count;
        }
    }
}
