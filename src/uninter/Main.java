package uninter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Jogo jv = new Jogo();

        String position;
        // valid enquanto a jogada estiver em 0 a jogada não é valida e vai ficar no laço de repetição.
        // jogadas é um contador das jogadas por exemplo se chegar em 9 deu empate.
        int valid = 0, plays = 0;

        while (true) {
            System.out.println("::::::::  jogo da velha :::::::::");
            jv.show();

            // inicia jogador 1
            System.out.println("Jogador 1, informe uma posição: ");
            position = read.next();
            while (!jv.validation(position)) {
                System.out.println("Jogada inválida, tente novamente!");
                System.out.println("Jogador 1, informe uma posição: ");
                position = read.next();
                valid = 0;
            }

            jv.move(position, "X");
            valid = 1;

            plays++;
            valid = 0;
            if (!jv.victory(plays).equals("null")) {
                break;
            }

            do { // inicia jogador 2
                System.out.println("Jogador 2, informe uma posição: ");
                position = read.next();
                while (!jv.validation(position)) {
                    System.out.println("Jogada inválida, tente novamente!");
                    System.out.println("Jogador 2, informe uma posição: ");
                    position = read.next();
                    valid = 0;
                }

                jv.move(position, "O");
                valid = 1;

            } while (valid == 0); // fim jogador 2

            plays++;
            valid = 0;
            if (!jv.victory(plays).equals("null")) {
                break;
            }
        }// ---------------------------------------------------------
        System.out.println("O " + jv.victory(plays) + "venceu");
    }
}
