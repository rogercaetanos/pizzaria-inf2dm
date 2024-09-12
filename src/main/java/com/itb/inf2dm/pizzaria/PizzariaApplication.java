package com.itb.inf2dm.pizzaria;

import com.itb.inf2dm.pizzaria.exceptions.ErrorMessage;
import com.itb.inf2dm.pizzaria.model.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzariaApplication {

	public static void main(String[] args) {

		SpringApplication.run(PizzariaApplication.class, args);

		System.out.println("Meu primeiro projeto Spring Boot Turma Inf2dm");

		Produto p1 = new Produto();
		// p1.valorVenda = -54.00; Acesso não mais permitido, modificador de acesso agora é private

		// Testando o encapsulamento completo
		p1.setValorVenda(-54.00);
		p1.validarProduto();
		System.out.println("Valor Produto " + p1.getValorVenda() + " Informação: " + p1.getMensagemErro());

		// Testando métodos construtores

		// Construtor padrão

		 // Toda classe já vem com o construtor padrão de fábrica
         // O método construtor tem o mesmo nome da classe, ele é considerado padrão quando não recebe parâmetros
	     // Exemplo:
		  // ErrorMessage errorMessage  = new ErrorMessage(); // AQUI NÃO É POSSÍVEL CRIAR UM OBJETO,
		  // Pois o contrutor padrão foi eliminando
		  // Obs: Quando criamos um construtor com parâmetros, O CONSTRUTOR PADRÃO DEIXA DE EXISTIR!
		  //       devendo ser recriado a critério!




	}

}
