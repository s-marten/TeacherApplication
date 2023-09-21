package ru.marten.teacherapplication.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginRepository {

    suspend fun login(login: String, password: String): String {
        return withContext(Dispatchers.IO) {
            Thread.sleep(3000)
            if (password == "12345") "ok" else "error"
        }
    }
}