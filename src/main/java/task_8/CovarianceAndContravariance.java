package task_8;

import java.util.ArrayList;
import java.util.List;

public class CovarianceAndContravariance {

    public static void main(String[] args) {
        // Насколько понимаю, реализовать напрямую контрвариантные типы в Java не получится, т.к. нельзя при определении типа
        // использовать синтаксис Delegate < T super Flat>, в отличии от Delegate <T extends RealEstate>.
        // Можно использовать конструкцию super в коллекциях
        // ArrayList<RealEstate> контрвариантный по отношению к List<? super House>
        List<? super House> list = new ArrayList<RealEstate>();
    }
}

abstract class Agent<T extends RealEstate> {
    public abstract RealEstate sell();
}

class FlatAgent extends Agent<Flat> { // Класс FlatAgent ковариантный родительскому классу Agent
    @Override
    public Flat sell() {
        return new Flat();
    }
}

class HouseAgent extends Agent<House> { // Класс HouseAgent ковариантный родительскому классу Agent
    @Override
    public House sell() {
        return new House();
    }
}
class RealEstate {}
class Flat extends RealEstate{}
class House extends RealEstate{}


