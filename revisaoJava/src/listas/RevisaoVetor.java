package listas;

public class RevisaoVetor {

    public static void main(String[] args) {

        //Conjunto de N elementos de mesmo tipo
        String[] alunos = new String[5];

        alunos[0] = "Erick";
        alunos[1] = "Luiz";
        alunos[2] = "LuizH";
        alunos[3] = "Vicenzo";
        alunos[4] = "Pavam";

        System.out.println("Lista de Alunos:\n");
        for(int i = 0; i < 5; i++){
            System.out.println( i+1 + alunos[i] );
        }
    }
}
