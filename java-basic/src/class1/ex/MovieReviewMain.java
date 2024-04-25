package class1.ex;

public class MovieReviewMain {
    public static void main(String[] args) {
        MovieReview mr1 = new MovieReview();
        mr1.review = "인셉션";
        mr1.title = "인생은 무한 루프";

        MovieReview mr2 = new MovieReview();
        mr2.review = "어바웃 타임";
        mr2.title = "인생 시간 영화";

        MovieReview[] arrMovie = new MovieReview[]{mr1, mr2};

        for (int i=0; i < arrMovie.length; i++) {
            System.out.println("영화 제목 : " + arrMovie[i].title + ", 리뷰: " + arrMovie[i].review);
        }
    }
}
