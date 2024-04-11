import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
@Entity
@Table(name = "purchaselist")
public class Purchaselist {
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "course_name")
    private String courseName;
    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;
}
