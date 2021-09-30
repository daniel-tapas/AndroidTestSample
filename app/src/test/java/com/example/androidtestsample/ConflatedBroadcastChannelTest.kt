package com.example.androidtestsample

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.sendBlocking
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import org.junit.jupiter.api.Test
import java.util.*

class ConflatedBroadcastChannelTest {

    @ExperimentalCoroutinesApi
    @ObsoleteCoroutinesApi
    @Test
    fun test() = runBlocking {
        val state = ConflatedBroadcastChannel<Int>()
        val channel = ConflatedBroadcastChannel<Unit>()
        val channel2 = ConflatedBroadcastChannel<Unit>()

        val job = Job()
        val job2 = Job()

        try {
            state.send(1)

            launch(job + Dispatchers.Default) {
                channel.asFlow()
                    .run { distinctUntilChanged() }
                    .flatMapLatest { state.asFlow() }
                    .collect {
                        println("channel = $it ${Date().time}")
                    }
            }

            launch(job2 + Dispatchers.Default) {
                channel2.asFlow()
                    .run { distinctUntilChanged() }
                    .flatMapLatest { state.asFlow() }
                    .collect {
                        println("channel2 = $it ${Date().time}")
                    }
            }

            channel.sendBlocking(Unit)  // 1
//            channel.send(Unit)  // 1

            println("---- ${Date().time}")
            delay(500)

            state.send(2)

            channel2.sendBlocking(Unit)  // 1
//            channel2.send(Unit)  // 1

            println("---- ${Date().time}")
            delay(500)

            state.send(3)

            println("---- ${Date().time}")
            delay(500)

            println("---- ${Date().time}")
            delay(500)

            job.cancel()

        } catch(e: Exception) {

        }
    }
}