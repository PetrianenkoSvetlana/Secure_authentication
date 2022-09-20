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

class MenuFragment: Fragment(R.layout.menu){
    private lateinit var navController: NavController
    private lateinit var btnAccountData: Button
    private lateinit var btnChngAccountData: Button
    private lateinit var btnChngEmail: Button
    private lateinit var btnProtectedArea: Button
    private lateinit var btnExit: Button
    private lateinit var btnDeleteAccount: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view);

        btnAccountData = view.findViewById(R.id.btn_account_data)
        btnChngAccountData = view.findViewById(R.id.btn_chng_account_data)
        btnChngEmail = view.findViewById(R.id.btn_chng_email)
        btnProtectedArea = view.findViewById(R.id.btn_protected_area)
        btnExit = view.findViewById(R.id.btn_exit)
        btnDeleteAccount = view.findViewById(R.id.btn_delete_account)

        btnAccountData.setOnClickListener {
            navController.navigate(R.id.action_menuFragment_to_accountDataFragment2)
        }

        btnChngAccountData.setOnClickListener {
            navController.navigate(R.id.action_menuFragment_to_changeAccountDataFragment)
        }

        btnChngEmail.setOnClickListener {
            navController.navigate(R.id.action_menuFragment_to_changeEmailFragment)
        }

        btnProtectedArea.setOnClickListener {
            navController.navigate(R.id.action_menuFragment_to_protectedAreaFragment)
        }

        btnExit.setOnClickListener {
            navController.navigate(R.id.action_menuFragment_to_exitFragment)
        }

        btnDeleteAccount.setOnClickListener {
            navController.navigate(R.id.action_menuFragment_to_deleteAccountFragment)
        }
    }
}