# 📚 3035 Teach - Módulo 3 - Back-end - Java e Lógica Básica

### 📦 O que este repositório guarda

O repositório armazena tarefas de treino e desafios práticos para o terceiro módulo do curso 3035 Teach.
[3035 Teach](https://www.instagram.com/3035teach/) é um curso full stack de programação e soft skills de 7 meses.

Cada tarefa ou desafio tem um *PDF* com as instruções que motivaram o desenvolvimento da tarefa.

### 🛠️ Requisitos
- [JDK 8 (LTS) ou superior](https://www.oracle.com/br/java/technologies/downloads/#java25)
- [Git](https://github.com/git-guides/install-git) ou baixe o *ZIP* pelo botão Code do GitHub.

### 📥 Clonando o repositório
Abra o terminal na pasta onde quer o projeto e rode:

```
git clone https://github.com/Ravii-873/Module-3---Back-end---Java-and-Basic-Logic.git
cd Module-3---Back-end---Java-and-Basic-Logic
```

Agora você tem o repositório clonado e aberto em seu terminal!

### 🗂️ Estrutura de arquivos

```
./
├── Final-Challenge---Guessing-Game/
│   ├── Final Challenge Instructions.pdf
│   └── src/            -> Arquivos .java
│       ├── Main.java   -> Mostra e administra menus e chamadas de métodos
│       ├── Play.java   -> Executa o jogo
│       ├── Stats.java  -> Armazena e mostra histórico e recordes
│       └── Tips.java   -> Processa e apresenta dicas
├── task-1/
│   ├── src/
│   │   └── Main.java   -> Hello world
│   └── Task 1 Instructions.pdf
├── task-2/
│   ├── src/
│   │   ├── Ex1.java    -> Nome & Idade
│   │   ├── Ex2.java    -> Operações matemáticas
│   │   └── Ex3.java    -> Imprime salário
│   └── Task 2 Instructions.pdf
├── task-3/
│   ├── Exercises.txt   -> Respostas da lista de operações lógicas
│   └── Task 3 Instructions.pdf
├── task-4/
│   ├── src/
│   │   ├── Ex1.java    -> A+B < C
│   │   ├── Ex2.java    -> Estado civil
│   │   ├── Ex3.java    -> Par ou ímpar
│   │   ├── Ex4.java    -> Somar ou multiplicar
│   │   ├── Ex5.java    -> Dobro ou triplo
│   │   ├── Ex6.java    -> Soma 5 ou 8
│   │   └── Ex7.java    -> Ordem descrescente
│   └── Task 4 Instructions.pdf
└── task-5/
    ├── src/
    │   ├── Ex1.java    -> 0-100 pares
    │   ├── Ex2.java    -> Acertar um inteiro aleatório
    │   ├── Ex3.java    -> Tabuada
    │   ├── Ex4.java    -> Quantidade de maiores de idade
    │   └── Ex5.java    -> Pares até o número digitado
    └── Task 5 Instructions.pdf
```

### ▶️ Como executar
Cada tarefa tem um formato específico:
- `task-1` tem somente /src/Main.java, com o clássico "Hello, world!" sendo impresso.
- `task-3` é integralmente teórica. Somente leitura, sem execução.
- `task-2, task-4, task-5` têm múltiplos exercícios.
    Cada um deles pode ser testado:

*Exemplo de teste para task-4 / Ex2*

```
cd task-4/src
javac Ex2.java
java Ex2
```

## 🎮 Desafio Final - Jogo de Adivinhação

Leia as instruções dadas para o projeto em seu *PDF*.

**Resumo:** 
O projeto consiste em um jogo *CLI* simples programado em Java.
- O objetivo do jogador é adivinhar números ou conjuntos de números aleatórios dentro de um limite de tentativas. 
- Sua pontuação é contabilizada de acordo com critérios específicos e é registrada num histórico temporário durante a execução.

### 🚀 Executando

```
cd Final-Challenge---Guessing-Game/src
javac Main.java
java Main
```

Observação: `javac Main.java` funciona porque `Main`, `Play`, `Stats` e `Tips` estão na mesma pasta.

Confira se você entrou no menu principal do jogo:

![Menu principal](README%20assets/main-menu.png)

### 🕹️ Como jogar

- Recomenda-se que se comece lendo as regras do jogo. Para isto, digite `2`.
- Para começar uma nova partida, digite `1`.
- Após registrar ao menos uma partida, digite `3` para conferir histórico e recordes.
- Digite `4` para sair.

**Objetivo:** Adivinhar número(s) aleatório(s) num intervalo com o menor número de tentativas possível.
- O jogo tem modos e dificuldades que podem ser selecionados pelo jogador antes de toda partida.

#### Modos:
1. Simples (um número sorteado)
    - Fácil
    - Médio
    - Difícil
2. Sequência (três números sorteados)
    - Avançado
    - Especialista

#### 💡 Dicas

Você pode pedir uma dica a qualquer momento do jogo.
Para isto, ao invés de tentar adivinhar o valor sorteado, 
digite um dos seguintes valores NEGATIVOS, 
conforme o tipo desejado de dica: 

*N é a quantidade de valores sorteados no modo.*

| Digite | Dica | Custo |
| :--- | :--- | ---: |
| `-1` | Paridade (par/ímpar) | -10 * N pts |
| `-2` | Intervalo (inferior/superior) | -20 * N pts |
| `-3` | Proximidade (quente/morno/frio) | -15 * N pts |

Seu **histórico** de partidas e **recordes** é armazenado em toda execução do programa.

#### ✨ Demonstração de execução do jogo

<a href="https://www.youtube.com/watch?v=c-8jcJi0Tjs">DEMONSTRAÇÃO: 3035 Teach 2026 - Módulo 3 - Desafio Final - Jogo de Adivinhação</a>

### ⚖️ LICENÇA

Este repositório é protegido pela <a href="./LICENSE">**MIT License**</a>
