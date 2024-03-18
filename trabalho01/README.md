# Atividade Avaliativa - Unidade 1

## Estrutura de Dados: Fila

Com base na análise do enunciado, pôde-se extrair do problema a necessidade de uma estrutura que atendesse a certos requisitos, a exemplo da eficiência na adição e remoção de registros. Contudo, considerando a temática de aplicação, que envolve o gerenciamento de tarefas, observei a essencialidade ainda maior de uma estrutura que lidasse facilmente com a visualização e manipulação dos objetos conforme a **ordem em que foram registrados**. Dessa forma, idealizei duas opções: Fila ou LinkedList (que implementasse List).

Por fim, optei por uma lista que implementasse a **Fila (Queue)**, uma vez que:

- A estrutura Fila segue o padrão FIFO (First-In-First-Out), sendo o mais adequado ao cenário de conclusão de tarefas — normalmente priorizam-se as tarefas adicionadas antes e, só então, parte-se para as seguintes;

- Conta com métodos para adição, remoção e alteração de registros — cumprindo com o primeiro requisito —, além de ser mais performática em relação ao redimensionamento e alocação de um grande número de dados se comparada a um Array, por exemplo;

- Por se tratar de uma Fila, cujo propósito é especialmente voltado à ordem de registro, a visualização da próxima tarefa a ser realizada é facilitada pelo método peek(), de modo que não se faz necessário varrer a fila;

- Por mais interessante que pareça a proposta do LinkedList de implementar, além das operações com os primeiros, também as operações com os últimos registrados, não é uma demanda contemplada pelo problema e, se considerada sua limitação com relação à memória e eficiência na inserção/remoção dos elementos, é possível concluir que a Fila ainda seja a opção mais adequada.
