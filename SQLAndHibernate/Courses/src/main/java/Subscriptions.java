import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Subscriptions")
@Getter
@Setter
public class Subscriptions {
    @EmbeddedId
    private SubscriptionsKey id;

    @Column(name = "subscription_date")
    private Date subscriptionDate;
}
