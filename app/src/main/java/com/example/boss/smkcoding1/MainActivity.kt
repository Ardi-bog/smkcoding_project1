package com.example.boss.smkcoding1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.boss.smkcoding1.R.id.message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var nama : String = ""
    private var email : String = ""
    private var telp : String = ""
    private var alamat : String = ""
    private var gender : String = ""
    private var umur : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            setDataSpinnerGender()
            btnSave.setOnClickListener{ validasiInput() }
    }

    private fun setDataSpinnerGender(){
        val adapter = ArrayAdapter.createFromResource(this,R.array.jenis_kelamin,R.layout.support_simple_spinner_dropdown_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = adapter
    }
    private fun validasiInput(){
        nama = edtName.text.toString()
        email = edtEmail.text.toString()
        telp = edtTelp.text.toString()
        alamat = edtAdress.text.toString()
        gender = spinnerGender.selectedItem.toString()
        umur = edtUmur.text.toString()

        when{
            nama.isEmpty() -> edtName.error = "Nama Tidak Boleh Kosong"
            gender.equals("Pilih Jenis Kelamin", ignoreCase = true) ->
                tampilToast("Jenis Kelamin Harus Dipilih")
            email.isEmpty() -> edtEmail.error = "Email Tidak Boleh Kosong"
            alamat.isEmpty() -> edtAdress.error = "Alamat Tidak Boleh Kosong"

            else->{
                goToProfilActivity()
            }
        }
    }

    private fun tampilToast(message : String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun goToProfilActivity(){
        val intent = Intent(this, profil::class.java)

        val bundle = Bundle()
        bundle.putString("nama", nama)
        bundle.putString("gender", gender)
        bundle.putString("umur", umur)
        bundle.putString("email", email)
        bundle.putString("telp", telp)
        bundle.putString("alamat", alamat)

        intent.putExtras(bundle)
        startActivity(intent)
    }
}
