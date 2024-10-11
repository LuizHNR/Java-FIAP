package listas;

public class RevisaoVetor {
    public static void main(String[] args) {
        int tamanho = 5;
        //Conjunto de N elementos de mesmo tipo
        String[] alunos = new String[5];

        alunos[0] = "Eliane";
        alunos[1] = "Ana";
        alunos[2] = "Enzo";
        alunos[3] = "Murilo";
        alunos[4] = "Pamela";
        System.out.println("Lista de alunos");
        for(int i = 0; i < alunos.length; i++){
            System.out.println(alunos[i] );
        }
    }
}
