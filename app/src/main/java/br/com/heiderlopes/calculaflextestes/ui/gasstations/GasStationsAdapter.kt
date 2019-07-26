package br.com.heiderlopes.calculaflextestes.ui.gasstations

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.heiderlopes.calculaflextestes.R
import br.com.heiderlopes.calculaflextestes.model.GasStation
import kotlinx.android.synthetic.main.gas_station_item.view.*

class GasStationsAdapter(
    val gasStations: List<GasStation>,
    val clickListener: (GasStation) -> Unit
) : RecyclerView.Adapter<GasStationsAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gas_station_item, parent, false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gasStations.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = gasStations[position]
        holder.bindView(pokemon, clickListener)
    }

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(
            gasStation: GasStation,
            clickListener: (GasStation) -> Unit
        ) = with(itemView) {
            tvEthanolPrice.text = "R$ ${gasStation.ethanol}"
            tvGasolinePrice.text = "R$ ${gasStation.gasoline}"
            tvGasStationName.text = gasStation.name
            setOnClickListener { clickListener(gasStation) }
        }
    }
}