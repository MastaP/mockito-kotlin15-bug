package com.example

import org.mockito.kotlin.spy
import reactor.core.publisher.Flux
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class Test {

    @Test
    fun test() {
        val deferredSupplier = spy(java.util.function.Supplier { Flux.empty<String>() })
        Flux.defer(deferredSupplier).blockLast()
        verify(deferredSupplier, times(1)).get()
    }

    @Test
    fun `test spy`() {
        val deferredSupplier = spy(java.util.function.Supplier { Flux.empty<String>() })
        Flux.defer(deferredSupplier).blockLast()
        verify(deferredSupplier, times(1)).get()
    }

    @Test
    fun `test mock`() {
        val mock: java.util.function.Supplier<String> = mock()
        whenever(mock.get()).thenReturn("")
        mock.get()
        verify(mock, times(1)).get()
    }
}
