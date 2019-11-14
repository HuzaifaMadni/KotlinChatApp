package com.example.myapplication

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.NullPointerException

object FirestoreUtil {

    private val firestoreInstance:FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }

    private val currentUserRef : DocumentReference
        get() = firestoreInstance.document("users/${FirebaseAuth.getInstance().uid ?: throw NullPointerException("UID is null")}")

    fun initCurrentUserNew(onComplete: () -> Unit) {
        currentUserRef.get().addOnSuccessListener { documentSnapshot ->
            if (!documentSnapshot.exists()) {
                val newUser =
                    User(FirebaseAuth.getInstance().currentUser?.displayName ?: "", "", null)
                currentUserRef.set(newUser).addOnSuccessListener {
                    onComplete()
                }
            } else
                onComplete()
        }
    }

    fun updateCurrentUser(name:String = "", bio:String = "", prfilepicpath:String? = null){

        val userFieldMap = mutableMapOf<String, Any>()
        if (name.isNotBlank()) userFieldMap["name"] = name
        if (bio.isNotBlank()) userFieldMap["bio"] = bio
        if (prfilepicpath != null){
            userFieldMap["profilepipath"] = prfilepicpath
        }
        currentUserRef.update(userFieldMap)
    }

    fun getCurrentUser(onComplete: (User) -> Unit){
        currentUserRef.get().addOnSuccessListener {
            onComplete(it.toObject(User::class.java)!!)
        }
    }
}