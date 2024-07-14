package task.gold.running16930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static int BFS(char[][] map, int[][] mapDP, int K, int startX, int startY, int targetX, int targetY) {
        Deque<Position> deque = new ArrayDeque<>();
        int N = map.length;
        int M = map[0].length;


        deque.offer(new Position(startX, startY, 0));
        mapDP[startX][startY] = 0;

        Position positionTarget = new Position(targetX, targetY, 99999);

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};


        while (!deque.isEmpty()) {
            Position poll = deque.poll();
            int pollx = poll.x;
            int polly = poll.y;

            if (poll.equals(positionTarget)) {
                return poll.time;
            }
            for (int i = 0; i < 4; i++) {

                for (int stride = 1; stride < K + 1; stride++) {
                    if (pollx + dx[i]*stride >= N || pollx + dx[i]*stride < 0 || polly + dy[i]*stride >= M || polly + dy[i]*stride < 0) {
                        break;
                    }

                    if (map[pollx + dx[i]*stride][polly + dy[i]*stride] == '#') {
                        break;
                    }

                    if (mapDP[pollx + dx[i]*stride][polly + dy[i]*stride] < poll.time+1
                            && mapDP[pollx + dx[i]*stride][polly + dy[i]*stride] != -1) {
                        break;
                    }

                    if (mapDP[pollx + dx[i]*stride][polly + dy[i]*stride] == -1) {
                        deque.offer(new Position(pollx + dx[i]*stride, polly + dy[i]*stride, poll.time+1));
                        mapDP[pollx + dx[i]*stride][polly + dy[i]*stride] = poll.time + 1;
                    } else if (mapDP[pollx + dx[i]*stride][polly + dy[i]*stride] >=  poll.time+1) {
                        deque.offer(new Position(pollx + dx[i]*stride, polly + dy[i]*stride, poll.time+1));
                        mapDP[pollx + dx[i]*stride][polly + dy[i]*stride] = poll.time + 1;
                    } else {
                        break;
                    }
                }
            }

        }
        return -1;
    }

    public static class Position {
        int x;
        int y;
        int time;

        public Position(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    ", time=" + time +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        int[][] mapDP = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            Arrays.fill(mapDP[i], -1);
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        st = new StringTokenizer(br.readLine());

        int startX = Integer.parseInt(st.nextToken()) -1;
        int startY = Integer.parseInt(st.nextToken()) -1;
        int targetX = Integer.parseInt(st.nextToken()) -1;
        int targetY = Integer.parseInt(st.nextToken()) -1;


        int result = BFS(map, mapDP, K, startX, startY, targetX, targetY);
        System.out.println(result);

    }
}
