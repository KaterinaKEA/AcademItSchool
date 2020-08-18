package academit.kondakova.vector.main;

import academit.kondakova.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(2);
        System.out.printf("Размерность вектора %s равна %d %n", vector1.toString(), vector1.getSize());
        double[] array1 = {1.0, 1.0};
        vector1.setVector(array1);

        double[] array2 = {1, 2, 3, 1};
        Vector vector2 = new Vector(array2);
        System.out.printf("Размерность вектора %s равна %d %n", vector2.toString(), vector2.getSize());

        Vector vector31 = new Vector(4, array2);
        System.out.printf("Размерность вектора %s равна %d %n", vector31.toString(), vector31.getSize());

        Vector vector32 = new Vector(2, array2);
        System.out.printf("Размерность вектора %s равна %d %n", vector32.toString(), vector32.getSize());

//        Vector vector33 = new Vector(-1, array2);

        Vector vector4 = new Vector(vector2);
        System.out.printf("Размерность вектора %s равна %d %n", vector4.toString(), vector31.getSize());

        vector1.addVector(vector2);
        System.out.printf("Сложение векторов равно %s%n", vector1);

        vector32.minusVector(vector1);
        System.out.printf("Разность векторов равно %s%n", vector32);

        int scalar = 2;
        vector32.multiplicationByScalar(scalar);
        System.out.printf("Умножение вектора на скаляр %d равно %s%n", scalar, vector32);

        vector32.vectorReversal();
        System.out.printf("Разворот вектора будет %s%n", vector32);

        System.out.printf("Длина вектора %s равна %.02f %n", vector1, vector1.vectorLength());

        vector1 = vector1.insertElementByIndex(9, 0);
        System.out.printf("В вектор вставили элемент, получилось %s%n", vector1);

        Vector vector5 = Vector.addVector(vector1, vector2);
        System.out.printf("Суммарный вектор %s и %s равен %s %n", vector1, vector2, vector5);

        Vector vector6 = Vector.minusVector(vector5, vector4);
        System.out.printf("Разность вектор %s и %s равен %s %n", vector5, vector4, vector6);

        vector1 = vector1.deleteElementByIndex(2);
        System.out.printf("Из вектора удалили элемент, получилось %s%n", vector1);

        System.out.printf("Вектора %s и %s равны? Ответ: %b %n", vector1, vector2, vector1.equals(vector2));
        System.out.printf("Вектора %s и %s равны? Ответ: %b %n", vector2, vector4, vector2.equals(vector4));

        System.out.printf("Хэш-код Вектора %s равен %d %n", vector2, vector2.hashCode());

        int scalarProduct = Vector.scalarProduct(vector2, vector4);
        System.out.printf("Скалярное произведение векторов %s и %s равно %d %n", vector2, vector4, scalarProduct);
    }
}