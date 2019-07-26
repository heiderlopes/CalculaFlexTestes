package br.com.heiderlopes.calculaflextestes.ui.gasstations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.heiderlopes.calculaflextestes.R
import kotlinx.android.synthetic.main.activity_gas_station.*
import kotlinx.android.synthetic.main.include_loading.*
import org.koin.android.viewmodel.ext.android.viewModel

class GasStationsActivity : AppCompatActivity() {

    val gasStationsViewModel: GasStationsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gas_station)

        gasStationsViewModel.getGasStations()

        gasStationsViewModel.isLoading.observe(this, Observer {
            if(it == true) {
                containerLoading.visibility = View.VISIBLE
            } else {
                containerLoading.visibility = View.GONE
            }

        })

        gasStationsViewModel.messageError.observe(this, Observer {
            if(it != "") {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })

        gasStationsViewModel.gasStations.observe(this, Observer {
            rvGasStation.adapter = GasStationsAdapter(it) {
                /*val intent = Intent(this, FormPokemonActivity::class.java)
                intent.putExtra("POKEMON", it)
                startActivity(intent)
                finish()*/
            }
            rvGasStation.layoutManager = LinearLayoutManager(this)
        })

    }
}

