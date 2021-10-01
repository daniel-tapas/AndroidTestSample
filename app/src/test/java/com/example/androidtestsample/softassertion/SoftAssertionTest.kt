package com.example.androidtestsample.softassertion

import com.google.common.truth.Expect
import com.google.common.truth.Truth.assertThat
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.runner.Description
import org.junit.runners.model.Statement

class SoftAssertionTest {

    @Test
    fun assert_test() {
        assertEquals(2, 1)
        assertEquals(3, 1)
        assertEquals(4, 1)
    }

    @Test
    fun soft_assertion_assert_test() {
        val softAssertion = SoftAssertions()

        softAssertion.assertThat(1).isEqualTo(2)
        softAssertion.assertThat(1).isEqualTo(3)
        softAssertion.assertThat(1).isEqualTo(4)

        softAssertion.assertAll()
    }


    @Test
    fun assertThat_test() {
        assertThat<Int>(1).isEqualTo(2)
        assertThat<Int>(1).isEqualTo(3)
        assertThat<Int>(1).isEqualTo(4)
    }

/*
    @Rule
    @JvmField
    val expect = Expect.create()

    @Test
    fun expect_test2() {
        expect.that<Int>(1).isEqualTo(2)
        expect.that<Int>(1).isEqualTo(3)
        expect.that<Int>(1).isEqualTo(4)
    }
*/

    @Test
    fun expect_test() {
        expect {
            that<Int>(1).isEqualTo(2)
            that<Int>(1).isEqualTo(3)
            that<Int>(1).isEqualTo(4)
        }
    }
}

inline fun expect(crossinline f: Expect.() -> Unit) {
    val expect = Expect.create()

    val statement = object : Statement() {
        override fun evaluate() {
            f(expect)
        }
    }

    expect.apply(statement, Description.EMPTY).evaluate()
}