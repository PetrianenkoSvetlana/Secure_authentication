package com.example.secureauthentication

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth

class ChangeAccountDataFragment: Fragment(R.layout.change_account_data) {
    private lateinit var navController: NavController
    private lateinit var saveAccountData: Button

    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view);
//        auth = Firebase.auth

        saveAccountData = view.findViewById(R.id.save_account_data)

        saveAccountData.setOnClickListener {
            navController.navigate(R.id.action_changeAccountDataFragment_to_menuFragment)
        }
    }
}