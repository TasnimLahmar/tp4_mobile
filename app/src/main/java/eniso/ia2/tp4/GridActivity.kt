package eniso.ia2.tp4
import android.R
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import eniso.ia2.tp4.databinding.ActivityGridBinding
class GridActivity : AppCompatActivity() {
    val ville = arrayOf("Sousse", "Monastir", "Bizert", "Sfax", "Nabeul", "Tozeur", "Djerba", "Tunis","kef")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding2 = ActivityGridBinding.inflate(layoutInflater)
        setContentView(binding2.root)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ville)
        binding2.gliste.adapter = adapter
        binding2.gliste.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position)
            val selectedString = selectedItem.toString()
            binding2.textView6.text = selectedString
            val searchUrl = "http://www.google.fr/search?q=$selectedString"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(searchUrl))
            startActivity(intent)
        }
    }

}