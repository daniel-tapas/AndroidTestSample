package com.example.androidtestsample.mockk

import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test

data class Coffee(val name: String)

class CoffeeMachine(val creator: () -> Coffee)

class MockkTest {

    @Test
    fun every_test() {
        val coffeeMachine = CoffeeMachine(mockk())

        every {
            coffeeMachine.creator.invoke()
        } returns Coffee("Americano")  // <-- Stubbing

        val coffee = coffeeMachine.creator.invoke()

        val expect = Coffee("Americano")
        assertThat(coffee).isEqualTo(expect)
    }

    @Test
    fun verify_test() {
        // given
        val coffeeMachine = CoffeeMachine(mockk())

        every {
            coffeeMachine.creator.invoke()
        } returns Coffee("Americano")  // <-- Stubbing

        // when
        val coffee = coffeeMachine.creator.invoke()

        // then
        verify { coffeeMachine.creator.invoke() }
        verify(exactly = 1) { coffeeMachine.creator.invoke() }
    }

    @Test
    fun spy_test() {
        // given
        val spyList = spyk(listOf("test1", "test2"))
        every { spyList.size } returns 3

        // when
        val actual = spyList.size

        // then
        assertThat(actual).isEqualTo(3)
        verify { spyList.size }
    }

    @Test
    fun relaxed_verify_test() {
        // given
        val spyList: List<String> = mockk(relaxed = true)

        // when
        spyList.size

        // then
        verify { spyList.size }
    }
}