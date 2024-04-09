import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.accessibility.AccessibleValue;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StationJSON {
    String station_name;
    String depth;

    public String toString (){
        return "Название станции: " + station_name + ". Глубина: " + depth;
    }
}
