class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val map = mutableMapOf<Int, Course>()

        for (index in 0 until numCourses) {
            map[index] = Course(index)
        }

        prerequisites.forEach {
            val link = map[it[0]] ?: throw IllegalArgumentException()
            val essential = map[it[1]] ?: throw IllegalArgumentException()

            link.addEssential(essential)
            essential.addLink(link)
        }

        return registerable(values = map.values.toList())
    }

    fun registerable(values: List<Course>): Boolean {
        var minimumRequirements = false
        val nextValues = mutableListOf<Course>()
        
        for (value in values) {
            when {
                value.registerable -> {
                    minimumRequirements = true
                    value.register()
                }
                
                else -> nextValues.add(value)
            }
        }
        
        return when {
            nextValues.isEmpty() -> true
            minimumRequirements -> registerable(values = nextValues)
            else -> false
        }
    }

    class Course(val data: Int) {
        private val essentials: MutableList<Course> = mutableListOf()
        private val links: MutableList<Course> = mutableListOf()
        val registerable
            get() = essentials.isEmpty()

        fun addEssential(course: Course) {
            essentials.add(course)
        }

        fun addLink(course: Course) {
            links.add(course)
        }

        fun register() {
            links.forEach {
                it.essentials.remove(element = this)
            }
        }
    }
}