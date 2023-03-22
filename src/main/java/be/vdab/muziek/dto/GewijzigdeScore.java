package be.vdab.muziek.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record GewijzigdeScore(@Min(0) @Max(10) int score) {
}
