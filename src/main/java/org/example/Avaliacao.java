package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Avaliacao {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int pergunta = 0;
        int refazer = 1;
        System.out.println("Código feito por Henrique da Silva Strada");
        System.out.println("https://github.com/HenriqueStrada");
        while (refazer == 1) {
            while (pergunta > 3 || pergunta < 1) {
                System.out.println("""
                        Qual atividade você deseja selecionar para correção?
                        Primeira atividade = 1
                        Segunda atividade = 2
                        Terceira atividade = 3
                        """);
                pergunta = scr.nextInt();
                if (pergunta > 3 || pergunta < 1) {
                    System.out.println("Digite um valor válido entre 1 e 3!");
                }
            }

            if (pergunta == 1) {
                Gasolina minhaGasolina = new Gasolina();
                minhaGasolina.executarCalculos();
                System.out.println("Você deseja refazer alguma atividade? (Não = 0 // Sim = 1)");
                refazer = scr.nextInt();
                pergunta = 0;
            } else if (pergunta == 2){
                Socios meusSocios = new Socios();
                meusSocios.executarSocios();
                System.out.println("Você deseja refazer alguma atividade? (Não = 0 // Sim = 1)");
                refazer = scr.nextInt();
                pergunta = 0;
            } else if (pergunta == 3){
                Id meusIds = new Id();
                meusIds.executarId();
                System.out.println("Você deseja refazer alguma atividade? (Não = 0 // Sim = 1)");
                refazer = scr.nextInt();
                pergunta = 0;
            }
        }
    }
}

class Gasolina {
    int mes = 0;
    double distancia = 0;
    double media = 0;
    double valor = 0;
    double valor_final = 0;

    void executarCalculos() {
        Scanner scr = new Scanner(System.in);

        System.out.println("Grabiel, qual a distância de sua casa para seu trabalho em Km?");
        distancia = scr.nextDouble();
        System.out.println("Qual a média de Km que seu carro faz por litro?");
        media = scr.nextDouble();
        System.out.println("Qual o valor da gasolina em sua cidade?");
        valor = scr.nextDouble();

        while (mes > 30 || mes < 1) {
            System.out.println("Quantos dias no mês você vai trabalhar?");
            mes = scr.nextInt();
            if (mes > 30 || mes < 1) {
                System.out.println("Por favor digite um valor válido entre 1 e 30!");
            }
        }

        valor_final = (distancia / media) * valor * mes;
        String valor_final_formatado = String.format("%.2f", valor_final);
        System.out.println("""
                ====================================
                Distância em Km:\s""" + distancia + """
                Km \n
                Média por litro em Km:\s""" + media + """
                Km \n
                Valor da gasolina em reais: R$""" + valor + """
                \n
                Quantidade de dias trabalhados:\s""" + mes + """
                \n
                Valor médio a se pagar pela gasolina por mês em reais: R$""" + valor_final_formatado + """
                \n
                ====================================
                """
        );
    }
}

class Socios {
    void executarSocios(){
        Scanner scr = new Scanner(System.in);
        System.out.print("Quantos sócios participaram do senso? ");
        int numSocios = scr.nextInt();
        String[] nomes = new String[numSocios];
        char[] sexos = new char[numSocios];
        double[] alturas = new double[numSocios];
        double[] salarios = new double[numSocios];
        int[] filhos = new int[numSocios];

        for (int i = 0; i < numSocios; i++) {
            System.out.println("Dados do sócio " + (i + 1) + ":");
            scr.nextLine();

            System.out.print("Nome: ");
            nomes[i] = scr.nextLine();

            System.out.print("Sexo (M/F): ");
            sexos[i] = scr.next().charAt(0);

            System.out.print("Altura (em metros): ");
            alturas[i] = scr.nextDouble();

            System.out.print("Salário: R$");
            salarios[i] = scr.nextDouble();

            System.out.print("Quantidade de filhos: ");
            filhos[i] = scr.nextInt();
        }

        System.out.println("Opções de relatório:");
        System.out.println("1- Lista de sócios");
        System.out.println("2- Média da altura dos associados");
        System.out.println("3- Total de dependentes");
        System.out.println("4- Quantidade de homens e mulheres");
        System.out.println("5- Maior salário e nome dos associados");
        System.out.println("6- Encerrar o programa");
        System.out.print("Escolha uma opção: ");
        int opcao = scr.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("==================================");
                for (int i = 0; i < numSocios; i++) {

                    System.out.println("Dados do sócio " + (i + 1) + ":");

                    System.out.println("Nome: " + nomes[i]);

                    System.out.println("Sexo: " + sexos[i]);

                    System.out.println("Altura: " + alturas[i] + " metros");

                    System.out.println("Salário: R$" + salarios[i]);

                    System.out.println("Quantidade de filhos: " + filhos[i]);
                    System.out.println("==================================");
                }
                break;
            case 2:
                double somaAlturas = 0;
                for (double altura : alturas) {
                    somaAlturas += altura;
                }
                double mediaAltura = somaAlturas / alturas.length;
                System.out.println("Média da altura dos associados: %.2f metros%n" + mediaAltura);
                break;
            case 3:
                int somaFilhos = 0;
                for (double filho : filhos) {
                    somaFilhos += (int) filho;
                }
                System.out.println("A quantidade total de dependentes de nossos Socios é de: " + somaFilhos + " Filhos.");
                break;
            case 4:
                int quantidadeHomens = 0;
                int quantidadeMulheres = 0;
                int totalPessoas = sexos.length;
                for (char sexo : sexos) {
                    if (sexo == 'M' || sexo == 'm') {
                        quantidadeHomens++;
                    } else if (sexo == 'F' || sexo == 'f') {
                        quantidadeMulheres++;
                    }
                }
                double porcentagemHomens = (double) quantidadeHomens / totalPessoas * 100;
                double porcentagemMulheres = (double) quantidadeMulheres / totalPessoas * 100;
                System.out.println("Quantidade de homens: " + quantidadeHomens + " (" + String.format("%.2f", porcentagemHomens) + "%)");
                System.out.println("Quantidade de mulheres: " + quantidadeMulheres + " (" + String.format("%.2f", porcentagemMulheres) + "%)");
                break;
            case 5:
                double maiorSalario = 0;
                ArrayList<String> nomesMaioresSalarios = new ArrayList<>();
                for (int i = 0; i < salarios.length; i++) {
                    if (salarios[i] >= maiorSalario) {
                        if (salarios[i] > maiorSalario) {
                            maiorSalario = salarios[i];
                            nomesMaioresSalarios.clear();
                        }
                        nomesMaioresSalarios.add(nomes[i]);
                    }
                }
                System.out.println("Maior salário: " + maiorSalario);
                System.out.println("Nome(s) do(s) associado(s) que ganha(m) o maior salário: ");
                for (String nome : nomesMaioresSalarios) {
                    System.out.print(nome + "\n");
                }
                break;
            case 6:
                System.out.println("Encerrando o programa. Até mais!");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}

class Id {

    void executarId(){

        ArrayList<Pessoa> pessoas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("ID (0 para parar): ");

            int id = scanner.nextInt();

            if (id == 0) break;

            System.out.print("Nome: ");

            String nome = scanner.next();

            System.out.print("Idade: ");

            int idade = scanner.nextInt();

            System.out.print("Altura: ");

            double altura = scanner.nextDouble();

            System.out.print("Peso: ");

            double peso = scanner.nextDouble();

            Pessoa pessoa = new Pessoa(id, nome, idade, altura, peso);

            pessoas.add(pessoa);

        }

        // Ordenar por ID crescente
        Collections.sort(pessoas, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa p1, Pessoa p2) {
                return Integer.compare(p1.id, p2.id);
            }
        });

        System.out.println("Pessoas por ID crescente:");

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.id + " - " + pessoa.nome);
        }

        // Ordenar por IMC decrescente
        Collections.sort(pessoas, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa p1, Pessoa p2) {
                return Double.compare(p2.imc, p1.imc);
            }
        });

        System.out.println("Pessoas por IMC decrescente:");

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.imc + " - " + pessoa.nome);
        }

        // Ordenar por altura crescente
        Collections.sort(pessoas, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa p1, Pessoa p2) {
                return Double.compare(p1.altura, p2.altura);
            }
        });

        System.out.println("Pessoas por altura crescente:");

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.altura + " - " + pessoa.nome);
        }

        double somaIdade = 0;
        double somaAltura = 0;
        double somaPeso = 0;
        double somaIMC = 0;

        for (Pessoa pessoa : pessoas) {
            somaIdade += pessoa.idade;
            somaAltura += pessoa.altura;
            somaPeso += pessoa.peso;
            somaIMC += pessoa.imc;
        }

        int quantidadePessoas = pessoas.size();
        double mediaIdade = somaIdade / quantidadePessoas;
        double mediaAltura = somaAltura / quantidadePessoas;
        double mediaPeso = somaPeso / quantidadePessoas;
        double mediaIMC = somaIMC / quantidadePessoas;

        System.out.println("Médias:");
        System.out.println("Idade: " + mediaIdade);
        System.out.println("Altura: " + mediaAltura);
        System.out.println("Peso: " + mediaPeso);
        System.out.println("IMC: " + mediaIMC);
    }
class Pessoa {
    int id;
    String nome;
    int idade;
    double altura;
    double peso;
    double imc;
    public Pessoa(int id, String nome, int idade, double altura, double peso) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.imc = calcularIMC();
    }
    private double calcularIMC() {
        return peso / (altura * altura);
        }
    }
}