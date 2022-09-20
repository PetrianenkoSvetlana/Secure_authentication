package com.example.secureauthentication

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase

class ChangeAccountDataFragment: Fragment(R.layout.change_account_data) {
    private lateinit var navController: NavController
    private lateinit var saveAccountData: Button
    private lateinit var img: ImageView
    private lateinit var etName: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view);
        val user = Firebase.auth.currentUser!!
        var url = user.photoUrl
        var name = user.displayName

        saveAccountData = view.findViewById(R.id.save_account_data)
        img = view.findViewById(R.id.img)
        etName = view.findViewById(R.id.et_name)

        if (url != null)
            Glide.with(this).load(url).into(img)
        etName.setText(name)

        val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) {
            uri: Uri? ->
            img.setImageURI(uri)
            url = uri
        }

        img.setOnClickListener {
            getContent.launch("image/*")
        }

        saveAccountData.setOnClickListener {
            name = etName.text.toString()
            val profileUpdates = userProfileChangeRequest {
                displayName = name
                photoUri = url
            }
            user.updateProfile(profileUpdates).addOnCompleteListener {
                task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Данные успешно изменены", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                }
                else {
                    Toast.makeText(context, "Упс! Что-то пошло не по плану!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}