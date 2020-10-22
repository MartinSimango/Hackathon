package hackathon.backend.kotlin.repository

import hackathon.backend.kotlin.entity.Project
import javax.inject.Inject
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Singleton
class ProjectRepository @Inject constructor(private val entityManager: EntityManager) {

    fun save(description: String, projectCode: String, teamSize: Long): Project {
        val project: Project = Project(clientInput = description,
                projectCode = projectCode,
                teamSize = teamSize);

       return entityManager.merge(project)
    }
}
