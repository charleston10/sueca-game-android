package com.charleston.sueca

class QuestionPresenter(private val questionView: QuestionView) {

    private val questions: ArrayList<QuestionData> = arrayListOf()

    init {
        questions.add(QuestionData("Escolhe uma pessoa para beber"))
        questions.add(QuestionData("Escolhe duas pessoas para beber"))
        questions.add(QuestionData("Escolhe três pessoas para beber"))
        questions.add(QuestionData(
                description = "Jogo do “Stop”",
                explanation = "Quem tirou a carta do deque escolhe uma categoria e uma letra do alfabeto e dá um exemplo. O próximo jogador tem que seguir o padrão. O primeiro que errar ou não souber, bebe. Por exemplo: O jogador escolhe “carros com a letra A”, e dá como exemplo “Audi”. O próximo diz “Astra”. O outro “Alfa Romeu”, e assim por diante. "
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