import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "linked_purchaselist")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LinkedPurchaseList {
    @EmbeddedId
    private LinkedPurchaseListKey id;
    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;
}
