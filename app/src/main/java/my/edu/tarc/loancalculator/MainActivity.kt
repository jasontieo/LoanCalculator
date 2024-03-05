package my.edu.tarc.loancalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)//loading the UI to memory
        //R = resources/ the 'res' folder

        //Link UI to program code using the findViewById() method
        val editTextCarPrice: EditText = findViewById(R.id.editTextCarPrice)
        val exitTextDownPayment: EditText = findViewById(R.id.editTextDownPayment)
        val exitTextNumberLoadPeriod: EditText = findViewById(R.id.editTextNumberLoadPeriod)
        val editTextInterestRate: EditText = findViewById(R.id.editTextInterestRate)

        val textViewInterest: TextView = findViewById(R.id.textViewInterest)
        val textViewLoan: TextView = findViewById(R.id.textViewCarLoan)
        val textViewMonthlyPayment: TextView = findViewById(R.id.textViewMonthlyRepayment)

        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val buttonReset: Button = findViewById(R.id.buttonReset)

        //Value = val; static value
        //Variable = var

        buttonCalculate.setOnClickListener {
            //Retrieve inputs from the user
            val carPrice: Float = editTextCarPrice.text.toString().toFloat()
            val downPayment: Float = exitTextDownPayment.text.toString().toFloat()
            val loanPeriod: Int = exitTextNumberLoadPeriod.text.toString().toInt()
            val interestRate: Float = editTextInterestRate.text.toString().toFloat()

            //Calculate the loan amount, interest and monthly payment
            var carLoan: Float = 0.0f
            var interest: Float = 0.0f
            carLoan = carPrice - downPayment;

            //Display outputs
            textViewLoan.text = String.format("%s %.2f",
                getString(R.string.car_loan), carLoan)
            textViewInterest.text = String.format("%s %.2f",
                getString(R.string.interest), interest)

        }

        buttonReset.setOnClickListener {
            editTextCarPrice.text.clear()
            textViewLoan.text = ""
        }
    }
}