package task_10;

// Можно запретить переопределение метода в потомках используя ключевое слово final для метода
public abstract class General {

    public final void copy(General other) {
        // logic
    }
}

class Any extends General {
    @Override
    public void copy(General other) { // Здесь ошибка компиляции: cannot override copy in General overridden method is final
    }
}
