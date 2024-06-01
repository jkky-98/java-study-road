package generic.test;

import generic.animal.Cat;

public class CatHospital {
    private Cat animal;

    public void set(Cat animal) {
        this.animal = animal;
    }

    public void checkup() {
        System.out.println("동물 이름: " + animal.getName());
        System.out.println("동물 크기: " + animal.getSize());
        animal.sound();
    }

    public Cat bigger(Cat target) {
        return animal.getSize() > target.getSize() ? animal : target;
        // 비교로직이 true일 경우 animal을 반환, false일 경우 target을 반환
    }
}
