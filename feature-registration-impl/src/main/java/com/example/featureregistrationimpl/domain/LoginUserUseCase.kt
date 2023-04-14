package com.example.featureregistrationimpl.domain

import com.example.feature_registration_api.domain.interfaces.UserRepository
import com.example.feature_registration_api.domain.model.UserModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginUserUseCase(
    private val userRepository: UserRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) {
    suspend operator fun invoke(
        login: String?,
        password: String?
    ): UserModel {
        return withContext(dispatcher) {
            userRepository.loginUser(login, password)
        }
    }
}
