package task_9;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
-- копирование объекта (копирование содержимого одного объекта в другой существующий, включая DeepCopy -- глубокое рекурсивное дублирование, подразумевающее также копирование содержимого объектов, вложенных в копируемый объект через его поля, атрибуты);
-- клонирование объекта (создание нового объекта и глубокое копирование в него исходного объекта);
-- сравнение объектов (включая глубокий вариант);
-- сериализация/десериализация (перевод в формат, подходящий для удобного ввода-вывода, как правило в строковый тип, и восстановление из него);
-- печать (наглядное представление содержимого объекта в текстовом формате);
-- проверка типа (является ли тип текущего объекта указанным типом);
-- получение реального типа объекта (непосредственного класса, экземпляром которого он был создан).*/
public class General implements Cloneable, Comparable<General>, java.io.Serializable {

    // Для примера добавим поле типа объект, и поле-примитив
    int i;
    General field;

    public void copy(General other) {
        other.i = this.i;
        other.field = this.field;
        this.field.copy(other.field);
    }

    @Override
    public General clone() {
        General general = null;
        try {
            general = (General) super.clone();
        } catch (CloneNotSupportedException e) {
            general = new General();
            general.i = i;
            general.field = field;
        }
        general.field = (General) this.field.clone();
        return general;
    }

    @Override
    public int compareTo(General o) {
        if(i == o.i) {
            return field.compareTo(o.field);
        }
        return i - o.i;
    }

    @Override
    public String toString() {
        return "General{" +
                "i=" + i +
                ", field=" + field.toString() +
                '}';
    }

    public byte[] serialize() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(this);
            out.flush();
            return bos.toByteArray();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    static Object deserialize(byte[] bytes) {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        try (ObjectInput in = new ObjectInputStream(bis)) {
            return in.readObject();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public <T> boolean isType(Class<?> c) {
        return this.getClass().equals(c);
    }

    public Class<?> getType() {
        return this.getClass();
    }
}

class Any extends General {}
