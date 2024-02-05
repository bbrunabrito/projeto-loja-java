# Projeto de Sistema de Gerenciamento de Loja

## Índice
* [Objetivo](#objetivo)
* [Descrição do Projeto](#descrição)
* [Etapas](#etapa-1)
  * [Etapa 1](#etapa-1)
  * [Etapa 2](#etapa-2)
  * [Etapa 3](#etapa-3)
  * [Etapa 4](#etapa-4)
  * [Etapa 5](#etapa-5)
* [Implementações Adicionais](#extras)
* [Licença](#licença)

## Objetivo
Esse projeto tem como objetivo treinar os conceitos básicos de Java, como orientação a objetos, herança e
polimorfismo, assim como uma breve introdução à arquitetura de software, design de projetos e boas práticas.

## Descrição
A ideia foi criar um projeto em Java 8, que simule uma pequena loja, com cadastro de funcionários, clientes,
produtos e que seja capaz de realizar uma venda simples.

O projeto foi dividido em etapas.

## Etapa 1
Nesse começo, o objetivo é modelar como será o projeto, definindo "regras" para cada entidade.

### Requisitos
Primeiramente, deve ser criado 3 entidades, onde deverão ser modeladas seguindo as regras abaixo, ou seja, as
informações que elas devem conter.<br>
Cada uma dessas entidades, representadas por classes, deverão ter seus respectiovos métodos **Getter** 
e **Setter**, como também **Equals** e **ToString**.

#### Vendedor
- Nome
- Idade
- Gênero

#### Cliente
* Nome
* CPF
* Idade
* Gênero

#### Produto
- Descrição
- Preço
- Estoque

---
## Etapa 2
O objetivo dessa etapa é fazer uma simulação de venda simplificada para fazer uma relação entre as
entidades criadas.
<br>
### Requisitos
Adicionar o atributo ***código*** no produto. <br> 
Criar um sistema de vendas que faça o seguinte:
- Tenha um produto vinculado;
- Consiga registrar o vendedor e o cliente;
- Subtraia o valor de estoque do produto;
- Calcular o valor da venda;
- Registre a data e hora da venda.

---
## Etapa 3
Essa etapa tem como objetivo aplicar exceções.
### Requisitos
Criar uma classe de exceção com o nome que preferir, estendendo da classe básica **Exception**, com
os seguintes atributos:
- Mensagem, informando um resumo do erro;
- Detalhes, informando uma mensagem mais clara do porquê do erro ter sido causado;
- Código de erro, podendo conter letras e números.
<br>



> 💡 Dica: Utilize um Enum para salvar e relacionar cada valor, eles podem salvar vários valores de uma vez ao invés de um só.


Implemente essa nova classe de erros na sua função de realizar a venda.

Lembre-se de que toda função que pode lançar uma exceção deve ter uma cláusula **throws Exception** ao final.

Lembre-se também de que toda função que pode lançar uma exceção deve estar dentro de um bloco **try…catch** quando for chamada.


> 💡 Dica: Para não interromper a execução do seu programa com a exceção, ao chegar no **catch** você pode simplesmente imprimir a mensagem de erro na tela e seguir executando ou escrever o resto da aplicação no bloco **finally**.

---
## Etapa 4
Nessa etapa, o foco é melhorar o código utilizando o máximo possível do Java.
### Requisitos
Modifique todos os atributos de números racionais (float, double, etc.) para **BigDecimal**.

Todas as operações airtméticas terão de ser substituídas por funções nativas da classe BigDecimal, como *multiply*, *divide*, *subtract*, *add* e *compareTo*.

Para inicializar um valor com esse tipo, basta usar a função estática *valueOf* ou alguma constante também estática, como *ZERO* ou *TEN*.

> 💡 Dica: as funções de operação retornam o valor do resultado ou um inteiro que simula booleano (1, 0 e -1) ao invés de aplicar direto no objeto passado a elas.
---

## Etapa 5
O foco aqui é aplicar o conhecimento sobre testes unitários.
### Requisitos
Utilizando o JUnit(4 ou 5), escreva testes unitários que apresentem uma cobertura de pelo menos 80% do código.

> 💡 Dica: a arquitetura de projeto da parte de testes deve seguir o mesmo padrão da normal, se você fez uma classe no pacote com.loja.venda.Venda, nos testes deverá ficar algo como com.loja.venda.VendaTest

---
## Extras

### Menu
Foi construído um Menu para que o usuário possa interagir com o sistema da loja.<br>
(![Menu do Programa](https://github.com/bbrunabrito/projeto-loja-java/assets/80168079/1d7ac987-4b5b-440d-9d61-9050470b7db0)
)

---
## Licença
Esse projeto é licenciado pelo [MIT](LICENSE).
