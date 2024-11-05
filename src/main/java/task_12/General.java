package task_12;

public abstract class General {

    public static General attemptToAssign(Object o) {
        if (o instanceof General) {
            return (General) o;
        }
        return null;
    }
}

class Any extends General {

}

