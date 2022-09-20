package com.example.secureauthentication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.time.Instant
import java.util.Observer

class ExitFragment: Fragment(R.layout.exit) {
    private lateinit var navController: NavController
    private lateinit var btnExitFromAcc: Button
    private lateinit var btnBackToMenu: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view);

        btnExitFromAcc = view.findViewById(R.id.btn_exit_from_acc)
        btnBackToMenu = view.findViewById(R.id.btn_back_to_menu)

        btnExitFromAcc.setOnClickListener {
            AuthUI.getInstance()
                .signOut(requireContext())
                .addOnCompleteListener {
                    task ->
                    if (task.isSuccessful) {
                        var intent = Intent(activity, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK + Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }
                    else {
                        Toast.makeText(context, "Выйти из аккаунта не удалось! Повторите попытку.", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        btnBackToMenu.setOnClickListener {
            navController.popBackStack()
        }
    }
}