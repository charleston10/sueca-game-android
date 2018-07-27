package com.charleston.sueca

class QuestionPresenter(private val questionView: QuestionView) {

    private val questions: ArrayList<QuestionData> = arrayListOf()

    init {
        questions.add(QuestionData("Escolhe uma pessoa para beber"))
        questions.add(QuestionData("Escolhe duas pessoas para beber"))
        questions.add(QuestionData("Escolhe três pessoas para beber"))
        questions.add(QuestionData(
                description = "Jogo do “Stop”"
        ))
        questions.add(QuestionData(
                description = "Jogo da Memória"
        ))
        questions.add(QuestionData(
                description = "Jogo do “Pi”"
        ))
        questions.add(QuestionData(
                description = "Regra Geral"
        ))
        questions.add(QuestionData(
                description = "Cafofo"
        ))
        questions.add(QuestionData(
                description = "O jogador à esquerda de quem tirou bebe uma dose"
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