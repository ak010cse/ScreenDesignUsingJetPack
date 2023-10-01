package com.arvind.testapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.arvind.testapplication.ui.theme.TestApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Content()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content() {
    lateinit var courseList: List<ListModel>
    courseList = ArrayList()

    // in the below line, we are adding data to our list.
    courseList =
        courseList + ListModel("https://apptestsoko.s3.ap-south-1.amazonaws.com/assets/a.png")
    courseList =
        courseList + ListModel("https://apptestsoko.s3.ap-south-1.amazonaws.com/assets/m.png")
    courseList = courseList + ListModel(
        "https://apptestsoko.s3.ap-south-1.amazonaws.com/assets/fp.png"
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyToolbar(
            title = "Mandate Details"
        ) {
            // Handle back button click
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // First Row
            Card(

                onClick = {
                },

                modifier = Modifier
                    .padding(10.dp)
                    .background(Color.White),
                elevation = cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1.0f)) {
                        Text(text ="Valid Till - ", style = TextStyle(fontSize = 14.sp))
                        Text(text ="29-May-2024", style = TextStyle(fontWeight = FontWeight.Bold,fontSize = 14.sp))

                    }
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1.0f)) {
                        Text(text ="Upto Amount - ", style = TextStyle(fontSize = 14.sp))
                        Text(text ="UGX 10,000", style = TextStyle(fontWeight = FontWeight.Bold,fontSize = 14.sp))

                    }

                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp, 0.dp, 0.dp)
                ) {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.Gray)
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                // Second Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "Frequency  -  ",style = TextStyle(fontSize = 18.sp))
                    Text(text = "As presented", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp))


                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp, 0.dp, 0.dp)
                ) {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.Gray)
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(Color(android.graphics.Color.parseColor("#fff2e4")))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)

                    ){
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "Information Icon",
                            tint = Color(android.graphics.Color.parseColor("#f09a11")),
                            modifier = Modifier.size(30.dp)
                        )
                        Text(text = "The amount will be blocked when ride is booked with SafeBoard, subject to above mentioned limit and validity. The Limit is UpTo UGX 10,000.", style = TextStyle( fontSize = 18.sp))

                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Auto-pay payment Options", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),modifier = Modifier.padding(16.dp))
            Spacer(modifier = Modifier.height(5.dp))
            // Horizontal List
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ) {
                itemsIndexed(courseList) { _, item ->


                    Card(

                        onClick = {


                        },

                        modifier = Modifier
                            .padding(8.dp)
                            .width(150.dp),

                        elevation = cardElevation(
                            defaultElevation = 5.dp
                        )
                    )
                    {
                        Image(
                            painter = rememberImagePainter(
                                data = item.languageImg,
                            ),
                            contentDescription = "image",
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.White)
                                .padding(5.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Pay Using", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),modifier = Modifier.padding(10.dp))
            Spacer(modifier = Modifier.height(5.dp))

            Card(

                onClick = {

                },

                modifier = Modifier
                    .padding(10.dp)
                    .background(Color.White),
                elevation = cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){

                    Image(
                        painter = painterResource(id = R.drawable.airtel_icon),
                        contentDescription = "Back",
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text ="Airtel Money - XXX897", Modifier.weight(1.0f),style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp))
                    Image(
                        painter = painterResource(id = R.drawable.arrow_forward),
                        contentDescription = "Back"
                    )
                }
            }
        }
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyToolbar(
    title: String,
    onNavigationClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shadowElevation = 5.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(56.dp)
                .fillMaxWidth(), // Add padding as needed
            contentAlignment = Alignment.CenterStart,
        ) {
            CenterAlignedTopAppBar(

                title = {
                    Text(
                        text = title,
                        modifier = Modifier
                            .align(Alignment.Center),
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)

                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onNavigationClick() }) {
                        Image(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = "Back",
                            modifier = Modifier.padding(16.dp,0.dp,0.dp,0.dp)
                        )
                    }
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .shadow(10.dp)
            )
        }
    }
}


