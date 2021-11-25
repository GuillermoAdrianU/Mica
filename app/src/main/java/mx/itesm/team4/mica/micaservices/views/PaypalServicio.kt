package mx.itesm.team4.mica.micaservices.views

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import com.paypal.checkout.PayPalCheckout
import com.paypal.checkout.config.CheckoutConfig
import com.paypal.checkout.config.Environment
import com.paypal.checkout.config.SettingsConfig
import com.paypal.checkout.createorder.CurrencyCode
import com.paypal.checkout.createorder.UserAction

class PaypalServicio : Application() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate() {
        super.onCreate()
        val config = CheckoutConfig(
            application = this,
            clientId = "AWnx4pFsCB92bfSkJPP6TA3Z2YzGZR5jVDEbpkhEgWUFZ5LFAJCt97oQJEBkLFgd8hUbVsphOlqwwpab",
            environment = Environment.SANDBOX,
            returnUrl = "mx.itesm.team4.mica.micaservices://paypalpay",
            currencyCode = CurrencyCode.USD,
            userAction = UserAction.PAY_NOW,
            settingsConfig = SettingsConfig(
                loggingEnabled = true
            )
        )
        PayPalCheckout.setConfig(config)
    }
}
