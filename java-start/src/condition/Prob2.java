package condition;

public class Prob2 {
    public static void main(String[] args) {
        String[] title = {"AboutTime", "ToyStory", "Gozilla"};
        double[] rating = {9, 8, 7};
        double ratingMinimum = 7.1;

        System.out.println(ratingMinimum + " 평점 이상의 영화를 추천해주세요.");
        for (int i = 0; i <= 2; i++) {
            if (ratingMinimum <= rating[i]) {
                System.out.println(title[i] + "를 추천합니다.");
            }
        }

        String grade = "B";
        switch (grade) {
            case "A":
                System.out.println("탁월!");
                break;
            case "B":
                System.out.println("좋은듯!");
                break;
            case "C":
                System.out.println("준수!");
                break;
            case "D":
                System.out.println("분발해!");
                break;
            case "F":
                System.out.println("등록금아깝다.");
                break;
            default:
                System.out.println("WOW!");
        }
        int a = 10;
        int b = 100;

        int win = (a > b) ? a : b;
        System.out.println(win);

        int x = 13;

        String result1 = ((x % 2) == 1) ? "홀수" : "짝수";
        System.out.println(result1);
    }
}

