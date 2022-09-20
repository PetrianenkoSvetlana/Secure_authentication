package com.example.secureauthentication

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class DeleteAccountFragment: Fragment(R.layout.delete_account) {
    private lateinit var navController: NavController
    private lateinit var btnDelete: Button
    private lateinit var btnBack: Button

    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view);
        auth = Firebase.auth

        btnDelete = view.findViewById(R.id.btn_delete)
        btnBack = view.findViewById(R.id.btn_back)

        btnDelete.setOnClickListener {
            navController.navigate(R.id.action_deleteAccountFragment_to_signInFragment)
        }

        btnBack.setOnClickListener {
            navController.navigate(R.id.action_deleteAccountFragment_to_menuFragment)
        }
    }
}