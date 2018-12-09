package pl.sda.testing.calculator;

import org.assertj.core.api.AbstractAssert;

public class CalculatorAssert extends AbstractAssert<CalculatorAssert, Calculator> {
    public CalculatorAssert(Calculator actual) {
        super(actual, CalculatorAssert.class);
    }

    public static CalculatorAssert assertThat(Calculator actual) {
        return new CalculatorAssert(actual);
    }

    public CalculatorAssert hasOperation(String operation) {
        // check that actual TolkienCharacter we want to make assertions on is not null.
        isNotNull();

        // check condition
        if (!actual.getCalculations().contains(operation)) {
            failWithMessage("Expected operation <%s> doesn't exist", operation);
        }

        // return the current assertion for method chaining
        return this;
    }
}
