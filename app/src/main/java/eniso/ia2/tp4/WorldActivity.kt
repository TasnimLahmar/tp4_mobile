package eniso.ia2.tp4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import eniso.ia2.tp4.databinding.ActivityWorldBinding

class WorldActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding3 = ActivityWorldBinding.inflate(layoutInflater)
        setContentView(binding3.root)
        ArrayAdapter.createFromResource(this,   R.array.Continents,android.R.layout.simple_spinner_item).also { adapter ->adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding3.spinner2.adapter=adapter
        }
        binding3.spinner2.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, id: Long) {
             //val jomla= resources.getStringArray(R.array.Continents)[position].toString()
                when(resources.getStringArray(R.array.Continents)[position]){
                    "Afrique" -> {
                        ArrayAdapter.createFromResource(
                            binding3.spinner3.context, R.array.PaysAfr, android.R.layout.simple_spinner_item
                        ).also { adapter ->
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            binding3.spinner3.adapter = adapter
                        }

                        binding3.spinner3.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                val selectedItem = parent?.getItemAtPosition(position)
                                val selectedString = selectedItem.toString()
                                val searchUrl = "http://fr.wikipedia.org/wiki/$selectedString"
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(searchUrl))

                                startActivity(intent)
                            }

                            override fun onNothingSelected(p0: AdapterView<*>?) {
                                TODO("Not yet implemented")
                            }
                        })
                    }

                    "Europe" ->{
                        ArrayAdapter.createFromResource(
                            binding3.spinner3.context,R.array.PaysEur,android.R.layout.simple_spinner_item).also { adapter ->adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            binding3.spinner3.adapter=adapter
                        }

                    }
                    "Asie" ->{
                        ArrayAdapter.createFromResource(
                            binding3.spinner3.context,R.array.PaysAsie,android.R.layout.simple_spinner_item).also { adapter ->adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            binding3.spinner3.adapter=adapter
                        }
                    }
                    "Océanie" ->{
                        ArrayAdapter.createFromResource(
                            binding3.spinner3.context,R.array.PaysOc,android.R.layout.simple_spinner_item).also { adapter ->adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            binding3.spinner3.adapter=adapter
                        }
                    }
                      else->{
                        ArrayAdapter.createFromResource(
                            binding3.spinner3.context,R.array.PaysAm,android.R.layout.simple_spinner_item).also { adapter ->adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            binding3.spinner3.adapter=adapter
                        }
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}