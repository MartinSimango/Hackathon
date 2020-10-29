package hackathon.backend.kotlin.service

class Element(var index: Int, var value: Int) : Comparable<Element> {
    override operator fun compareTo(e: Element): Int {
        return value - e.value
    }

}