package airport;

import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static long findCountAircraftWithModelAirbus(Airport airport, String model) {
        long count = airport.getAllAircrafts().stream()
                .filter(x -> x.getModel().contains(model))
                .count();
        return count;
    }

    public static Map<String, Integer> findMapCountParkedAircraftByTerminalName(Airport airport) {
        Map<String, Integer> collect = airport.getTerminals().stream()
                .collect(Collectors.toMap(Terminal::getName, terminal -> terminal.getParkedAircrafts().size()));
        return collect;
    }

    public static List<Flight> findFlightsLeavingInTheNextHours(Airport airport, int hours) {
        List<Flight> flights = airport.getTerminals().stream()
                .flatMap(t -> t.getFlights().stream())
                .filter(f -> f.getType().equals(Flight.Type.DEPARTURE))
                .filter(f -> f.getDate().isAfter(Instant.now()))
                .filter(f -> f.getDate().isBefore(Instant.now().plus(hours, ChronoUnit.HOURS)))
                .collect(Collectors.toList());
        return flights;
    }

    public static Optional<Flight> findFirstFlightArriveToTerminal(Airport airport, String terminalName) {
        Optional<Flight> flights = airport.getTerminals().stream()
                .filter(t -> t.getName().equals(terminalName))
                .flatMap(t -> t.getFlights().stream())
                .filter(f -> f.getType().equals(Flight.Type.ARRIVAL))
                .min(Comparator.comparing(f -> f.getDate()));
        return flights;
    }

}