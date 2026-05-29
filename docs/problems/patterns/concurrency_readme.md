# Concurrency

## When to reach for it
Use concurrency primitives when multiple threads share state or must execute in a specific order.

**Mental trigger:** do two or more threads need to take turns, rendezvous, or hand off a token?

## Core tools in Java

| Tool | Best for |
|------|----------|
| `Semaphore(n)` | blocking hand-off between threads; `acquire()` blocks, `release()` unblocks |
| `ReentrantLock` + `Condition` | multiple wait queues on one lock; timed waits |
| `synchronized` + `wait/notify` | simple monitor; requires while-loop guard against spurious wakeups |
| `CountDownLatch` | one-shot "wait until N events happen" |
| `CyclicBarrier` | rendezvous — all threads pause until the last one arrives |
| `AtomicInteger` / `AtomicBoolean` | lock-free counters and flags; avoid for blocking coordination |

**Prefer `Semaphore` for ordered alternation** — no boilerplate, blocks the waiting thread cleanly,
no spurious wakeup risk.  
**Avoid `volatile` spin-loops** — they consume a full CPU core while waiting.

## IntelliJ or VS Code search
Search for `Tags: Design` inside `problems/concurrency/`.

## Concurrency problems in this repo

| Problem | File | Threads | Key idea |
|---------|------|---------|----------|
| Print FooBar Alternately | `M_FoobarAlternate` | 2 | two semaphores as a ping-pong token; fooSem starts at 1 so foo runs first, barSem starts at 0; each thread releases the other's semaphore after printing |
| Print Zero Even Odd | `M_ZeroEvenOdd` | 3 | three semaphores; zero thread holds the token, prints 0, then routes to oddSem or evenSem based on iteration parity; receiving thread prints its number and returns the token to zeroSem |

## Patterns

### Two-thread ping-pong (FooBar)
```
fooSem(1) barSem(0)

foo:  acquire(fooSem) → print → release(barSem)
bar:  acquire(barSem) → print → release(fooSem)
```

### Zero-routed three-way hand-off (ZeroEvenOdd)
```
zeroSem(1)  oddSem(0)  evenSem(0)

zero:  acquire(zeroSem) → print 0 → release(oddSem or evenSem based on i%2)
odd:   acquire(oddSem)  → print i → release(zeroSem)
even:  acquire(evenSem) → print i → release(zeroSem)
```

## Notes

Both problems use `Semaphore` rather than `synchronized`/`wait`/`notify` because the permit model
maps directly onto "one thread holds the right to run next" with zero risk of spurious wakeups and
no need for a shared monitor object.

See the file headers for a detailed comparison of all Java synchronization alternatives.
