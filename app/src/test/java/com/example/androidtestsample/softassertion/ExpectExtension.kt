package com.example.androidtestsample.softassertion

import com.google.common.truth.Expect
import org.junit.jupiter.api.extension.*
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.lang.reflect.Method
import java.lang.reflect.Type

class ExpectExtension : BeforeEachCallback, AfterEachCallback, InvocationInterceptor,
                        ParameterResolver {

    private var _expect: Expect? = null

    val expect: Expect
        get() = _expect!!

    override fun beforeEach(context: ExtensionContext) {
        _expect = Expect.create()
    }

    override fun interceptTestMethod(
        invocation: InvocationInterceptor.Invocation<Void>,
        invocationContext: ReflectiveInvocationContext<Method>,
        extensionContext: ExtensionContext
    ) {
        _expect?.apply(
            object : Statement() {
                override fun evaluate() {
                    invocation.proceed()
                }
            },
            Description.EMPTY,
        )?.evaluate()
    }

    override fun afterEach(context: ExtensionContext) {
        _expect = null
    }

    override fun supportsParameter(
        parameterContext: ParameterContext,
        extensionContext: ExtensionContext
    ): Boolean {
        val paramType = parameterContext.parameter.type
        return paramType is Type && paramType == Expect::class.java
    }

    override fun resolveParameter(
        parameterContext: ParameterContext,
        extensionContext: ExtensionContext
    ): Any {
        return expect
    }
}