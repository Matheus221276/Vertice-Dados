Vertex Cover com Backtracking

Este projeto foi desenvolvido em Java e tem como objetivo resolver o problema Vertex Cover utilizando um algoritmo de backtracking exato com poda.

O programa permite que o usuário informe a quantidade de vértices e arestas de um grafo não direcionado. A partir dessas informações, o algoritmo encontra uma cobertura mínima de vértices, ou seja, o menor conjunto de vértices capaz de cobrir todas as arestas do grafo.

Objetivo do projeto

O objetivo deste projeto é aplicar conceitos de grafos e análise de algoritmos em um problema clássico da computação, conhecido como Vertex Cover.

No contexto do projeto, os vértices podem representar pontos estratégicos, e as arestas representam conexões entre esses pontos. A solução encontrada pelo algoritmo indica quais vértices devem ser escolhidos para que todas as conexões do grafo sejam cobertas.

O que é Vertex Cover

Em teoria dos grafos, uma cobertura de vértices é um conjunto de vértices no qual cada aresta do grafo possui pelo menos uma de suas extremidades dentro desse conjunto.

Por exemplo, se existe uma aresta entre os vértices 1 e 2, então pelo menos um desses dois vértices precisa estar presente na cobertura.

Tecnologias utilizadas

O projeto utiliza a linguagem Java, programação orientada a objetos, conceitos de grafos e algoritmo de backtracking.

Estrutura do projeto

O projeto é composto pelos seguintes arquivos:

Main.java

Graph.java

Edge.java

VertexCoverSolver.java

Descrição das classes

Main.java

É a classe principal do programa. Ela é responsável por ler os dados informados pelo usuário, validar a quantidade de vértices e arestas, impedir entradas inválidas, executar o algoritmo de Vertex Cover e exibir o resultado final junto com a análise de complexidade.

Graph.java

É a classe responsável por representar o grafo. Ela armazena a quantidade de vértices, a lista de arestas e também verifica se um vértice é válido ou se uma aresta já foi cadastrada.

Edge.java

É a classe que representa uma aresta do grafo. Cada aresta possui dois vértices, chamados de first e second.

VertexCoverSolver.java

É a classe responsável por resolver o problema Vertex Cover. Ela utiliza backtracking para testar possibilidades e encontrar a menor cobertura de vértices possível.

Como executar o projeto

Primeiro, clone o repositório para o seu computador.

Depois, acesse a pasta do projeto pelo terminal.

Em seguida, compile os arquivos Java com o comando javac *.java.

Por fim, execute o programa com o comando java Main.

Exemplo de uso

Entrada:

Quantidade de vertices: 4

Quantidade de arestas: 4

Aresta 1: 1 2

Aresta 2: 2 3

Aresta 3: 3 4

Aresta 4: 1 4

Saída esperada:

Resultado do Vertex Cover

Vertices escolhidos:

Vertice 1

Vertice 3

Tamanho da cobertura: 2

Observação: dependendo da ordem de análise do algoritmo, outra cobertura mínima de mesmo tamanho também pode ser exibida.

Análise de complexidade

O algoritmo utilizado é backtracking exato com poda.

A complexidade de tempo no pior caso é O(2^n * m), onde n representa a quantidade de vértices e m representa a quantidade de arestas.

A complexidade de memória é O(n + m).

A versão de decisão do problema Vertex Cover é NP-Completa. Já a versão de otimização, que busca a menor cobertura possível, é NP-Difícil.

Validações implementadas

O programa valida se a quantidade de vértices é maior que zero.

Também valida se a quantidade de arestas está dentro do limite possível para o grafo.

Além disso, impede o cadastro de vértices inexistentes, arestas repetidas e laços, como uma aresta ligando o vértice 1 a ele mesmo.

Exemplo de aplicação

O projeto pode ser aplicado em uma simulação de tomada de decisão estratégica, como uma situação de war room.

Nesse cenário, os vértices podem representar bases, regiões ou pontos de controle, enquanto as arestas representam conexões entre eles. O algoritmo indica quais pontos devem ser selecionados para cobrir todas as conexões existentes.
