package generic.ex3;


public class AnimalHospitalV2 <T> {

    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public void checkup() {
        // T의 타입을 메서드를 정의하는 시점에는 알 수 없다.
//        System.out.println("동물 이름: " + animal.getName());
//        System.out.println("동물 크기: " + animal.getSize());
//        animal.sound();
    }

    public T bigger(T target) {
//        return animal.getSize() > target.getSize() ? animal : target;
        // 비교로직이 true일 경우 animal을 반환, false일 경우 target을 반환
        return null;
    }
}
