package br.com.biblioteca;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//inserirDados();
		//consultarDados();
		//alterarDados();
		//deletarDados();
		
		consultaDadosSimples();

	}
	
	public static void inserirDados() {
		Scanner scanner = new Scanner(System.in);
		Usuario usu = new Usuario();
		
		System.out.print("Digite seu nome: ");
        usu.nome = scanner.nextLine();
 
        System.out.print("Digite seu telefone: ");
        usu.telefone = scanner.nextLine();

        System.out.print("Digite sua rua: ");
        usu.rua = scanner.nextLine();

        System.out.print("Digite seu numero: ");
        usu.numero = scanner.nextLine();
        
        System.out.print("Digite seu complemento: ");
        usu.complemento = scanner.nextLine();

        System.out.print("Digite seu cep: ");
        usu.cep = scanner.nextLine();

        System.out.print("Digite seu bairro: ");
        usu.bairro = scanner.nextLine();
        
        System.out.print("Digite seu cidade: ");
        usu.cidade = scanner.nextLine();

        System.out.print("Digite seu estado: ");
        usu.estado = scanner.nextLine();

        usu.inserir();
	}
	
	public static void consultarDados() {
		Usuario usu = new Usuario();
		usu.consultar();
	}
	
	public static void alterarDados() {
		Scanner scanner = new Scanner(System.in);
		Usuario usu = new Usuario();
		
		
		System.out.print("Digite seu novo nome: ");
        usu.nome = scanner.nextLine();
 
        System.out.print("Digite seu novo telefone: ");
        usu.telefone = scanner.nextLine();

        System.out.print("Digite sua novo rua: ");
        usu.rua = scanner.nextLine();

        System.out.print("Digite seu novo numero: ");
        usu.numero = scanner.nextLine();
        
        System.out.print("Digite seu novo complemento: ");
        usu.complemento = scanner.nextLine();

        System.out.print("Digite seu novo cep: ");
        usu.cep = scanner.nextLine();

        System.out.print("Digite seu novo bairro: ");
        usu.bairro = scanner.nextLine();
        
        System.out.print("Digite seu novo cidade: ");
        usu.cidade = scanner.nextLine();

        System.out.print("Digite seu novo estado: ");
        usu.estado = scanner.nextLine();

        System.out.print("Digite a matricula do usuario: ");
        usu.matricula = scanner.nextInt();
        
        usu.alterar();
	}

	
	public static void deletarDados() {
		Scanner scanner = new Scanner(System.in);
		Usuario usu = new Usuario();
		
		System.out.print("Digite a matricula do usuario a ser DELETADO: ");
        usu.matricula = scanner.nextInt();
        
        usu.deletar();
		
	}
	
	public static void consultaDadosSimples() {
		Scanner scanner = new Scanner(System.in);
		Usuario usu = new Usuario();
		
		System.out.print("Digite a matricula do usuario a ser CONSULTADO: ");
        usu.matricula = scanner.nextInt();
        
        usu.consultaSimples();
		
	}
}
