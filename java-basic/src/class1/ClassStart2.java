package class1;

public class ClassStart2 {
    public static void main(String[] args) {
        String[] names = {"학생1", "학생2", "학생3"};
        int[] ages = {15, 17, 19};
        int[] grades = {80, 50, 70};

        for (int i=0; i<names.length; i++) {
            System.out.println("이름 : " + names[i] + " 나이 : " + ages[i] + " 성적 : " + grades[i]);
        }
        // 단점 : 학생2를 지울려면 3개의 배열의 정확힣 두번째 데이터를 모두 직접 제거해줘야 한다.
    }
}
