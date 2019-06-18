package com.example.idol

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NewIdol : AppCompatActivity() {
    private lateinit var editIdolName: EditText
    private lateinit var editIdolCompania: EditText
    private lateinit var editIdolEstatura: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ingresar_idol)

        editIdolName = findViewById(R.id.ed_nombre)
        editIdolCompania = findViewById(R.id.ed_compañia)
        editIdolEstatura = findViewById(R.id.ed_estatura)

        val button = findViewById<Button>(R.id.bt_guardar)

        button.setOnClickListener {
            val replyIntent = Intent()

            if(TextUtils.isEmpty(editIdolName.text)||
                    TextUtils.isEmpty(editIdolCompania.text)||
                    TextUtils.isEmpty(editIdolEstatura.text)){
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val nombre = editIdolName.text.toString()
                replyIntent.putExtra(EXTRA_NOMBRE, nombre)

                val compania = editIdolCompania.text.toString()
                replyIntent.putExtra(EXTRA_COMPANIA, compania)

                val estatura = editIdolEstatura.text.toString()
                replyIntent.putExtra(EXTRA_ESTATURA, estatura)

                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_NOMBRE = "nombre"
        const val EXTRA_COMPANIA = "compania"
        const val EXTRA_ESTATURA = "estatura"
    }
}