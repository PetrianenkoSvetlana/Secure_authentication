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
            AuthUI.getInstance()
                .delete(requireContext())
                .addOnCompleteListener {
                        task ->
                    if (task.isSuccessful) {
                        var intent = Intent(activity, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK + Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }
                    else {
                        Toast.makeText(context, "Удалить пользователя не удалось!", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        btnBack.setOnClickListener {
            navController.popBackStack()
        }
    }
}