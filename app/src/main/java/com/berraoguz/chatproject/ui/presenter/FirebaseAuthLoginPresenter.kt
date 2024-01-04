package com.berraoguz.chatproject.ui.presenter

interface FirebaseAuthLoginPresenter {

    fun ifSingInWithEmailPasswordComplete(ifComplete: Boolean, state: String)

    fun ifEmailVerificationLogin(ifVerified: Boolean)

    fun ifSendEmailVerificationSentSuccessLogin(ifSuccess: Boolean, state: String)

}