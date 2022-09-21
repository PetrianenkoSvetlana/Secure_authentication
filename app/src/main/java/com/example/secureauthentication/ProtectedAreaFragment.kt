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

class ProtectedAreaFragment: Fragment(R.layout.protected_area) {
    private lateinit var navController: NavController
    private lateinit var btnToMenu: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view);

        btnToMenu = view.findViewById(R.id.btn_to_menu)

        btnToMenu.setOnClickListener {
            navController.popBackStack()
        }
    }
}