package be.vdab.muziek.dto;

import jakarta.validation.constraints.PositiveOrZero;

public record GewijzigdeScore(@PositiveOrZero int score) {
}
