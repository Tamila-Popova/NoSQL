import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinesHTML {
    String line_name;
    String numberLine;
    String color;

    @Override
    public String toString() {
        return "Линия: " + line_name + ". Номер линии: " + numberLine;
    }
}
