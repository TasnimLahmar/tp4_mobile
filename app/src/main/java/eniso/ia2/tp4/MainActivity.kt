package eniso.ia2.tp4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import eniso.ia2.tp4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val ville = arrayOf("Sousse","Monastir","Bizert","Sfax","Nabeul","Tozeur","Djerba","Tunis")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,ville)
        binding.liste.adapter=adapter
        binding.liste.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position)
            val selectedString = selectedItem.toString()
            binding.textView4.text=selectedString
            val searchUrl = "http://www.google.fr/search?q=$selectedString"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(searchUrl))
            startActivity(intent)
        }

    }
}