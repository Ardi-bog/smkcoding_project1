package com.example.boss.smkcoding1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profil.*

class profil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        ambilData()
    }

    private fun ambilData(){
        val bundle = intent.extras

        val nama = bundle.getString("nama")
        val gender = bundle.getString("gender")
        val email = bundle.getString("email")
        val umur = bundle.getString("umur")
        val telp = bundle.getString("telp")
        val alamat = bundle.getString("alamat")

        txtName.text = nama
        txtGender.text = gender
        txtEmail.text = email
        txtUmur.text = umur
        txtTelp.text = telp
        txtAddress.text = alamat
    }
}
