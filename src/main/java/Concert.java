public class Concert {
    public static void playConcert() {
        Musician pianist = new Pianist();
        Musician violinist = new Violinist();

        pianist.play(); // применяется полиморфизм, т.к. переменная pianist типа Musician, но метод выведет I play piano
        violinist.play(); // применяется полиморфизм, т.к. переменная violinist типа Musician, но метод выведет I play violin
    }
}

class Instrument { // класс представляет собой АТД Музыкальный инструмент
    Instrument(String name) {
        this.name = name;
    }
    String name;
}
abstract class Musician { // класс представляет собой АТД Музыкант
    Instrument instrument; // Музыкант имеет музыкальный инструмент - отношение Композиция

    Musician(Instrument instrument) {
        this.instrument = instrument;
    }
    public abstract void play();

    public Instrument getInstrument() {
        return instrument;
    };
}

class Pianist extends Musician { // класс представляет собой АТД Пианист, который является потомком класса Музыкант (наследование)

    Pianist() {
        super(new Instrument("Piano"));
    }

    @Override
    public void play() {
        System.out.println("I play piano");
    }
}

class Violinist extends Musician { // класс представляет собой АТД Скрипач, который является потомком класса Музыкант (наследование)

    Violinist() {
        super(new Instrument("Violin"));
    }

    @Override
    public void play() {
        System.out.println("I play violin");
    }
}