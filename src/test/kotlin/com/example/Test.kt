package com.example

import org.mockito.kotlin.spy
import reactor.core.publisher.Flux
import org.junit.jupiter.api.Test
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class Test {

    @Test
    fun test() {
        val deferredSupplier = spy(java.util.function.Supplier { Flux.empty<String>() })
        Flux.defer(deferredSupplier).blockLast()
        verify(deferredSupplier, times(1)).get()
        println("end of test")
    }
}
