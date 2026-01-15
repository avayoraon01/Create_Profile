package com.example.createprofile

import android.R.attr.name
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Dashboard(){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)

        ) {

        Column(modifier = Modifier) {
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(text ="$name",
                        modifier = Modifier.padding(10.dp)
                    )
                    Text(text = "Email",
                        modifier = Modifier.padding(10.dp)
                    )
                }



            Text(text = "Welcome to the Dashboard",
            modifier = Modifier.padding(10.dp)
            )

            Text(text = "This is a sample dashboard",
                modifier = Modifier.padding(10.dp)
            )
            Text(text = "You can add more content here",
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DashboardPreview(){
    Dashboard()
}