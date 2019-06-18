package com.example.idol

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.idol.data.Idol
import com.example.idol.data.IdolViewModel

class MainActivity : AppCompatActivity() {

    private val newIdolActivityRequestCode = 1
    private lateinit var idolViewModel: IdolViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_listaIdols)
        val adapter =IdolAdapter(this, {idol:Idol -> obtenerIdol(idol)})
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        idolViewModel = ViewModelProviders.of(this).get(IdolViewModel::class.java)

        idolViewModel.getAll().observe(this, Observer{idols ->
            idols?.let {adapter.updateList(it)}
        })

        val button = findViewById<Button>(R.id.bt_newIdol)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, NewIdol::class.java)
            startActivityForResult(intent, newIdolActivityRequestCode)
        }
    }

    //Obtiene el idol como tal y lo pasa
    private fun obtenerIdol(idol: Idol){
        val idolBundle = Bundle()
        idolBundle.putParcelable("IDOL", idol)
        startActivity(Intent(this, DetalleIdol::class.java).putExtras(idolBundle))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newIdolActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val idol = Idol(data.getStringExtra(NewIdol.EXTRA_NOMBRE),
                        data.getStringExtra(NewIdol.EXTRA_COMPANIA),
                        data.getStringExtra(NewIdol.EXTRA_ESTATURA))
                idolViewModel.insert(idol)
            }
        } else {
            Toast.makeText(
                    applicationContext,
                    "No se pudo guardar",
                    Toast.LENGTH_LONG
            ).show()
        }
    }
}
