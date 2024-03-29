package com.berraoguz.chatproject.data.network

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.berraoguz.chatproject.constants.Constants
import com.berraoguz.chatproject.data.model.User
import com.berraoguz.chatproject.ui.presenter.FirebaseFireStoreRegisterPresenter
import com.berraoguz.chatproject.ui.presenter.FirebaseFireStoreSaveDataProfilePresenter
import javax.inject.Inject

class FirebaseFireStoreSaveData @Inject constructor(
    private val firebaseCollection: FirebaseFirestore
) {

    var firebaseFireStoreRegisterPresenter: FirebaseFireStoreRegisterPresenter? = null

    var firebaseFireStoreSaveDataProfilePresenter: FirebaseFireStoreSaveDataProfilePresenter? = null

    fun insertUserToFireStoreDB(username: String, email: String, uri: String?, imageId: String?) {
        //firebaseCollection = Firebase.firestore
        val uid = FirebaseAuth.getInstance().uid ?: return
        val myRef = firebaseCollection.collection("users")
        //val user = User(username, email, uri)
        val user = User(uid, username, email, uri, imageId)
        myRef.document(uid).set(user)
            .addOnSuccessListener {
                firebaseFireStoreRegisterPresenter!!.ifUserInsertedSuccess(
                    true,
                    Constants.SUCCESS_MESSAGE
                )
            }
            .addOnFailureListener {
                firebaseFireStoreRegisterPresenter!!.ifUserInsertedSuccess(
                    false,
                    it.message!!
                )
            }
    }

    fun updateUserInFireStoreDB(user: User) {
        val myRef = firebaseCollection.collection("users")

        myRef.document(user.id).update(
            "username", user.username,
            "profileImgUrl", user.profileImgUrl,
            "profileImageId", user.profileImageId
        ).addOnSuccessListener {
                firebaseFireStoreSaveDataProfilePresenter?.isUpdateUserFromFireStoreSuccess(
                    true,
                    Constants.SUCCESS_MESSAGE
                )
            }
            .addOnFailureListener {
                firebaseFireStoreSaveDataProfilePresenter?.isUpdateUserFromFireStoreSuccess(
                    false,
                    it.message!!
                )
            }
    }

}