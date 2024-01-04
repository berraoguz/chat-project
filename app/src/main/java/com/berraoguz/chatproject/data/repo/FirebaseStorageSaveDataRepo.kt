package com.berraoguz.chatproject.data.repo

import android.net.Uri

interface FirebaseStorageSaveDataRepo {

    suspend fun uploadPhotoToFirebaseStorage(uri: Uri)
    
}