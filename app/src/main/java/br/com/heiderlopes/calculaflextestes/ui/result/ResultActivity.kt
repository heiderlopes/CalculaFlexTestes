package br.com.heiderlopes.calculaflextestes.ui.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.heiderlopes.calculaflextestes.R
import br.com.heiderlopes.calculaflextestes.extensions.format
import br.com.heiderlopes.calculaflextestes.model.CarData
import br.com.heiderlopes.calculaflextestes.model.Fuel
import br.com.heiderlopes.calculaflextestes.utils.CalculateUtils
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        calculate()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    private fun calculate() {
        /*val gasPrice = intent.extras?.getDouble("GAS_PRICE") ?: 0.0
        val ethanolPrice = intent.extras?.getDouble("ETHANOL_PRICE") ?: 0.0
        val gasAverage = intent.extras?.getDouble("GAS_AVERAGE") ?: 0.0
        val ethanolAverage = intent.extras?.getDouble("ETHANOL_AVERAGE") ?: 0.0*/

        val carData = intent.extras?.getParcelable<CarData>("CAR_DATA")

        carData?.run {

            val fuel = CalculateUtils.getBestFuel(ethanolAverage, gasAverage,
                ethanolPrice, gasPrice)

            if (fuel == Fuel.ETHANOL) {
                tvSuggestion.text = getString(R.string.ethanol)
            } else {
                tvSuggestion.text = getString(R.string.gasoline)
            }
            tvEthanolAverageResult.text = (ethanolPrice / ethanolAverage).format(2)
            tvGasAverageResult.text = (gasPrice / gasAverage).format(2)

            tvFuelRatio.text =
                getString(R.string.label_fuel_ratio,
                    CalculateUtils.calculateCarPerformance(ethanolAverage,
                        gasAverage).format(2))
        }
    }
}
