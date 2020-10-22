package hackathon.backend.kotlin.service

import hackathon.Repository.EmployeeRepository
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional

@Singleton
open class EmployeeManager @Inject constructor(private val employeeRepository: EmployeeRepository) {

    @Transactional
    open fun save(name: String?, aboutMe: String?, tags: List<String>?){
        employeeRepository.save(name, aboutMe , tags)
    }

    @Transactional
    open fun doesUserExist(name: String): Boolean {
        return employeeRepository.doesUserExist(name) == null
    }
}
