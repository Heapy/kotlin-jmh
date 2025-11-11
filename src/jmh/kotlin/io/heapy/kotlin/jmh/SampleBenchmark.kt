package io.heapy.kotlin.jmh

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole

object Fib {
    fun fibClassic(n: Int): Long {
        if (n < 2) {
            return n.toLong()
        }
        return fibClassic(n - 1) + fibClassic(n - 2)
    }

    fun tailRecFib(n: Int): Long {
        return tailRecFib(n, 0, 1).toLong()
    }

    private fun tailRecFib(n: Int, a: Int, b: Int): Int {
        if (n == 0) {
            return a
        }
        if (n == 1) {
            return b
        }
        return tailRecFib(n - 1, b, a + b)
    }
}

@State(Scope.Benchmark)
open class SampleBenchmark {
    @Benchmark
    open fun fibClassic(bh: Blackhole) {
        bh.consume(Fib.fibClassic(30))
    }

    @Benchmark
    open fun fibTailRec(bh: Blackhole) {
        bh.consume(Fib.tailRecFib(30))
    }
}