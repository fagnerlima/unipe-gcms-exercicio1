package br.pro.fagnerlima.exercicio1.application;

public interface ValoresITF {

    /**
     * Insere um valor
     *
     * @param v valor a ser inserido
     * @return true se o valor for inserido
     */
    boolean ins(int v);

    /**
     * Remove o valor armazenado no índice i e retorna o valor removido
     *
     * @param i índice do elemento
     * @return valor removido
     */
    int del(int i);

    /**
     * Retorna a quantidade de valores armazenados
     *
     * @return quantidade de valores
     */
    int size();

}
