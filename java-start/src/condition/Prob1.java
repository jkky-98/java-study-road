package condition;

public class Prob1 {
    public static void main(String[] args) {
        int score = 95;
        String grade;
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80 && score < 90) {
            grade = "B";
        } else if (score >= 70 && score < 80) {
            grade = "C";
        } else if (score >= 60 && score < 70) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("score: " + score);
        System.out.println("출력: 학점은 " + grade + "입니다.");

        int dist = 99;
        String trans = "";
        boolean setting = false;
        if (dist <= 1 && setting == false) {
            trans = "도보";
            setting = true;
        }
        if (dist <= 10 && setting == false) {
            trans = "자전거";
            setting = true;
        }
        if (dist <= 100 && setting == false) {
            trans = "자동차";
            setting = true;
        }
        if (dist > 100 && setting == false) {
            trans = "비행기";
            setting = true;
        }
        System.out.println(trans);
    }
}
