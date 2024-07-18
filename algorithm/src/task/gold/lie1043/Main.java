package task.gold.lie1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMSplit = br.readLine().split(" ");
        int N = Integer.parseInt(NMSplit[0]);
        int M = Integer.parseInt(NMSplit[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int catcherCount = Integer.parseInt(st.nextToken());
        List<Integer> catchers = new ArrayList<>();

        if (catcherCount != 0) {
            for (int i = 0; i < catcherCount; i++) {
                catchers.add(Integer.parseInt(st.nextToken()));
            }
        }
        List<Party> parties = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            Party party = new Party();
            st = new StringTokenizer(br.readLine());
            int partyN = Integer.parseInt(st.nextToken());
            for (int j = 0; j < partyN; j++) {
                int partyMember = Integer.parseInt(st.nextToken());
                party.members.add(partyMember);
            }
            parties.add(party);
        }

        // 로직 시작
        // 첫 로직 - 명시된 catchers 포함된 party 조사
        Deque<Integer> deque = initLogic(catchers, parties);
        // deque에 든 놈들 지속해서 처리 해주기
        mainProcess(catchers, deque, parties);
        int canLieCount = 0;
        for (Party party : parties) {
            if (party.canLie) {
                canLieCount++;
            }
        }
        System.out.println(canLieCount);

    }

    private static void mainProcess(List<Integer> catchers, Deque<Integer> deque, List<Party> parties) {
        Set<Integer> visited = new HashSet<>(catchers);

        while (!deque.isEmpty()) {
            Integer poll = deque.poll();
            for (Party party : parties) {
                if (party.members.contains(poll)) {
                    party.canLie = false;
                    for (Integer member : party.members) {
                        if (!visited.contains(member)) {
                            visited.add(member);
                            deque.offer(member);
                        }
                    }
                }
            }
        }
    }

    private static Deque<Integer> initLogic(List<Integer> catchers, List<Party> parties) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (Integer catcher : catchers) {
            for (Party party : parties) {
                if (party.members.contains(catcher)) {
                    party.canLie = false;
                    for (Integer member : party.members) {
                        if (!catchers.contains(member)) {
                            deque.offer(member);
                        }
                    }

                }
            }
        }
        return deque;
    }

    public static class Party {
        boolean canLie = true;
        Set<Integer> members = new HashSet<>();

        @Override
        public String toString() {
            return "Party{" +
                    "canLie=" + canLie +
                    ", members=" + members +
                    '}';
        }
    }
}
