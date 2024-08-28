package one.digitalinnovation.avengers.resource.avenger

import jakarta.persistence.*
import one.digitalinnovation.avengers.domain.avenger.Avenger

@Entity
@Table(name = "avenger")
data class AvengerEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(nullable = false)
    val nick: String,

    @Column(nullable = false)
    val person: String,

    val description: String?,

    val history: String?
) {
    fun toAvenger() = Avenger(id, nick, person, description, history)

    companion object {
        fun from(avenger: Avenger) = AvengerEntity(
            id = avenger.id,
            nick = avenger.nick,
            person = avenger.person,
            description = avenger.description,
            history = avenger.history
        )
    }
}
