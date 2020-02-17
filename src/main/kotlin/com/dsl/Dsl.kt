package com.dsl

class MovieStore(private val movies: MutableList<Movie> = mutableListOf()) {

    fun movie(action: Movie.MovieBuilder.() -> Unit) {
        val movieBuilder = Movie.MovieBuilder()
        movieBuilder.action()
        movies.add(movieBuilder.build())
    }

    override fun toString(): String {
        return "MovieStore(movies=$movies)"
    }
}

data class Movie(
    private val name: String,
    private val date: String,
    private val actors: List<Actor>
) {
    class MovieBuilder(
        var name: String = "",
        var date: String = "",
        private var actorsBuilder: MutableList<Actor.ActorBuilder> = mutableListOf()
    ) {
        fun build() = Movie(name, date, actorsBuilder.map(Actor.ActorBuilder::build))

        fun actor(action: Actor.ActorBuilder.() -> Unit) {
            val actor = Actor.ActorBuilder()
            actor.action()
            actorsBuilder.add(actor)
        }
    }
}

data class Actor(val name: String, val age: Int) {
    data class ActorBuilder(var name: String = "", var age: Int = 0) {
        fun build() = Actor(name, age)
    }
}

fun movieStore(action: MovieStore.() -> Unit): MovieStore {
    val movieStore = MovieStore()
    movieStore.action()
    return movieStore
}

fun main() {
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
    }.also(::println)
}
