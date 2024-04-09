import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StationCSV {
    String name;
    String date;

    @Override
    public String toString() {
        return "Название станции: " + name + ". Дата открытия: " + date;
    }
}
