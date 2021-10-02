package com.example.androidtestsample.ui.calculator

import com.example.androidtestsample.domain.Operator
import com.google.common.truth.Truth.assertThat
import io.mockk.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class CalculatorPresenterTest {

    private lateinit var view: CalculatorContract.View
    private lateinit var presenter: CalculatorContract.Presenter

    @BeforeEach
    internal fun setUp() {
        view = mockk(relaxed = true)
        presenter = CalculatorPresenter(view)
    }

    @Test
    fun `숫자가 입력되면 수식에 추가되고 변경된 수식을 보여줘야 한다`() {
        presenter.addNumber(1)

        verify { view.updateInput("1") }
    }

    @Test
    fun `연산자가 입력되면 수식에 추가되고 변경된 수식을 보여줘야 한다`() {
        presenter.addNumber(1)

        presenter.addOperator(Operator.PLUS)

        verify { view.updateInput("1 +") }
    }

    @Test
    fun `지우기가 실행되면 수식의 마지막이 지워지고 변경된 수식을 보여줘야 한다`() {
        // given
        presenter.addNumber(1)
        presenter.addOperator(Operator.PLUS)

        val slot = CapturingSlot<String>()
        every { view.updateInput(capture(slot)) } just Runs

        // when
        presenter.removeLastInput()

        // then
        assertThat(slot.captured).isEqualTo("1")
    }

    @Test
    fun `계산이 실행되면 계산기에 의해 계산되고 결과를 화면에 보여줘야 한다`() {
        // given
        presenter.addNumber(1)
        presenter.addOperator(Operator.PLUS)
        presenter.addNumber(2)

        val slot = CapturingSlot<String>()
        every { view.updateInput(capture(slot)) } just Runs

        // when
        presenter.calculate()

        // then
        assertThat(slot.captured).isEqualTo("3")
    }
}