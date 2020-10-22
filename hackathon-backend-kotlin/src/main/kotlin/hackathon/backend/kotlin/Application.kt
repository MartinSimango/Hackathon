package hackathon.backend.kotlin

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("hackathon.backend.kotlin")
		.start()
}

