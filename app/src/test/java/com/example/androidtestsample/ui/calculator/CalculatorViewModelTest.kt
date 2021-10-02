package com.example.androidtestsample.ui.calculator

import com.example.androidtestsample.domain.Operator
import com.example.androidtestsample.utils.InstantExecutorExtension
import com.example.androidtestsample.utils.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
internal class CalculatorViewModelTest {

    private lateinit var viewModel: CalculatorViewModel

    @BeforeEach
    internal fun setUp() {
        viewModel = CalculatorViewModel()
    }

    @Test
    fun `숫자가 입력되면 수식에 추가되고 변경된 수식을 보여줘야 한다`() {
        viewModel.addNumber(1)

        assertThat(viewModel.input.getOrAwaitValue()).isEqualTo("1")
    }

    @Test
    fun `연산자가 입력되면 수식에 추가되고 변경된 수식을 보여줘야 한다`() {
        viewModel.addNumber(1)
        viewModel.addOperator(Operator.PLUS)

        assertThat(viewModel.input.getOrAwaitValue()).isEqualTo("1 +")
    }

    @Test
    fun `지우기가 실행되면 수식의 마지막이 지워지고 변경된 수식을 보여줘야 한다`() {
        // given
        viewModel.addNumber(1)
        viewModel.addOperator(Operator.PLUS)

        // when
        viewModel.removeLastInput()

        // then
        assertThat(viewModel.input.getOrAwaitValue()).isEqualTo("1")
    }

    @Test
    fun `계산이 실행되면 계산기에 의해 계산되고 결과를 화면에 보여줘야 한다`() {
        // given
        viewModel.addNumber(1)
        viewModel.addOperator(Operator.PLUS)
        viewModel.addNumber(2)

        // when
        viewModel.calculate()

        // then
        assertThat(viewModel.input.getOrAwaitValue()).isEqualTo("3")
    }
}