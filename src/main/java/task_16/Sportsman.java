package task_16;

import java.util.List;

public class Sportsman {

    public void doSport(SportEquipment equipment) {}

    public <T> List<T> doSport(List<T> equipments) { return equipments; }
}

class Gymnast extends Sportsman {
}

class Championship {

    public void start() {
        Sportsman sportsman = new Gymnast();

        sportsman.doSport(new Ball()); // полиморфный вызов метода

        sportsman.doSport(List.of(new Ball())); //ковариантный вызов метода
    }
}

class SportEquipment {}
class Ball extends SportEquipment {}

