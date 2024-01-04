package com.berraoguz.chatproject.data.repo

import com.berraoguz.chatproject.data.model.User

interface FirebaseFireStoreSaveDataRepo {

    suspend fun insertUserToFireStoreDB(username: String, email: String, uri: String?, imageId: String?)

    suspend fun updateUserInFireStoreDB(user: User)

}