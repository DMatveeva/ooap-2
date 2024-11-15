package task_14;

import task_9.Any;
import task_9.General;
import task_9.None;

import java.util.Arrays;

// в класс General добавлен метод sum(General g)
public class Vector<T extends General> extends Any {
    General[] arrayT;
    int actualSize = 0;

    Vector(int size) {
       this.arrayT = new General[size];
    }

    public Vector<T> sum(Vector<T> vector2) {
        if (this.getLength() - vector2.getLength() != 0) {
            return null;
        }
        Vector<T> vectorOfSums = new Vector<>(this.getLength());
        for(int i = 0; i < arrayT.length; i++) {
            T t1 = this.get(i);
            T t2 = vector2.get(i);
            T sum = (T) t1.sum(t2);
            vectorOfSums.put(sum);
        }
        return vectorOfSums;
    }

    public int getLength() {
        return arrayT.length;
    }
    public T get(int i) {
        return (T) arrayT[i];
    }
    public void put(T t) {
        arrayT[actualSize] = t;
        actualSize++;
    }
}
