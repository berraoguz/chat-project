package com.berraoguz.chatproject.data.repo

import android.net.Uri

interface FirebaseStorageProfileRepo {

    suspend fun uploadPhotoToFirebaseStorageProfile(uri: Uri)

    suspend fun deleteImageFromFireStorageProfile(fileName: String)

}