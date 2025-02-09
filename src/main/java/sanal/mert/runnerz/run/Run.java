package sanal.mert.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location
) {
    public Run{
        if(!completedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("Can't complete the run before it has started");
        }
    }
}
