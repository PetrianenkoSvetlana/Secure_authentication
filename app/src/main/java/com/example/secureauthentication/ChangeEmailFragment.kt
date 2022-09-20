package com.example.secureauthentication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ChangeEmailFragment: Fragment(R.layout.change_email) {
    private lateinit var navController: NavController
    private lateinit var saveEmail: Button
    private lateinit var etEmail: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view);
        val user = Firebase.auth.currentUser!!

        saveEmail = view.findViewById(R.id.save_email)
        etEmail = view.findViewById(R.id.et_email)

        etEmail.setText(user.email)

        saveEmail.setOnClickListener {
            val email = etEmail.text.toString()
            if (email != "") {
                user.updateEmail(email).addOnCompleteListener {
                    task ->
                    if (task.isSuccessful) {
                        Toast.makeText(context, "Email успешно изменен", Toast.LENGTH_SHORT).show()
                        navController.popBackStack()
                    }
                    else {
                        Toast.makeText(context, "Упс! Что-то пошло не по плану!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else {
                Toast.makeText(context, "Email не должен быть пустым!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}