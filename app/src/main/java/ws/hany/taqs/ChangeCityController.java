package ws.hany.taqs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ChangeCityController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_city_controller);

        final EditText editTextField = findViewById(R.id.queryET);
        ImageButton backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(v -> {
            // Go back and destroy the ChangeCityController
            finish();
        });

        // Buttons can have a listener for clicks.
        // EditTexts can have listeners for keyboard presses like hitting the enter key.
        editTextField.setOnEditorActionListener((v, actionId, event) -> {

            String newCity = editTextField.getText().toString();
            Intent newCityIntent = new Intent(ChangeCityController.this, MainActivity.class);

            // Adds what was entered in the EditText as an extra to the intent.
            newCityIntent.putExtra("City", newCity);

            // We started this activity for a result, so now we are setting the result.
            setResult(Activity.RESULT_OK, newCityIntent);

            // This destroys the ChangeCityController.
            finish();
            return true;
        });
    }
}