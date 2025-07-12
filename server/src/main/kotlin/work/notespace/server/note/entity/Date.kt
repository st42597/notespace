package work.notespace.server.note.entity

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class Date {
    @CreatedDate
    @Column(name = "CREATED_AT", updatable = false, nullable = false)
    val createdAt: LocalDateTime? = null

    @LastModifiedDate
    @Column(name = "UPDATED_AT", nullable = false)
    var updatedAt: LocalDateTime? = null
}