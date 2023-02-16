package ua.icm.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import ua.icm.firstapp.Dice as Dice

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textTitle = findViewById<TextView>(R.id.textTitle)
        textTitle.text = "Role o d6!"
        val textButton = findViewById<TextView>(R.id.button)
        textButton.text = "Click me!"
    }

    fun onTap (view: View){
        val diceImg = findViewById<ImageView>(R.id.diceImg)
        val diceVal = rollDice(6)
        val pickImg = when(diceVal){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImg.setImageResource(pickImg)
        diceImg.contentDescription = diceVal.toString()
    }

    private fun rollDice(diceSide: Int): Int {
        val dice = Dice(diceSide)
        return dice.roll()
    }
}