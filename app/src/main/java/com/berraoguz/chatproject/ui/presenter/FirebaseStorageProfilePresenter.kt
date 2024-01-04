package com.berraoguz.chatproject.ui.presenter

import android.net.Uri

interface FirebaseStorageProfilePresenter {

    fun isUploadPhotoSuccessful(isSuccess: Boolean, statue: String, uri: Uri?, imageId: String?)

}