package com.charleston.sueca.features.questions

import com.charleston.sueca.R

class QuestionPresenter(private val questionView: QuestionView) {

    private val questions: ArrayList<QuestionData> = arrayListOf()
    private var questionCurrent: QuestionData? = null

    init {
        initCards()
    }

    fun sort() {
        showLoading()
        questionCurrent = getCardRandom()

        if (questionCurrent != null) {
            questionView.showQuestion(questionCurrent!!, questionCurrent!!.getCardRandom())
            questions.remove(questionCurrent!!)
            verifyReset()
        }
    }

    private fun verifyReset(){
        if(questions.size == 0){
            initCards()
        }
    }

    fun getQuestionCurrent(): QuestionData? {
        return questionCurrent
    }

    private fun getCardRandom(): QuestionData {
        questions.shuffle()
        return questions[0]
    }

    private fun showLoading() {
        Thread.sleep(600)
    }

    private fun initCards(){
        questions.addAll(createQuestions())
        questions.addAll(createQuestions())
    }

    private fun createQuestions() : ArrayList<QuestionData> {
        val questions : ArrayList<QuestionData> = arrayListOf()

        questions.add(QuestionData(
                description = "Escolha uma pessoa para beber",
                cards = arrayListOf(R.drawable.card_ac, R.drawable.card_ah, R.drawable.card_as, R.drawable.card_ad)
        ))
        questions.add(QuestionData(
                description = "Escolha duas pessoas para beber",
                cards = arrayListOf(R.drawable.card_2c, R.drawable.card_2h, R.drawable.card_2s, R.drawable.card_2d)
        ))
        questions.add(QuestionData(
                description = "Verdade ou desafio",
                cards = arrayListOf(R.drawable.card_3c, R.drawable.card_3h, R.drawable.card_3s, R.drawable.card_3d)
        ))
        questions.add(QuestionData(
                description = "Jogo do “Stop”",
                explanation = "Quem tirou a carta do deque escolhe uma categoria e uma letra do alfabeto e dá um exemplo. O próximo jogador tem que seguir o padrão. O primeiro que errar ou não souber, bebe. Por exemplo: O jogador escolhe “carros com a letra A”, e dá como exemplo “Audi”. O próximo diz “Astra”. O outro “Alfa Romeu”, e assim por diante",
                cards = arrayListOf(R.drawable.card_4c, R.drawable.card_4h, R.drawable.card_4s, R.drawable.card_4d)

        ))
        questions.add(QuestionData(
                description = "Jogo da Memória",
                explanation = "Quem tirou a carta fala uma palavra qualquer. O próximo tem que repetir a palavra anterior e adicionar uma. E assim por diante. Exemplo: Quem tirou a carta fala “jamanta”. O próximo fala “jamanta cabrito”. O próximo diz “jamanta cabrito mesa”, e assim por diante. O que errar ou demorar, bebe",
                cards = arrayListOf(R.drawable.card_5c, R.drawable.card_5h, R.drawable.card_5s, R.drawable.card_5d)
        ))
        questions.add(QuestionData(
                description = "Jogo do Vrum",
                explanation = "Este jogo consiste em encenar-se movimentos de um carro através da pronuncia de três fonemas: (Vrum (acelerando), Irhh (freiando) Ploft (buraco). Cada jogador deve dar continuidade ao movimento anterior. Existem 3 movimentos possíveis que podem ser pronunciados: \"Vrum\": Segue para o próximo jogador no sentido atual, \"Irhh\": Inverte o sentido, \"Ploft\": Pula um jogador. Por exemplo, o jogo começa no sentido horário, o primeiro jogador fala um dos três fonemas, por exemplo Vrum, assim o próximo jogador no sentido horário deve continuar, este diz por exemplo Ploft, aí pula-se um jogador no sentido horário e o outro jogador deve continuar, se este falar Ploft, aí inverte-se o jogo para o sentido anti-horário e o jogador à direita do mesmo deve continuar pronunciando um dos três fonemas. Quem se perder ou errar bebe. Podem ocorrer casos de mais de uma pessoa beber.",
                cards = arrayListOf(R.drawable.card_6c, R.drawable.card_6h, R.drawable.card_6s, R.drawable.card_6d)
        ))
        questions.add(QuestionData(
                description = "Jogo do “Pi”",
                explanation = "O jogador que tirou a carta fala o número 1. O próximo jogador fala o número seguinte (2) e assim por diante. A pegadinha é que todo múltiplo de três deve ser substituído pela palavra “pi”. Então fica assim: Quem tirou o três do deque fala “um”. O jogador à sua esquerda fala “dois”. O da esquerda fala “pi”. O próximo fala “quatro”. O outro “cinco”. O outro “pi”, e assim sucessivamente. Quem errar, ou demorar muito, bebe. Pode ser feito com o número 4 no lugar",
                cards = arrayListOf(R.drawable.card_7c, R.drawable.card_7h, R.drawable.card_7s, R.drawable.card_7d)
        ))
        questions.add(QuestionData(
                description = "Regra Geral",
                explanation = "Quem tira essa carta determina uma regra para todos obedecerem. Pode ser algo do tipo “está proibido falar a palavra ‘beber’ e seus derivados”, ou “antes de beber uma dose, a pessoa tem que rebolar”. Quem quebrar a regra, deve beber (às vezes, de novo). A Regra Geral pode ser substituída por outra Regra Geral, caso contrário, dura o jogo todo",
                cards = arrayListOf(R.drawable.card_8c, R.drawable.card_8h, R.drawable.card_8s, R.drawable.card_8d)
        ))
        questions.add(QuestionData(
                description = "Jogo do C ou S",
                explanation = "O jogador que tirou a carta começa falando uma palavra, o próximo à direita deve falar uma palavra relacionada ao anterior e assim por diante. Não pode-se falar palavras que comecem com C ou S. Quem falar uma palavra não relacionada ou começando com C ou S bebe uma dose. Ex.: Telhado, Parede, Janela, Vidro, \"Copo\".",
                cards = arrayListOf(R.drawable.card_9c, R.drawable.card_9h, R.drawable.card_9s, R.drawable.card_9d)
        ))
        questions.add(QuestionData(
                description = "Cafofo",
                explanation = "Uma rodada de cafofo. (Uma pessoa escolhida aleatoriamente inventa um tema acerca do qual se possa fazer uma lista, como por exemplo \"marcas de carros\", ou \"apelidos para o Piuí\". Ao fazer isso, ele diz um nome. O seguinte, outro. E assim por diante, até que alguém não saiba ou diga algum que já foi dito. Caso isso ocorra, a pessoa deve beber uma dose da bebida)",
                cards = arrayListOf(R.drawable.card_10c, R.drawable.card_10h, R.drawable.card_10s, R.drawable.card_10d)
        ))
        questions.add(QuestionData(
                description = "Todas as mulheres da mesa bebem",
                cards = arrayListOf(R.drawable.card_qc, R.drawable.card_qh, R.drawable.card_qs, R.drawable.card_qd)
        ))
        questions.add(QuestionData(
                description = "Todos bebem",
                cards = arrayListOf(R.drawable.card_jc, R.drawable.card_jh, R.drawable.card_js, R.drawable.card_jd)
        ))
        questions.add(QuestionData(
                description = "Todos os homens da mesa bebem",
                cards = arrayListOf(R.drawable.card_kc, R.drawable.card_kh, R.drawable.card_ks, R.drawable.card_kd)
        ))

        return questions
    }
}