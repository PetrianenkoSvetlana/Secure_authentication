package com.example.secureauthentication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.MultiAutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AccountDataFragment: Fragment(R.layout.account_data) {
    private lateinit var navController: NavController
    private lateinit var btnToMenu: Button
    private lateinit var tvName: MultiAutoCompleteTextView
    private lateinit var tvEmail: MultiAutoCompleteTextView
    private lateinit var imgAcc: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view);
        val user = Firebase.auth.currentUser!!

        btnToMenu = view.findViewById(R.id.btn_to_menu)
        tvName = view.findViewById(R.id.tv_name)
        tvEmail = view.findViewById(R.id.tv_email)
        imgAcc = view.findViewById(R.id.img_acc)

        if (user.photoUrl != null)
            Glide.with(this).load(user.photoUrl).into(imgAcc)
        tvName.setText(user.displayName)
        tvEmail.setText(user.email)

        btnToMenu.setOnClickListener {
            navController.popBackStack()
        }
    }
}