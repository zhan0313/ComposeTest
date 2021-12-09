package com.jason.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jason.compose.ui.theme.ComposeTestTheme

@Composable
fun setData2List(list: List<Person>) {
    Column() {
        LazyRow(content = {
            itemsIndexed(list) { int,person ->
                ListItem(person = person)

            }
        })
        LazyColumn(content = {
            items(list) { person ->
                ListItem(person = person)
            }

        })
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme(darkTheme = false) {
                val list = mutableListOf<Person>()
                for (i in 0 until 100) {
                    list.add(
                        Person(
                            "name${i}", "内容哈哈哈哈我是${i}",
                            if (i % 2 == 0) R.mipmap.pic else R.mipmap.ic_launcher_round
                        )
                    )
                }
                setData2List(list)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier.padding(2.dp)) {
    Text(
        text = "$name!",
        modifier = modifier,
        style = MaterialTheme.typography.body1
    )
}

data class Person(val name: String, val describe: String, val pic: Int)




@Composable
fun ListItem(person: Person) {
    ComposeTestTheme(darkTheme = false) {
        Row(
            Modifier
                .padding(10.dp)
                .size(Dp.Unspecified, 50.dp)
                .clickable {
                    Toast
                        .makeText(MainActivity(), "点击了Item", Toast.LENGTH_SHORT)
                        .show()
                },
            Arrangement.Start,
            Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = person.pic),
                "我是测试头像",
                Modifier
                    .size(50.dp)
                    .clip(CircleShape),
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Greeting(person.name)
                Spacer(modifier = Modifier.width(4.dp))
                Greeting(person.describe)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTestTheme(darkTheme = false) {
        val list = mutableListOf<Person>()
        for (i in 0 until 100) {
            list.add(
                Person(
                    "name${i}", "内容哈哈哈哈垃圾你是我是${i}",
                    if (i % 2 == 0) R.mipmap.pic else R.mipmap.pic
                )
            )
        }
        Column() {
            setData2List(list)

        }
    }

}



