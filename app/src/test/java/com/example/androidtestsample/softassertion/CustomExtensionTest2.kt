package com.example.androidtestsample.softassertion

import com.google.common.truth.Expect
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class CustomExtensionTest2 {

    @JvmField
    @RegisterExtension
    val extension = ExpectExtension()

    @Test
    fun test2() {
        extension.expect.that<Int>(1).isEqualTo(2)
        extension.expect.that<Int>(1).isEqualTo(3)
        extension.expect.that<Int>(1).isEqualTo(4)
    }

    @Test
    fun test3(expect: Expect) {
        expect.that<Int>(1).isEqualTo(2)
        expect.that<Int>(1).isEqualTo(3)
        expect.that<Int>(1).isEqualTo(4)
    }
}