# movie-store-dsl

The code prodces following dsl.

```kotlin
movieStore {
        movie {
            name = "3 idiots"
            date = "25 Dec 2009"
            actor {
                name = "Aamir Khan"
                age = 44
            }
            actor {
                name = "Sharman Joshi"
                age = 35
            }
        }
        movie {
            name = "4 idiots"
            date = "15 Dec 2009"
            actor {
                name = "Boman Irani"
                age = 55
            }
            actor {
                name = "R Madhavan"
                age = 40
            }
        }
    }
```
