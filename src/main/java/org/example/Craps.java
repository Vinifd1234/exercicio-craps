package org.example;

import java.util.Random;

public class Craps {
    // Criação de um atributo para gerar números aleatórios
    private Random numerosAleatorios = new Random();

    // Criação das constantes de status do jogo
    private enum Status { CONTINUAR, VENCEU, PERDEU};

    // Criação das constantes que representam lançamentos comuns do jogo
    /* Boa prática: Utilizar letras maiúsculas nos nomes das constantes */
    private final static int SNAKE_EYES = 2;
    private final static int TREY = 3;
    private final static int SEVEN = 7;
    private final static int YO_LEVEN = 11;
    private final static int BOX_CARS = 12;

    // Criação do método jogar
    public void jogar(){
        // Pontos do usuário;
        int meusPontos = 0;
        // Status da partida
        Status statusDoJogo;

        // Fazendo a rolagem dos dados
        int somaDaRolagem = rolarDados();

        switch (somaDaRolagem){
            case SNAKE_EYES:
            case TREY:
            case BOX_CARS:
                statusDoJogo = Status.PERDEU;
                break;
            case SEVEN:
            case YO_LEVEN:
                statusDoJogo = Status.VENCEU;
                break;
            default:
                statusDoJogo = Status.CONTINUAR;
                meusPontos = somaDaRolagem;
                System.out.printf("Pontuação: %d\n", meusPontos);
                break;

        }

        while (statusDoJogo == Status.CONTINUAR){
            somaDaRolagem = rolarDados();

            if(somaDaRolagem == meusPontos){
                statusDoJogo = Status.VENCEU;
            }else if(somaDaRolagem == SEVEN){
                statusDoJogo = Status.PERDEU;
            }
        }

        // Exibe se ganhou ou perdeu
        if(statusDoJogo == Status.VENCEU){
            System.out.printf("Jogador venceu o jogo!");
        }else{
            System.out.printf("Jogador perdeu o jogo");
        }
    }

    // Criação do método de rolagem dos "dados"
    public int rolarDados(){
        // Criação dos "dados"
        int dado1 = 1 + numerosAleatorios.nextInt(6);
        int dado2 = 1 + numerosAleatorios.nextInt(6);

        // Váriavel para armazenar a soma dos dois dados
        int sum = dado1 + dado2;

        // Exibindo o resultado do lançamento
        System.out.printf("Jogador tirou nos dados: %d (dado 1) + %d (dado 2) = %d\n", dado1, dado2, sum);

        return sum;

    }
}
