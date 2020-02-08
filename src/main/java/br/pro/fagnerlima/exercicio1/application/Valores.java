package br.pro.fagnerlima.exercicio1.application;

public class Valores implements ValoresITF {

    public static final int LIMIT_SIZE = 10;

    private int[] valores = new int[LIMIT_SIZE];

    @Override
    public boolean ins(int v) {
        if (v <= 0) {
            return false;
        }

        for (int i = 0; i < valores.length; i++) {
            if (valores[i] == 0) {
                valores[i] = v;

                return true;
            }
        }

        return false;
    }

    @Override
    public int del(int i) {
        if (size() == 0 || valores[i] <= 0) {
            return -1;
        }

        int v = valores[i];
        valores[i] = 0;

        return v;
    }

    @Override
    public int size() {
        int size = 0;

        for (int i = 0; i < valores.length; i++) {
            if (valores[i] > 0) {
                size++;
            }
        }

        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < valores.length; i++) {
            sb.append(i + "=" + valores[i]);

            if (i < valores.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }

}
