package hackathon.backend.kotlin.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn

@Controller("/")
class TestController {
    @ExecuteOn(TaskExecutors.IO)
    @Get(value = "/hello")
    fun sayHello(): String {
        return "Hello World!"
    }
}
