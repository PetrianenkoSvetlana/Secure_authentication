package com.example.secureauthentication

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class AccountDataFragment: Fragment(R.layout.account_data) {
    private lateinit var navController: NavController
    private lateinit var btnToMenu: Button

    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view);
//        auth = Firebase.auth

        btnToMenu = view.findViewById(R.id.btn_to_menu)

        btnToMenu.setOnClickListener {
            navController.navigate(R.id.action_accountDataFragment2_to_menuFragment)
        }
    }
}