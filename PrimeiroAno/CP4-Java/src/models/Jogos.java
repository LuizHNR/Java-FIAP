package models;

import enums.GeneroJogoEnum;
import enums.PlataformasEnum;

import java.util.Scanner;

public class Jogos implements Cloneable{

    Scanner leitor = new Scanner(System.in);

    //Atributos
    private int id;
    private String nome;
    private int lancamento;
    private double preco;
    private GeneroJogoEnum genero;
    private PlataformasEnum plataforma;

    //Getters e Setters
    public Scanner getLeitor() {
        return leitor;
    }
    public void setLeitor(Scanner leitor) {
        this.leitor = leitor;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLancamento() {
        return lancamento;
    }
    public void setLancamento(int lancamento) {
        this.lancamento = lancamento;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public GeneroJogoEnum getGenero() {
        return genero;
    }
    public void setGenero(GeneroJogoEnum genero) {
        this.genero = genero;
    }

    public PlataformasEnum getPlataforma() {
        return plataforma;
    }
    public void setPlataforma(PlataformasEnum plataforma) {
        this.plataforma = plataforma;
    }


    //Metodos Gerais
    public Jogos (){}

    public Jogos(String nome,int lancamento,double preco, PlataformasEnum plataforma, GeneroJogoEnum genero) {
        this.nome = nome;
        this.plataforma = plataforma;
        this.genero = genero;
    }

    @Override
    public Jogos clone() {
        return new Jogos(this.nome, this.lancamento, this.preco , this.plataforma, this.genero);
    }

    public Jogos cadastrarJogo(){
        System.out.println("-------------CADASTRAR---------------");

        System.out.println("Qual a data de lançamento do jogo?");
        this.lancamento = leitor.nextInt();
        leitor.nextLine();

        System.out.println("Qual o nome do jogo?");
        this.nome = leitor.nextLine();

        System.out.println("Qual o preço do jogo?");
        this.preco = leitor.nextDouble();
        leitor.nextLine();

        do {
            System.out.println("------------------- OPÇÕES GENERO ----------------------" +
                    "\n(1) - Ação;" +
                    "\n(2) - Sandbox;" +
                    "\n(3) - Terror;"+
                    "\n(4) - Rpg," +
                    "\n(5) - Fps;" +
                    "\n(6) - Corrida;" +
                    "\n(7) - SobrevivÊncia;" +
                    "\n(8) - Luta;" +
                    "\n(9) - Simulação;" +
                    "\n(10) - Aventura;" +
                    "\n(11) - Ritmo;" +
                    "\n(12) - Esports;" +
                    "\n(13) - Educacional." +
                    "\nDigite a opção do tipo do jogo");
            int opGenero = leitor.nextInt();

            switch (opGenero) {
                case 1:
                    this.genero = GeneroJogoEnum.ACAO;
                    break;
                case 2:
                    this.genero = GeneroJogoEnum.SANDBOX;
                    break;
                case 3:
                    this.genero = GeneroJogoEnum.TERROR;
                    break;
                case 4:
                    this.genero = GeneroJogoEnum.RPG;
                    break;
                case 5:
                    this.genero = GeneroJogoEnum.FPS;
                    break;
                case 6:
                    this.genero = GeneroJogoEnum.CORRIDA;
                    break;
                case 7:
                    this.genero = GeneroJogoEnum.SOBREVIVENCIA;
                    break;
                case 8:
                    this.genero = GeneroJogoEnum.LUTA;
                    break;
                case 9:
                    this.genero = GeneroJogoEnum.SIMULACAO;
                    break;
                case 10:
                    this.genero = GeneroJogoEnum.AVENTURA;
                    break;
                case 11:
                    this.genero = GeneroJogoEnum.RITMO;
                    break;
                case 12:
                    this.genero = GeneroJogoEnum.ESPORTS;
                    break;
                case 13:
                    this.genero = GeneroJogoEnum.EDUCACIONAL;
                    break;
                default:
                    System.out.println("Esse genero invalido. Por Favor, tente novamente!");
                    break;
            }
        } while (this.genero == null);


        do {
            System.out.println("------------------- OPÇÕES GENERO ----------------------" +
                    "\n(1) - Pc;" +
                    "\n(2) - Mobile;" +
                    "\n(3) - Console;" +
                    "\n(4) - Todas" +
                    "\nDigite qual das opções é a plataforma do jogo:");
            int opPlataforma = leitor.nextInt();

            switch (opPlataforma){

                case 1:
                    this.plataforma = PlataformasEnum.PC;
                    break;
                case 2:
                    this.plataforma = PlataformasEnum.MOBILE;
                    break;
                case 3:
                    this.plataforma = PlataformasEnum.CONSOLE;
                    break;
                case 4:
                    this.plataforma = PlataformasEnum.TODAS;
                    break;
                default:
                    System.out.println("Opção escolhida é invalida");
            }
        }while (this.plataforma == null);

        this.id = ContagemRegistros.getQtdJogos() + 1;
        System.out.println("---------JOGO-CADASTRADO-COM-SUCESSO!!---------");
        System.out.println("O Id desse jogo é: "+ this.getId());

        return this;
    }
}
