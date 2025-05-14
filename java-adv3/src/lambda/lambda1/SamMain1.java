package lambda.lambda1;

public class SamMain1 {

    public static void main(String[] args) {
        SamInterface sam = () -> System.out.println("sam");

        sam.run();

        /**
         * 컴파일 오류
         */
//        NotSamInterface notSamInterface = () -> {
//            System.out.println("not sam");
//        };
//
//        notSamInterface.run();
//        notSamInterface.go();
    }
}
