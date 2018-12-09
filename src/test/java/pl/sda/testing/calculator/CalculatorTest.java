package pl.sda.testing.calculator;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void whenAdding1And1_shouldReturn2() {
        int result = calculator.add(1, 1);

        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    public void whenAdding1And1_shouldReturn3() {
        //when
        int result = calculator.add(1, 1);

        //then
        assertEquals(3, result);
    }

    @Test
    public void whenSomething_shouldSomething() throws Exception {
        calculator.add(2, 2);

        CalculatorAssert.assertThat(calculator).hasOperation("2 + 2 = 4");
    }

    @Test(expected = ArithmeticException.class)
    public void whenYis0_shouldThrowArithmeticException() throws Exception {
        //given

        //when
        calculator.divide(1, 1);

        //then
    }

    @Test
    public void whenAddingLimited11And12_shouldThrowNumberLimitExceeded() throws Exception {
        //given
        expectedException.expect(Calculator.NumberLimitExceeded.class);
        expectedException.expectMessage("Maksymalna dozwolona liczba to: 10");

        //when
        calculator.addLimited(11, 12);

        //then
    }


}
