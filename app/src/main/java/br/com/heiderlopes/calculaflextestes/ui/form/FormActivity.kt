package br.com.heiderlopes.calculaflextestes.ui.form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.heiderlopes.calculaflextestes.R
import br.com.heiderlopes.calculaflextestes.model.CarData
import br.com.heiderlopes.calculaflextestes.ui.result.ResultActivity
import br.com.heiderlopes.calculaflextestes.ui.watchers.DecimalTextWatcher
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        etGasPrice.addTextChangedListener(DecimalTextWatcher(etGasPrice))
        etEthanolPrice.addTextChangedListener(DecimalTextWatcher(etEthanolPrice))
        etGasAverage.addTextChangedListener(DecimalTextWatcher(etGasAverage, 1))
        etEthanolAverage.addTextChangedListener(DecimalTextWatcher(etEthanolAverage, 1))

        btCalculate.setOnClickListener {

            val carData = CarData(
                etGasPrice.text.toString().toDouble(),
                etEthanolPrice.text.toString().toDouble(),
                etGasAverage.text.toString().toDouble(),
                etEthanolAverage.text.toString().toDouble()
            )

            val proximatela = Intent(this@FormActivity, ResultActivity::class.java)
            proximatela.putExtra("GAS_PRICE", etGasPrice.text.toString().toDouble())
            proximatela.putExtra("ETHANOL_PRICE", etEthanolPrice.text.toString().toDouble())
            proximatela.putExtra("GAS_AVERAGE", etGasAverage.text.toString().toDouble())
            proximatela.putExtra("ETHANOL_AVERAGE", etEthanolAverage.text.toString().toDouble())

            proximatela.putExtra("CAR_DATA", carData)

            startActivity(proximatela)

        }
    }
}
