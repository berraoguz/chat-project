package com.berraoguz.chatproject.ui.presenter

import android.net.Uri

interface FirebaseStorageRegisterPresenter {

    fun ifImageUploadedSuccess(ifSuccess: Boolean, state: String, uri: Uri?, imageId: String?)

}