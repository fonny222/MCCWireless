package christopher_fontana.mccwireless;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int discount = 10;
    int phonePlan = 50;
    int tabPlan = 30;
    int mbbPlan = 30;
    int totalPlan;
    int regularPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instantiate everything
        final RadioButton phoneChoice = (RadioButton) findViewById(R.id.radPhone);
        final RadioButton phoneTabChoice = (RadioButton) findViewById(R.id.radPhoneTablet);
        final RadioButton phoneTabMbbChoice = (RadioButton) findViewById(R.id.radPhoneTabletMBB);
        final TextView choice = (TextView) findViewById(R.id.txtChoice);
        Button submit = (Button) findViewById(R.id.btnSubmit);


        // create listener
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // this checks what is selected when submit is pressed and does something based on that
                if(phoneChoice.isChecked()){
                    choice.setText("Thank You for choosing MCC Wireless! \n" +
                            "Your Single Phone Plan will cost: $"+phonePlan+" Per Month!");
                }
                if(phoneTabChoice.isChecked()){

                    totalPlan = phonePlan + tabPlan - discount;
                    regularPrice = phonePlan + tabPlan;

                    choice.setText("ThankYou for Choosing MCC Wireless!\n"+
                    "The Phone and Tablet plan is \n eligible for a $10 Discount!\n"+
                    "Your Total Monthly bill will only cost: \n $"+totalPlan+ " instead of: $"+regularPrice);
                }
                if(phoneTabMbbChoice.isChecked()){
                    totalPlan = phonePlan + tabPlan + mbbPlan - discount;
                    regularPrice = phonePlan + tabPlan + mbbPlan;

                    choice.setText("ThankYou for Choosing MCC Wireless!\n"+
                            "The Phone, Tablet and MBB plan is \n eligible for a $10 Discount!\n"+
                            "Your Total Monthly bill will only cost: \n $"+totalPlan+ " instead of: $"+regularPrice);
                }
            }
        });

    }
}
