package az.khayalsharifli.profilescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import az.khayalsharifli.profilescreen.factory.ProfileFactory
import az.khayalsharifli.profilescreen.ui.theme.ProfileScreenTheme
import az.khayalsharifli.profilescreen.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreenTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    Profile()
                }
            }
        }
    }
}

@Composable
fun Profile() {
    val profile = ProfileFactory.getProfileData()
    LazyColumn {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {

                Spacer(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(colorResource(id = R.color.purple_700))
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp)
                        .align(Alignment.BottomCenter)
                        .background(Color.White)
                )

                Row(
                    modifier = Modifier
                        .padding(top = 16.dp, start = 8.dp, end = 8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_drawer),
                        contentDescription = "Drawer menu",
                        modifier = Modifier
                            .size(20.dp)
                    )

                    Text(
                        text = "PROFILE",
                        modifier = Modifier,
                        color = Color.White,
                        style = Typography.body2
                    )

                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_settings),
                        contentDescription = "Settings",
                        modifier = Modifier
                            .size(20.dp)
                    )
                }

                Card(
                    modifier = Modifier
                        .size(150.dp)
                        .align(Alignment.BottomCenter),
                    shape = CircleShape,
                    elevation = 2.dp,
                    border = BorderStroke(3.dp, Color.White)
                ) {
                    Image(
                        painter = painterResource(profile.avatarUrl),
                        contentDescription = "Profile Photo",
                        modifier = Modifier,
                        contentScale = ContentScale.Crop,
                    )
                }
            }
        }

        item {
            Column {
                Text(
                    text = "Khayal Sharifli",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp), fontWeight = FontWeight.Bold, fontSize = 22.sp
                )
                Text(
                    text = "Admin", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()
                )
            }

        }

        items(count = 1) {
            TextField("Email", profile.email)
        }
        items(count = 1) {
            TextField("Phone", profile.telephone)
        }
        items(count = 1) {
            TextField("Gender", profile.gender)
        }
        items(count = 1) {
            TextField("Customer No", profile.customerNo.toString())
        }
    }
}

@Composable
fun TextField(title: String, body: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 12.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 6.dp),
            color = Color.Blue,
            style = Typography.body2
        )
        Text(text = body)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(colorResource(id = R.color.purple_700))
                .padding(top = 6.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileScreenTheme {
        Profile()
    }
}