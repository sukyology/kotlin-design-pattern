package org.example.create

fun main() {
    val mail = MailBuilder("Hello World")
        .recepients(listOf("hello@world.com"))
        .message("Hello")
        .build()

    println(mail.to)
    println(mail.cc)
    println(mail.message)

    //named parameter와 default parameter 로 builder 패턴 대체 가능
    KotlinMail(
        title = "",
        message = "",
    )
}

class MailBuilder(
    //필수값은 builder 생성자 함수안에 선언해야함
    private var title: String
) {
    // default 값이 있는 필드
    private var recepients: List<String> = listOf()
    private var cc: List<String> = listOf()
    private var message: String = ""
    private var important: Boolean = false

    class Mail internal constructor(
        val to: List<String>,
        val cc: List<String>?,
        val title: String?,
        val message: String?,
        val important: Boolean
    )

    fun build(): Mail {
        if (recepients.isEmpty()) {
            throw RuntimeException("To property is empty")
        }

        return Mail(recepients, cc, title, message, important)
    }

    fun message(message: String = ""): MailBuilder {
        this.message = message
        return this
    }

    fun recepients(recepients: List<String>): MailBuilder {
        this.recepients = recepients
        return this
    }
}

class KotlinMail(
    private var title: String,
    private var recepients: List<String> = listOf(),
    private var cc: List<String> = listOf(),
    private var message: String = "",
    private var important: Boolean = false
)