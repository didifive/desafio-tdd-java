# DESAFIO TDD - Programa Start

## Description
Repositório para entrega do Desafio TDD (semana 30/05 ~ 03/06/2022) - Programa GFT Start  
Neste desafio foram utilizados os exercícios 1, 2, 3 e 7 do Desafio de POO para aplicar testes à eles.  
Adicionalmente (Exceeds):
- Foi criado uma única main (DesafioTDDApp) que possui opções para chamar os outros métodos;
- Foram feitos os desafios: [Desafio Jokenpo] e [Desafio Dependências Transitivas] disponíveis no site [DojoPuzzles.com],
a descrição dos desafios estão na seção abaixo "Extra Challenges".

## Extra Challenges

### Jokenpo
Jokenpo é uma brincadeira japonesa, onde dois jogadores escolhem um dentre três possíveis itens: Pedra, Papel ou Tesoura.  
O objetivo é fazer um juiz de Jokenpo que dada a jogada dos dois jogadores informa o resultado da partida.  
As regras são as seguintes:  
- Pedra empata com Pedra e ganha de Tesoura
- Tesoura empata com Tesoura e ganha de Papel
- Papel empata com Papel e ganha de Pedra  

Link [Desafio Jokenpo].

### Dependências Transitivas
Vamos escrever algum código para calcular como as dependências se propagam entre coisas como classes em um programa.  
Código altamente acoplado é o código onde as dependências entre suas partes são densas, muitas coisas dependem de muitas outras. Este tipo de código é difícil de entender e manter, e tende a ser frágil, falhando facilmente quando fazemos alguma mudança.  
Existem muitos tipos diferentes de acoplamento. O mais simples de trabalhar programaticamente é o 'acoplamento estático'. De forma simples podemos dizer que a classe A é estaticamente acoplada a classe B se o compilador precisa da definição de B para compilar A.  
As dependências podem ser transitivas - se A depende de B e B depende de C, então A depende de B e C. Então vamos escrever um código que calcula o conjunto completo de dependências para um grupo de classes. O código recebe como entrada um conjunto de linhas, onde em cada linha, o primeiro token é o nome da classe. Os token seguintes são os nomes das classes que a primeira classe depende.  
Dada a seguinte entrada, sabemos que A depende diretamente de B e C, e C depende de G, portanto A também depende de G:  
A B C  
B C E  
C G  
D A F  
E F  
F H  
O conjunto de dependências completo para cada classe, para o conjunto anterior seria:  
A &nbsp;&nbsp;B C E F G H  
B &nbsp;&nbsp;C E F G H  
C &nbsp;&nbsp;G  
D &nbsp;&nbsp;A B C E F G H  
E &nbsp;&nbsp;F H  
F &nbsp;&nbsp;H  
Link [Desafio Dependências Transitivas].

## Installation
O projeto foi feito utilizando:
- [IDE Eclipse] versão 2022-03 (4.23.0)
- [Maven] 
- [Java 11]
- [JUnit 4.11]  

Para a abrir o projeto basta clonar o repositório ou realizar o download e após:
- Importar o projeto, preferencialmente na IDE Eclipse;
- Fazer atualizações das dependências do Maven (Alt+F5 no Eclipse).

## Tests
Os testes foram feitos utilizando o JUnit 4.11 e Mockito 4.6.0 que estão como dependências do projeto, basta atualizar as dependências do Maven para poder rodar os testes.

## Usage
Para abrir o sistema que contém TODAS as opções das atividades, basta executar (Run) a classe abaixo:
- Classe Principal (Main) `DesafioTDDApp` no pacote `com.gft.desafio.main`.

Adicionalmente pode-se abrir as atividades individualmente executando (Run) cada classe principal conforme lista abaixo:

| Classe                    | Pacote                              |
|---------------------------|-------------------------------------|
| `Exercicio1`              | `com.gft.desafio.exercicio1`        |
| `Exercício2`              | `com.gft.desafio.exercicio2`        |
| `Exercício3`              | `com.gft.desafio.exercicio3`        |
| `Exercício7`              | `com.gft.desafio.exercicio7`        |
| `Jokenpo `                | `com.gft.desafio.extrajokenpo`      |
| `DependenciasTransitivas` | `com.gft.desafio.extradependencias` |

## Support
Dúvidas ou problemas abrir Issue

## Authors and acknowledgment
Desafio proposto por Michel, Ubiratran, Clécio e equipe do Programa Start da GFT.  
Desafios extras [Desafio Jokenpo] e [Desafio Dependências Transitivas] por [DojoPuzzles.com].

## Project status
Done in jun/02/2022.


[Desafio Jokenpo]: https://dojopuzzles.com/problems/jokenpo/
[Desafio Dependências Transitivas]: https://dojopuzzles.com/problems/dependencias-transitivas/
[DojoPuzzles.com]: https://dojopuzzles.com/
[Java 11]: https://docs.oracle.com/en/java/javase/11/docs/api/index.html
[JUnit 4.11]: https://junit.org/junit4/
[IDE Eclipse]: https://www.eclipse.org/ide/
[Maven]: https://maven.apache.org/