package com.example.idol

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.idol.data.Idol
import kotlinx.android.synthetic.main.detalle_idol.*

class DetalleIdol : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalle_idol)

        val idolEntrante : Idol? = intent.extras.getParcelable("IDOL")

        if(idolEntrante != null){
            init(idolEntrante)
        }
    }

    fun init(idol: Idol){
        tv_nombre_detalle.text =idol.nombre
        tv_compañia.text = idol. compañia
        tv_estatura.text = idol.estatura
    }
}