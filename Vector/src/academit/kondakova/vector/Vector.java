package academit.kondakova.vector;

import java.util.Arrays;

public class Vector {
    private double[] vector;
    private int n;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть положительным числом.");
        }

        this.vector = new double[n];
        this.n = n;

        for (int i = 0; i < n; i++) {
            this.vector[i] = 0;
        }
    }

    public Vector(double[] vector) {
        this.vector = vector;
        this.n = vector.length;
    }

    public Vector(Vector v) {
        this.n = v.n;
        this.vector = v.vector;
    }

    public Vector(int n, double[] vector) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть положительным числом.");
        }

        int length = vector.length;
        this.vector = new double[n];
        this.n = n;

        if (length < n) {
            for (int i = length; i < n; i++) {
                this.vector[i] = 0;
            }
        }

        System.arraycopy(vector, 0, this.vector, 0, n);
    }

    public int getSize() {
        return this.n;
    }

    public double[] getVector() {
        return vector;
    }

    public void setVector(double[] vector) {
        this.vector = vector;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }

    public void addVector(Vector v2) {
        int maxDimension = Math.max(n, v2.n);
        int minDimension = Math.min(n, v2.n);

        for (int i = 0; i < minDimension; i++) {
            vector[i] += v2.vector[i];
        }

        if (maxDimension - minDimension >= 0) {
            if (n < v2.n) {
                n = v2.n;
                double[] vector3 = new double[n];
                System.arraycopy(v2.vector, minDimension, vector3, minDimension, maxDimension - minDimension);
                for (int i = 0; i < vector.length; i++) {
                    vector3[i] += vector[i];
                }

                vector = new double[n];
                vector = vector3;
            }
        }
    }

    public void minusVector(Vector v2) {
        int maxDimension = Math.max(n, v2.n);
        int minDimension = Math.min(n, v2.n);

        for (int i = 0; i < minDimension; i++) {
            vector[i] -= v2.vector[i];
        }

        if (maxDimension - minDimension >= 0) {
            if (n < v2.n) {
                n = v2.n;
                double[] vector3 = new double[n];
                for (int i = minDimension; i < maxDimension; i++) {
                    vector3[i] = -v2.vector[i];
                }

                for (int i = 0; i < vector.length; i++) {
                    vector3[i] += vector[i];
                }

                vector = new double[n];
                vector = vector3;
            }
        }
    }

    public void multiplicationByScalar(int scalar) {
        for (int i = 0; i < n; i++) {
            vector[i] = vector[i] * scalar;
        }
    }

    public void vectorReversal() {
        multiplicationByScalar(-1);
    }

    public double vectorLength() {
        int length = 0;

        for (int i = 0; i < n; i++) {
            length += Math.pow(vector[i], 2);
        }

        return Math.sqrt(length);
    }

    public Vector insertElementByIndex(double element, int index) {
        double[] vectorResult = new double[n + 1];

        if (index >= 0) {
            System.arraycopy(vector, 0, vectorResult, 0, index);
        }

        vectorResult[index] = element;

        if (n - index >= 0) {
            System.arraycopy(vector, index, vectorResult, index + 1, n - index);
        }

        return new Vector(n + 1, vectorResult);
    }

    public Vector deleteElementByIndex(int index) {
        double[] vectorResult = new double[n - 1];

        if (index >= 0) {
            System.arraycopy(vector, 0, vectorResult, 0, index);
        }

        if (n - index - 1 >= 0) {
            System.arraycopy(vector, index - 1, vectorResult, index, n - index - 1);
        }

        return new Vector(n - 1, vectorResult);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Vector v = (Vector) o;
        return this.n == v.n && this.vector == v.vector;
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 1;
        hash = prime * hash + n;
        hash = prime * hash + Arrays.hashCode(vector);
        return hash;
    }

    public static Vector addVector(Vector v1, Vector v2) {
        int maxDimension = Math.max(v1.n, v2.n);
        int minDimension = Math.min(v1.n, v2.n);
        Vector v3 = new Vector(maxDimension);

        if (maxDimension - minDimension >= 0) {
            if (v1.n > v2.n) {
                System.arraycopy(v1.vector, minDimension, v3.vector, minDimension, maxDimension - minDimension);
            } else {
                System.arraycopy(v2.vector, minDimension, v3.vector, minDimension, maxDimension - minDimension);
            }
        }

        for (int i = 0; i < minDimension; i++) {
            v3.vector[i] = v1.vector[i] + v2.vector[i];
        }

        return v3;
    }

    public static Vector minusVector(Vector v1, Vector v2) {
        int maxDimension = Math.max(v1.n, v2.n);
        int minDimension = Math.min(v1.n, v2.n);
        Vector v3 = new Vector(maxDimension);

        if (maxDimension - minDimension >= 0) {
            if (v1.n > v2.n) {
                System.arraycopy(v1.vector, minDimension, v3.vector, minDimension, maxDimension - minDimension);
            } else {
                System.arraycopy(v2.vector, minDimension, v3.vector, minDimension, maxDimension - minDimension);
            }
        }

        for (int i = 0; i < minDimension; i++) {
            v3.vector[i] = v1.vector[i] - v2.vector[i];
        }

        return v3;
    }

    public static int scalarProduct(Vector v1, Vector v2) {
        int minDimension = Math.min(v1.n, v2.n);
        int scalarProduct = 0;

        for (int i = 0; i < minDimension; i++) {
            scalarProduct += v1.vector[i] * v2.vector[i];
        }

        return scalarProduct;
    }
}