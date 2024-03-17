## Vector

É uma estrutura de dados derivada da classe List que implementa uma lista cujo tamanho é aumentado dinamicamente, tal como um array dinâmico. De forma também semelhante a ele, cada registro é feito sob um índice, por meio do qual pode-se acessar e manipular o elemento alocado. Contudo, diferentemente do array dinâmico, o Vector conta com métodos de adição, remoção, alteração e retorno do objeto. Exemplo: lista de controle de pacotes enviados.

## ArrayList

Assemelha-se ao Vector tanto em desempenho quanto em utilização, tendo sido introduzido pela JDK como uma versão mais performática da estrutura, o que popularizou a sua preferência desde então. Possui as mesmas características e métodos do Vector, diferindo-se apenas na alocação dinâmica — com a lista cheia, as posições são aumentadas em 50%, não em dobro. Exemplo: registro dos produtos num carrinho de compras.

## LinkedList

A classe LinkedList, diferentemente das demais, refere-se a um tipo de lista duplamente encadeada, na qual os objetos armazenados são nós (Node), que alocam, além do elemento em si, referências ao próximo e anterior. Por conta dessa particularidade, em relação ao ArrayList, apresenta uma melhor performance na alteração de registros, ao passo que se torna menos eficiente para adição e remoção. Exemplo: lista de instruções de preparo de uma receita.

## HashMap

Uma estrutura do tipo HashMap armazena pares de chave-valor, nos quais um é a chave (Key), que deve ser única, e o outro o valor em si (Value), cujo tipo deve ser de referência. A implementação da classe Map, por permitir a associação dos elementos a uma chave, demonstra-se muito eficiente para contextos que demandam buscas rápidas -— sem que seja preciso iterar elemento por elemento —, além de ser mais performática ao lidar com grandes quantidades de dados. Exemplo: registro de pessoas sob o CPF.