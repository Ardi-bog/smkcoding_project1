package com.example.boss.smkcoding1

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profil.*

class profil : AppCompatActivity() {

    companion object {
        val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        ambilData()

        btnEditName.setOnClickListener{ navigasiKeEditProfil() }

        btnCall.setOnClickListener{dialPhoneNumber(txtTelp.text.toString())}

        btnAbout.setOnClickListener{ halamanAbout()}
    }

    private fun ambilData(){
        val bundle = intent.extras

        val nama = bundle?.getString("nama")
        val gender = bundle?.getString("gender")
        val email = bundle?.getString("email")
        val umur = bundle?.getString("umur")
        val telp = bundle?.getString("telp")
        val alamat = bundle?.getString("alamat")

        txtName.text = nama
        txtGender.text = gender
        txtEmail.text = email
        txtUmur.text = umur
        txtTelp.text = telp
        txtAddress.text = alamat
    }

    private fun navigasiKeEditProfil(){
        val intent = Intent(this,edit::class.java)

        val namaUser = txtName.text.toString()
        intent.putExtra("nama", namaUser)

        startActivityForResult(intent, REQUEST_CODE)
    }
    private fun halamanAbout(){
        val intent = Intent(this,about::class.java)

        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                val result = data?.getStringExtra("nama")
                txtName.text = result
            }else{
                Toast.makeText(this,"Edit failed",Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }
}
