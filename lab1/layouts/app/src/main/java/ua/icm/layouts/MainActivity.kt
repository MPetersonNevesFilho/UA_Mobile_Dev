package ua.icm.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ua.icm.layouts.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.calButton.setOnClickListener{ calculateTip() }
    }

    private fun calculateTip() {
        val costDouble = binding.costInput.text.toString().toDoubleOrNull()
        if (costDouble === null){
            binding.tipResult.text = ""
        }
        val tipNumber = when (binding.tipOption.checkedRadioButtonId) {
            R.id.tip20 -> 0.20
            R.id.tip18 -> 0.18
            else -> 0.15
        }
        var tipValue = costDouble!! * tipNumber

        if (binding.switchRound.isChecked){
            tipValue = kotlin.math.ceil(tipValue)
        }

        val tipFinal = NumberFormat.getCurrencyInstance().format(tipValue)
        binding.tipResult.text = getString(R.string.quantia, tipFinal)


    }


}