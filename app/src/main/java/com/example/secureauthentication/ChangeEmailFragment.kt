package com.example.secureauthentication

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth

class ChangeEmailFragment: Fragment(R.layout.change_email) {
    private lateinit var navController: NavController
    private lateinit var saveEmail: Button

    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view);
//        auth = Firebase.auth

        saveEmail = view.findViewById(R.id.save_email)

        saveEmail.setOnClickListener {
            navController.navigate(R.id.action_changeEmailFragment_to_menuFragment)
        }
    }
}