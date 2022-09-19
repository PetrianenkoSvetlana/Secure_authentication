package com.example.secureauthentication

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth

class ExitFragment: Fragment(R.layout.exit) {
    private lateinit var navController: NavController
    private lateinit var btnExitFromAcc: Button
    private lateinit var btnBackToMenu: Button

    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view);
//        auth = Firebase.auth

        btnExitFromAcc = view.findViewById(R.id.btn_exit_from_acc)
        btnBackToMenu = view.findViewById(R.id.btn_back_to_menu)

        btnExitFromAcc.setOnClickListener {
            navController.navigate(R.id.action_exitFragment_to_signInFragment)
        }

        btnBackToMenu.setOnClickListener {
            navController.navigate(R.id.action_exitFragment_to_menuFragment)
        }
    }
}