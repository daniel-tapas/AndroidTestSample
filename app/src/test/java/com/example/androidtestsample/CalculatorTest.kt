package com.example.androidtestsample

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.assertThrows

internal class CalculatorTest {

    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun `2 와 3 을 더하면 5가 된다`() {
        val actual = calculator.calculate("2 + 3")
        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun `연산자로 끝나면 에러를 던진다`() {
        assertThat(
            assertThrows<Throwable> { calculator.calculate("2 + 3 /") }
        ).hasCauseThat()
    }

    @Test
    fun `연산자로 시작하면 에러를 던진다`() {
        assertThat(
            assertThrows<Throwable> { calculator.calculate("/ 2 + 3") }
        ).hasCauseThat()
    }

    @Test
    fun `연산자가 중첩되면 에러를 던진다`() {
        assertThat(
            assertThrows<Throwable> { calculator.calculate("2 + * 3") }
        ).hasCauseThat()
    }

    @Test
    fun `2 + 3 * 4 나누기 2 은 10 이다`() {
        val actual = calculator.calculate("2 + 3 * 4 / 2")
        assertThat(actual).isEqualTo(10)
    }

    @Test
    fun `공백이 연달아 있어도 2 와 3 을 더하면 5가 된다`() {
        val actual = calculator.calculate("2   +    3")
        assertThat(actual).isEqualTo(5)
    }
}