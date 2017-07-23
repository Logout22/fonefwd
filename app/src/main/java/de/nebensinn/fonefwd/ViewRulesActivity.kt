package de.nebensinn.fonefwd

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

val VIEWRULES_EXTRA_NEWRULE : String = "de.nebensinn.fonefwd.NEWRULE"

class ViewRulesActivity : Activity() {
    private val ruleModel = RuleModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_rules)

        ruleModel.addRule(intent.getSerializableExtra(VIEWRULES_EXTRA_NEWRULE) as Rule?)
        val rulesView = findViewById(R.id.rulesView) as RecyclerView
        rulesView.layoutManager = LinearLayoutManager(applicationContext)
        rulesView.adapter = RulesViewAdapter(ruleModel)
    }
}
