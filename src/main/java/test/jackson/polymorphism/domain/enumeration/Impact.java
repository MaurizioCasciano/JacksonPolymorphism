package test.jackson.polymorphism.domain.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Impact {
    UNDEFINED(0), LOW(1), LOW_MEDIUM(2), MEDIUM(3), MEDIUM_HIGH(4), HIGH(5);

    private final int value;
}
