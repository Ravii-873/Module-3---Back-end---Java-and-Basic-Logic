## 3035 Teach's Module 3 - Back-end - Java and Basic Logic

### O que este repositório contém

O repositório armazena tarefas de treino e desafios práticos para o terceiro módulo do curso 3035 Teach.

Cada tarefa ou desafio tem um *PDF* com as instruções que motivaram o desenvolvimento da tarefa.

#### Requerimentos
- Java 7 ou superior
- Git ou forma de clonar o projeto

#### Clonando o repositório
1. Navegue até a pasta para onde deseja clonar o repositório.
2. Abra-a no terminal.
```
git clone https://github.com/Ravii-873/Module-3---Back-end---Java-and-Basic-Logic.git
cd Module-3---Back-end---Java-and-Basic-Logic
```

Agora você tem o repositório clonado e aberto em seu terminal!

### Estrutura de arquivos

```
./
├── Final-Challenge---Guessing-Game/
│   ├── Final Challenge Instructions.pdf
│   └── src/
│       ├── Main.java
│       ├── Play.java
│       ├── Stats.java
│       └── Tips.java
├── README assets/
├── README.md
├── task-1/
│   ├── src/
│   │   └── Main.java
│   └── Task 1 Instructions.pdf
├── task-2/
│   ├── src/
│   │   ├── Ex1.java
│   │   ├── Ex2.java
│   │   └── Ex3.java
│   └── Task 2 Instructions.pdf
├── task-3/
│   ├── Exercises.txt
│   └── Task 3 Instructions.pdf
├── task-4/
│   ├── src/
│   │   ├── Ex1.java
│   │   ├── Ex2.java
│   │   ├── Ex3.java
│   │   ├── Ex4.java
│   │   ├── Ex5.java
│   │   ├── Ex6.java
│   │   └── Ex7.java
│   └── Task 4 Instructions.pdf
└── task-5/
    ├── src/
    │   ├── Ex1.java
    │   ├── Ex2.java
    │   ├── Ex3.java
    │   ├── Ex4.java
    │   └── Ex5.java
    └── Task 5 Instructions.pdf
```

### Como executar
Cada tarefa tem um formato específico:
- task-3 é integralmente teórica. Somente leitura, sem execução.
- task-{1, 2, 4, 5} têm múltiplos exercícios.
    Cada um deles pode ser testado:
###### Exemplo de teste para task-1 / Ex1

```
cd task-1/src
javac Ex1.java
java Ex1
```

### Final Challenge - Guessing Game

1. Leia as instruções do projeto em seu *PDF*.

##### Executando

```
cd Final-Challenge---Guessing-Game/src
javac Main.java
java Main
```

Confira se você entrou no menu principal do jogo:

![Menu principal](README%20assets/main-menu.png)

#### Como jogar

Recomenda-se que se comece lendo as regras do jogo.
Para isto, digite ```2```.

- O jogo tem modos e dificuldades que podem ser selecionados pelo jogador antes de toda partida.
- A mecânica consiste em adivinhar números ou sequências de números aleatórios no menor número de tentativas possível.

##### Modos:
1. Simples (um número sorteado)
    - Fácil
    - Médio
    - Difícil
2. Sequência (três números sorteados)
    - Avançado
    - Especialista

#### Dicas

Você pode pedir uma dica a qualquer momento do jogo.
Para isto, ao invés de tentar adivinhar o valor sorteado, 
digite um dos seguintes valores NEGATIVOS, 
conforme o tipo desejado de dica: 

    -1. Dica sobre a paridade do(s) valor(es) sorteado(s) (par/ímpar)
    -2. Dica sobre o(s) intervalo(s) do(s) valor(es) sorteado(s) (inferior/superior)
    -3. Dica sobre a proximidade do chute anterior ao(s) valor(es) sorteado(s) (quente/morno/frio)

Toda dica é paga com pontos a menos no resultado da partida:

    -1. -10 pontos
    -2. -20 pontos
    -3. -15 pontos

Seu **histórico** de partidas e **recordes** é armazenado em toda execução do programa.