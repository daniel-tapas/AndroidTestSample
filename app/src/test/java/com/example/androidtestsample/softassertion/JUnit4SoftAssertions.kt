package com.example.androidtestsample.softassertion

import com.google.common.truth.Expect
import org.junit.Rule
import org.junit.Test

class JUnit4SoftAssertions {

    @Rule
    @JvmField
    val expect = Expect.create()

    @Test
    fun assert_test() {
        expect.that<Int>(1).isEqualTo(2)
        expect.that<Int>(1).isEqualTo(3)
        expect.that<Int>(1).isEqualTo(4)
    }
}