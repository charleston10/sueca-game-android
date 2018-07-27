package com.charleston.sueca

class QuestionPresenter(private val questionView: QuestionView) {

    private val questions: ArrayList<QuestionData> = arrayListOf()

    init {
        questions.add(QuestionData("Escolhe uma pessoa para beber"))
        questions.add(QuestionData("Escolhe duas pessoas para beber"))
        questions.add(QuestionData("Verdade ou desafio"))
        questions.add(QuestionData(
                description = "Jogo do “Stop”",
                explanation = "Quem tirou a carta do deque escolhe uma categoria e uma letra do alfabeto e dá um exemplo. O próximo jogador tem que seguir o padrão. O primeiro que errar ou não souber, bebe. Por exemplo: O jogador escolhe “carros com a letra A”, e dá como exemplo “Audi”. O próximo diz “Astra”. O outro “Alfa Romeu”, e assim por diante"
        ))
        questions.add(QuestionData(
                description = "Jogo da Memória",
                explanation = "Quem tirou a carta fala uma palavra qualquer. O próximo tem que repetir a palavra anterior e adicionar uma. E assim por diante. Exemplo: Quem tirou a carta fala “jamanta”. O próximo fala “jamanta cabrito”. O próximo diz “jamanta cabrito mesa”, e assim por diante. O que errar ou demorar, bebe"
        ))
        questions.add(QuestionData(
                description = "Continência ",
                explanation = "Quem tirou o 6 guarda a carta (não a devolve ao monte de descarte, como as demais) e usa-a quando quiser. Discretamente, essa pessoa deve colocar a mão na testa, fazendo continência e observar os outros jogadores. O último que perceber e fizer continência, bebe"
        ))
        questions.add(QuestionData(
                description = "Jogo do “Pi”",
                explanation = "O jogador que tirou a carta fala o número 1. O próximo jogador fala o número seguinte (2) e assim por diante. A pegadinha é que todo múltiplo de três deve ser substituído pela palavra “pi”. Então fica assim: Quem tirou o três do deque fala “um”. O jogador à sua esquerda fala “dois”. O da esquerda fala “pi”. O próximo fala “quatro”. O outro “cinco”. O outro “pi”, e assim sucessivamente. Quem errar, ou demorar muito, bebe. Pode ser feito com o número 4 no lugar"
        ))
        questions.add(QuestionData(
                description = "Regra Geral",
                explanation = "Quem tira essa carta determina uma regra para todos obedecerem. Pode ser algo do tipo “está proibido falar a palavra ‘beber’ e seus derivados”, ou “antes de beber uma dose, a pessoa tem que rebolar”. Quem quebrar a regra, deve beber (às vezes, de novo). A Regra Geral pode ser substituída por outra Regra Geral, caso contrário, dura o jogo todo"
        ))
        questions.add(QuestionData(
                description = "Incontinência",
                explanation = "A carta é guardada e usa quando o jogador quiser. Ao invés da continência, o jogador bebe duas doses e faz 1 pessoa beber uma dose se ela se negar, o jogador bebe mais 2 doses"
        ))
        questions.add(QuestionData(
                description = "Cafofo",
                explanation = "uma rodada de cafofo. (Uma pessoa escolhida aleatoriamente inventa um tema acerca do qual se possa fazer uma lista, como por exemplo \"marcas de carros\", ou \"apelidos para o Piuí\". Ao fazer isso, ele diz um nome. O seguinte, outro. E assim por diante, até que alguém não saiba ou diga algum que já foi dito. Caso isso ocorra, a pessoa deve beber uma dose da bebida)"
        ))
        questions.add(QuestionData(
                description = "Todos bebem"
        ))
        questions.add(QuestionData(
                description = "Todas as mulheres da mesa bebem uma dose"
        ))
        questions.add(QuestionData(
                description = "Todos os homens da mesa bebem uma dose"
        ))
    }

    fun sort() {
        showLoading()
        questions.shuffle()
        questionView.hideLoading()
        questionView.showQuestion(questions[0])
    }

    private fun showLoading() {
        questionView.showLoading()
        Thread.sleep(1000)
    }
}