package de.nebensinn.fonefwd

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class RulesViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val ruleLabel: TextView = view.findViewById(R.id.ruleLabel) as TextView
}

class RulesViewAdapter(val ruleModel: RuleModel) : RecyclerView.Adapter<RulesViewHolder>() {
    override fun onBindViewHolder(holder: RulesViewHolder?, position: Int) {
        holder!!.ruleLabel.text = ruleModel.rules[position].toString()
    }

    override fun getItemCount(): Int = ruleModel.rules.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RulesViewHolder =
            RulesViewHolder(LayoutInflater.from(parent!!.context)
                    .inflate(R.layout.rule_row, parent, false))
}