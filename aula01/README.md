# Estruturas de Dados

## O que é estrutura de dados?

Estruturas de dados são formas de organizar, armazenar e manipular dados de forma eficiente, possibilitando seu acesso e modificação de modo organizado e previsível, adequado ao contexto e às necessidades da aplicação.

## Qual sua importância?

As estruturas de dados permitem maior eficiência e organização no armazenamento e manipulação dos dados, tanto no que se refere à alocação de memória quanto na otimização do programa. Além disso, a variedade de estruturas possiblita a adequação do formato de organização dos dados em relação às características e demandas do problema, por exemplo, no que diz respeito ao controle das operações CRUD ou da flexibilidade no processo de armazenagem.

## Explique e exemplifique as estruturas: array (estático e dinâmico), lista, fila e pilha.

### Array

Um array, um dos tipos mais simples e fundamentais da programação, pode ser apontado como uma coleção **ordenada** de registros do **mesmo tipo**, armazenados sob um nome e um índice, por meio do qual é possível acessar e manipular um elemento — não possui métodos para as operações CRUD. Quanto à dimensão, um array pode ser unidimensional (vetor) ou bidimensional (matriz). Já quanto a alocação de memória, tem-se dois tipos de array:

#### a. Estático
Trata-se de um array cujo tamanho do conjunto de elementos é **fixo** e não redimensionável. Sua capacidade de registros é definida no momento da declaração e não pode ser alterada durante a execução do programa.
Exemplo: array dos meses do ano; array de nomes de convidados.

#### b. Dinâmico
Ao contrário do estático, o array dinâmico pode ser **redimensionado** durante a execução do programa, desde que, em sua declaração inicial, não tenha sido inicializado com uma capacidade pré-estabelecida. Para tanto, pode-se utilizar um método interno que realize a atribuição de um array temporário ao vetor de tamanho indefinido.
Exemplo: array de livros de uma biblioteca.

### Lista

De forma semelhante aos arrays, listas são **coleções ordenadas** de objetos registrados sob um índice. Contudo, a principal diferença em relação ao vetor está na **flexibilidade** e variedade da estrutura, haja vista a possibilidade de redimensionamento e facilidade de acesso e manipulação — possui métodos para CRUD. Permitem maior eficiência na alocação de grandes quantidades de elementos. Exemplo: lista de tarefas (adição, remoção, alteração).

#### Tipos que implementam a interface List
- ArrayList;
- LinkedList.

### Fila

A estrutura de dados fila ou *queue* segue o princípio **FIFO (First In First Out)**, ou seja, o primeiro a entrar é o primeiro a sair, de modo que a ordem de remoção dos elementos segue a ordem de inserção. Dispõe de métodos para adicionar, remover e exibir o primeiro da fila. Exemplo: fila de impressão de documentos.