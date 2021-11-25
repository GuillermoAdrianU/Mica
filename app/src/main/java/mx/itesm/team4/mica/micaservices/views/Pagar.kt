package mx.itesm.team4.mica.micaservices.views

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.json.JSONException
import org.json.JSONObject
import android.util.Log
import android.widget.TextView
import android.widget.EditText
import androidx.annotation.RequiresApi
import com.paypal.checkout.approve.OnApprove
import com.paypal.checkout.createorder.CreateOrder
import com.paypal.checkout.createorder.CurrencyCode
import com.paypal.checkout.createorder.OrderIntent
import com.paypal.checkout.createorder.UserAction
import com.paypal.checkout.order.Amount
import com.paypal.checkout.order.AppContext
import com.paypal.checkout.order.Order
import com.paypal.checkout.order.PurchaseUnit
import mx.itesm.team4.mica.micaservices.databinding.ActivityPagarBinding
import java.math.BigDecimal


class Pagar : AppCompatActivity() {
    private lateinit var binding: ActivityPagarBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //configurarEventos()
        binding.payPalButton.setup(
            createOrder = CreateOrder { createOrderActions ->
                val order = Order(
                    intent = OrderIntent.CAPTURE,
                    appContext = AppContext(
                        userAction = UserAction.PAY_NOW
                    ),
                    purchaseUnitList = listOf(
                        PurchaseUnit(
                            amount = Amount(
                                currencyCode = CurrencyCode.USD,
                                value = "10.00"
                            )
                        )
                    )
                )
                createOrderActions.create(order)
            },
            onApprove = OnApprove { approval ->
                approval.orderActions.capture { captureOrderResult ->
                    Log.i("CaptureOrder", "CaptureOrderResult: $captureOrderResult")
                }
            }
        )
    }
}
