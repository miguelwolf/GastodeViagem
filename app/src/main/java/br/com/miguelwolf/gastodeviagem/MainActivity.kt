package br.com.miguelwolf.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainBtnCalcular.setOnClickListener(this);

    }

    override fun onClick(v: View) {

        when (v.id) {
            R.id.mainBtnCalcular -> calculate();
            else -> {
                print("Click not implemented")
            }
        }

    }


    private fun calculate() {

        if (validationOk()) {

            try {
                val distance = mainEtDistancia.text.toString().toFloat()
                val price = mainEtPreco.text.toString().toFloat()
                val autonomy = mainEtAutonomia.text.toString().toFloat()

                val totalValue = (distance * price) / autonomy

                mainTvGastoTotalValor.text = "R$ ${"%.2f".format(totalValue)}"

            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.informe_valores_validos), Toast.LENGTH_LONG).show()
            }

        } else {
            Toast.makeText(this, getString(R.string.preencha_campos), Toast.LENGTH_LONG).show()
        }

    }

    private fun validationOk() : Boolean {

        return (mainEtDistancia.text.toString().trim().isNotEmpty() &&
                mainEtPreco.text.toString().trim().isNotEmpty() &&
                mainEtAutonomia.text.toString().trim().isNotEmpty() &&
                !mainEtAutonomia.text.toString().equals("0"))

    }

}