package com.berraoguz.chatproject.ui.presenter

interface FirebaseAuthRegisterPresenter {

    fun ifCreateNewUserAccountSuccess(ifSuccess: Boolean, state: String)

    fun ifSendEmailVerificationSuccessRegister(ifSuccess: Boolean, state: String)

}