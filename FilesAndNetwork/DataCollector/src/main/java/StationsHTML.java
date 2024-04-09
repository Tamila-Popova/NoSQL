import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StationsHTML {
    String name;
    String lineNumber;
    String title;
    public String toString(){
        return "Станция: " + name + ". Номер линии: " + lineNumber;
    }
}

